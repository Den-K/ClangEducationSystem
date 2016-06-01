package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("login")
public class LoginController
{
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView modelAndView, Principal principal)
    {
        String name = principal.getName();
        modelAndView.addObject("login", name);
        modelAndView.setViewName("redirect:/page/main");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
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
