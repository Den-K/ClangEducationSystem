package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationPage(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelAndView modelAndView) {
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public ModelAndView loginError(ModelAndView modelAndView)
    {
        modelAndView.addObject("error", "true");
        modelAndView.setViewName("redirect:/page/login");
        return modelAndView;
    }
}
