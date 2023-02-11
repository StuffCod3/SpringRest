package ru.stuff.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stuff.spring.DAO.PersonDAO;
import ru.stuff.spring.models.Person;

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

    @GetMapping("/people/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping("/people")
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "people/list_people";
    }
}
