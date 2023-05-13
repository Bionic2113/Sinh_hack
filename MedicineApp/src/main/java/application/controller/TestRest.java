package application.controller;

import application.model.Form;
import application.model.Person;
import application.repository.FormRepo;
import application.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class TestRest {

    @Autowired
    PersonRepo peopleRepo;

    @Autowired
    FormRepo formRepo;

    @GetMapping("/people")
    public Person getPeople(){
        return peopleRepo.findById(1).orElseThrow();
    }

    @GetMapping("/form")
    public Form getForm(){
        return formRepo.findById(1).orElseThrow();
    }

}
