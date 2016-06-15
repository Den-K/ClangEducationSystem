package sphereengine.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sphereengine.dto.SubmissionDTO;

@RestController
@RequestMapping("/api/sphere")
public class SphereRest {

    private static final String ACCESS_TOKEN = "bc1cd602d94a863e975e7c554b707fdc";
    private static final String LANGUAGE_KEY = "11"; //C language

    @RequestMapping("/")
    public void submitCode(String sourceCode, String input) {

        SubmissionDTO submissionDTO = new SubmissionDTO();
        submissionDTO.setSourceCode(sourceCode);
        submissionDTO.setLanguage(LANGUAGE_KEY);
        submissionDTO.setInput(input);

        RestTemplate restTemplate = new RestTemplate();

    }
}
