package com.itproger.blog.controllers;

import com.itproger.blog.models.Post;
import com.itproger.blog.repo.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

//    @Autowired
//    private PeopleRepository peopleRepository;

    @GetMapping("/peoples")
    public String peoples(Model model) {
//        Iterable<Post> peoples = peopleRepository.findAll();
//        model.addAttribute("peoples", peoples);
        model.addAttribute("title", "Работники сайта");
        return "peoples";
    }
}
