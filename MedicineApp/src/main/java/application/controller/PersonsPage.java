package application.controller;

import application.model.Form;
import application.model.Person;
import application.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonsPage {
    int id;
    List<Form>list;

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/persons")
    public String getPersonsPage(Model model){
        List<Person> persons = personRepo.findAll();
        model.addAttribute("persons", persons);
        return "persons.html";
    }

    @GetMapping("/person/create")
    public String getCreatePersonPage(Model model){
        Person person = new Person();
        model.addAttribute("person", person);
        return "createPerson.html";
    }

    @PostMapping("/person/create")
    public String createPerson(@ModelAttribute("person")Person person){
        personRepo.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/person/update/{id}")
    public String getUpdatePersonPage(@PathVariable int id, Model model){
        Person person = personRepo.findByIdPeople(id);
        this.id = id;
        list = person.getFormList();
        model.addAttribute("person", person);
        return "updatePerson.html";
    }

    @PostMapping("/person/update")
    public String getUpdatePersonPage(@ModelAttribute("person") Person person){
        System.out.println(person.getIdPeople());
        person.setIdPeople(id);
        person.setFormList(list);
        System.out.println(person.getIdPeople());
        personRepo.save(person);
        return "redirect:/persons";
    }
}
