package controller;

import dal.dao.UserDao;
import dal.entities.UsersEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView registration(HttpServletRequest request, ModelAndView modelAndView)
    {
        String login = request.getParameter("login");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");

        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setLogin(login);
        usersEntity.setPassword(password);
        usersEntity.setName(firstName);
        usersEntity.setSurname(lastName);
        try {
            userDao.add(usersEntity);
        }
        catch (DuplicateKeyException e) {
            log.error("Duplicate user entry: " + login);
            modelAndView.addObject("duplicate_error", login);
            modelAndView.setViewName("registration");
        }

        return modelAndView;
    }
}
