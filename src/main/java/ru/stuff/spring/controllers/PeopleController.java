package ru.stuff.spring.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "people/new";
        }else {
            personDAO.save(person);
            return "redirect:/people/list";
        }
    }

    @GetMapping("/people/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.showPersonById(id));
        return "people/edit";
    }

    @PatchMapping("/people/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personDAO.update(id, person);
        return "redirect:/people/list";
    }

    @DeleteMapping("/people/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people/list";
    }
}
