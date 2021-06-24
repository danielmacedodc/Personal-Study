package com.globallabs.springwebmvc.controller;

import com.globallabs.springwebmvc.model.Jedi;
import com.globallabs.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class JediController {

    @Autowired
    private JediRepository jediRepository;

    @GetMapping("/jedi")
    public ModelAndView jedi()
    {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        //final Jedi luke = new Jedi("Luke", "Skywalker");
        modelAndView.addObject("allJedi", jediRepository.getAllJedi());

        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");

        //final Jedi luke = new Jedi("Luke", "Skywalker");
        modelAndView.addObject("jedi", new Jedi());

        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Validated @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes)
    {
        if(result.hasErrors()){
            return "new-jedi";
        }

        jediRepository.add(jedi);

        redirectAttributes.addFlashAttribute("message", "Congrats! The Jedi is now within the Jedi Council!");

        return "redirect:jedi";
    }

}
