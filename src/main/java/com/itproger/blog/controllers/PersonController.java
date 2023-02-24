package com.itproger.blog.controllers;

import com.itproger.blog.models.Person;
import com.itproger.blog.models.Post;
import com.itproger.blog.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public String person(Model model) {
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);

        model.addAttribute("title", "Работники сайта");
        return "person";
    }

    @GetMapping("/person/add")
    public String personAdd(Model model) {
        Iterable<Person> persons = personRepository.findAll();
        model.addAttribute("persons", persons);
        return "person-add";
    }

    @PostMapping("/person/add")
    public String personPostAdd(@RequestParam String position, @RequestParam String full_name, Model model) {
        Person person = new Person(full_name, position);
        personRepository.save(person);
        return "redirect:/person";
    }

    @GetMapping("/person/{id}/edit")
    public String personEdit(@PathVariable(value = "id") long id, Model model) {
        if (!personRepository.existsById(id)) {
            return "redirect:/person";
        }

        Optional<Person> person = personRepository.findById(id);
        ArrayList<Person> res = new ArrayList<>();
        person.ifPresent(res::add);
        model.addAttribute("persons", res);

        return "person-edit";
    }

    @PostMapping("/person/{id}/edit")
    public String personPostUpdate(@PathVariable(value = "id") long id, @RequestParam String position, @RequestParam String full_name, Model model) {
        Person person = personRepository.findById(id).orElseThrow();
        person.setFull_name(full_name);
        person.setPosition(position);
        personRepository.save(person);

        return "redirect:/person";
    }

    @PostMapping("/person/{id}/remove")
    public String personPostDelete(@PathVariable(value = "id") long id, Model model) {
        Person persson = personRepository.findById(id).orElseThrow();
        personRepository.delete(persson);

        return "redirect:/person";
    }
}
