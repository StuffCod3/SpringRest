package ru.stuff.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.stuff.spring.DAO.PersonDAO;

@Controller
public class PeopleController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/people/list")
    public String showAllPerson(Model model){
        model.addAttribute("people", personDAO.showAllPerson());
        return "people/list_people";
    }

    @GetMapping("/people/{id}")
    public String showPersonById(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.showPersonById(id));
        return "people/person";
    }

    @GetMapping("/")
    public String welcome(){
        return "main/main";
    }
}
