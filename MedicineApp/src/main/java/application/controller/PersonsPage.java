package application.controller;

import application.model.Person;
import application.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonsPage {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/persons")
    public String getPersonsPage(Model model){
        List<Person> persons = personRepo.findAll();
        model.addAttribute("persons", persons);
        return "persons.html";
    }
}
