package controller;

import dal.entities.ParagraphEntity;
import dal.entities.PartEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

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

    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public ModelAndView loginError(ModelAndView modelAndView) {
        modelAndView.addObject("error", "true");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelAndView modelAndView) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.addObject("login", auth.getName());

        Configuration cfg = new Configuration();
        cfg.configure("sessionFactory.xml");// populates the data of the
        // configuration file

        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        // creating session object
        Session session = factory.openSession();

        // creating transaction object
        Transaction t = session.beginTransaction();

        Criteria criteria = session.createCriteria(PartEntity.class);
        List<PartEntity> parts = criteria.list();

        final Map<Integer,PartEntity> parents = new HashMap<>();

        for (PartEntity part:parts) {
            parents.put(part.getPartId(), part);
        }

        Collections.sort(parts, new Comparator<PartEntity>() {
            @Override
            public int compare(PartEntity o1, PartEntity o2) {
                Integer parentId1 = o1.getParentId();
                Integer parentId2 = o2.getParentId();

                if(parentId1 == null && parentId2 == null) {
                    return o1.getOrderNo().compareTo(o2.getOrderNo());
                }

                PartEntity parent2 = null;

                if(parentId2 != null) {
                    parent2 = parents.get(o2.getParentId());
                }

                PartEntity parent1 = null;

                if(parentId1 != null) {
                    parent1 = parents.get(o1.getParentId());
                }

                Integer index1;
                Integer index2;

                if(parent1 == null) {
                    index1 = o1.getOrderNo()*1000;
                } else {
                    index1 = parent1.getOrderNo() * 1000 + o1.getOrderNo();
                }

                if(parent2 == null) {
                    index2 = o2.getOrderNo()*1000;
                } else {
                    index2 = parent2.getOrderNo() * 1000 + o2.getOrderNo();
                }


                return index1.compareTo(index2);
            }
        });

        modelAndView.getModelMap().put("parts", parts);

        criteria = session.createCriteria(ParagraphEntity.class);
        List<ParagraphEntity> paragraphs = criteria.list();

        modelAndView.getModelMap().put("paragraphs", paragraphs);

        modelAndView.setViewName("main");
        return modelAndView;
    }
}
