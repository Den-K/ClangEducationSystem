package sphereengine.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import sphereengine.dto.ResultDTO;
import sphereengine.dto.SubmissionDTO;
import sphereengine.dto.SubmissionKeyDTO;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/sphere")
public class SphereRest {

    private static final String ACCESS_TOKEN = "?access_token=bc1cd602d94a863e975e7c554b707fdc";
    private static final String LANGUAGE_KEY = "44"; //C language
    private static final String SPHERE_URL = "http://api.compilers.sphere-engine.com";
    private static final String ENDPOINT_URL = "/api/3/submissions";

    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    private void init() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(new ArrayList(Arrays.asList(new MediaType("*", "json", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET), new MediaType("*", "html", MappingJackson2HttpMessageConverter.DEFAULT_CHARSET))));
        restTemplate.getMessageConverters().add(converter);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String submitCode(@RequestParam String sourceCode, @RequestParam(required = false) String input,
                                   @RequestParam(required = false) String login) throws Exception {

        SubmissionDTO submissionDTO = new SubmissionDTO();
        submissionDTO.setSourceCode(sourceCode);
        submissionDTO.setLanguage(LANGUAGE_KEY);
        if(input != null) submissionDTO.setInput(input);

        SubmissionKeyDTO submissionKeyDTO = getSubmissionKey(submissionDTO);

        ResultDTO resultDTO = null;
        if(!(submissionKeyDTO.getId() == null))
            try {
                resultDTO = getResultDTO(submissionKeyDTO.getId());
            } catch (Exception e) {
                throw new Exception(resultDTO.getStderr());
            }

        String message = null;
        if(login != null) {
            String userResult = resultDTO.getOutput();
            if(userResult.equals("Hello, " + login))
                message = "Right!";
            else
                message = "Wrong! Your result: " + userResult;

        }

        return message;
    }

    private ResultDTO getResultDTO(String submissionKey) throws Exception {
        String submissionResultUrl = String.format("%s%s%s%s%s", SPHERE_URL, ENDPOINT_URL, "/"+submissionKey, ACCESS_TOKEN,"&withSource=1&withInput=1&withOutput=1&withStderr=1&withCmpinfo=1");
        int status = -1;
        int result;
        ResultDTO resultDTO = null;
        while(status != 0) {
            resultDTO = restTemplate.getForObject(submissionResultUrl, ResultDTO.class);
            status = Integer.parseInt(resultDTO.getStatus());
            result = Integer.parseInt(resultDTO.getResult());

            if(status == 0 && result != 15) {
                throw new Exception();
            }
        }

        return resultDTO;
    }

    private SubmissionKeyDTO getSubmissionKey(SubmissionDTO submissionDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SubmissionDTO> httpRequestSubmission = new HttpEntity<>(submissionDTO,headers);
        String submissionUrl = String.format("%s%s%s", SPHERE_URL, ENDPOINT_URL, ACCESS_TOKEN);
        return restTemplate.postForObject(submissionUrl, httpRequestSubmission, SubmissionKeyDTO.class);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllExceptions(Exception e) {

        ModelAndView model = new ModelAndView("errors/compilation_error");
        model.addObject("errorMessage", e.getMessage());

        return model;

    }
}
