package controller;

import dal.entities.PartEntity;
import dal.entities.UsersEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ModelAndView logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public ModelAndView loginError(ModelAndView modelAndView) {
        modelAndView.addObject("error", "true");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelAndView modelAndView) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Configuration cfg = new Configuration();
        cfg.configure("sessionFactory.xml");// populates the data of the
        // configuration file

        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        // creating session object
        Session session = factory.openSession();

        // creating transaction object
        Transaction t = session.beginTransaction();

        Query query= session.createQuery("from UsersEntity where login=:login");
        query.setParameter("login", auth.getName());
        UsersEntity user = (UsersEntity) query.uniqueResult();

        Criteria criteria = session.createCriteria(PartEntity.class);
        List<PartEntity> parts = criteria.list();

        List<PartEntity> rootParts = new ArrayList<>();

        for (PartEntity part:parts) {
            if(part.getParentId() == null)
            {
                rootParts.add(part);
            }
        }

        modelAndView.getModelMap().put("parts", rootParts);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
