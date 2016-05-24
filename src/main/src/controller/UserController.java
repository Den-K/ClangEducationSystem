package controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView userRegistration(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:/page/main");
        return modelAndView;
    }
}
