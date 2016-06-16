package controller;

import dal.entities.AnswerEntity;
import dal.entities.PartEntity;
import dal.entities.QuestionEntity;
import dal.entities.UsersEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("page")
public class PageController {

    private Session getSession()
    {
        Configuration cfg = new Configuration();
        // configuration file
        cfg.configure("sessionFactory.xml");// populates the data of the

        // creating session factory object
        SessionFactory factory = cfg.buildSessionFactory();

        // creating session object
        return factory.openSession();
    }

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

        Session session = null;
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            session = getSession();

            Query query = session.createQuery("from UsersEntity where login=:login");
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

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public ModelAndView getQuestion(@RequestParam int id)
    {
        ModelAndView modelAndView = new ModelAndView();

        Session session = null;

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            session = getSession();

            Query userQuery = session.createQuery("from UsersEntity where login=:login");
            userQuery.setParameter("login", auth.getName());
            UsersEntity user = (UsersEntity) userQuery.uniqueResult();

            Query questionQuery = session.createQuery("from QuestionEntity where questionId=:id");
            questionQuery.setParameter("id", id);
            QuestionEntity question = (QuestionEntity) questionQuery.uniqueResult();

            modelAndView.addObject("user", user);
            modelAndView.addObject("question", question);
            modelAndView.setViewName("question");

            return modelAndView;

    }

    @RequestMapping(value = "/answer", method = RequestMethod.POST)
    public ModelAndView getNextQuestionFromAnswer(@RequestParam int answerId)
    {
        Session session =  getSession();

        Query query = session.createQuery("from AnswerEntity where answerId=:answer");
        query.setParameter("answer", answerId);
        AnswerEntity answer = (AnswerEntity) query.uniqueResult();

        QuestionEntity question = answer.getQuestionEntity();

        return getQuestion(question.getQuestionId()+1);

    }
}
