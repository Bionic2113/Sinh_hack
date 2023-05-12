package application.controller;

import application.model.Form;
import application.model.People;
import application.repository.FormRepo;
import application.repository.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRest {

    @Autowired
    PeopleRepo peopleRepo;

    @Autowired
    FormRepo formRepo;

    @GetMapping("/people")
    public People getPeople(){
        return peopleRepo.findByIdPeople(1);
    }

    @GetMapping("/form")
    public Form getForm(){
        return formRepo.findByIdForm(1);
    }

}
