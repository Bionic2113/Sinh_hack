package application.controller;

import application.enums.Status;
import application.model.Form;
import application.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FormSorting {
    @Autowired
    FormRepo formRepo;

    @GetMapping("/forms/byDate")
    public String formsByDate(Model model){
        List<Form> list = formRepo.findByStatus(Status.EXIST,Sort.by(Sort.Direction.ASC, "date"));
        model.addAttribute("forms", list);
        return "forms.html";
    }

    @GetMapping("/forms/byFirstname")
    public String formsByFirstname(Model model){
        List<Form> list = formRepo.findByStatus(Status.EXIST,Sort.by(Sort.Direction.ASC, "person.firstname"));
        model.addAttribute("forms", list);
        return "forms.html";
    }

    @GetMapping("/forms/byLastname")
    public String formsByLastname(Model model){
        List<Form> list = formRepo.findByStatus(Status.EXIST,Sort.by(Sort.Direction.ASC, "person.lastname"));
        model.addAttribute("forms", list);
        return "forms.html";
    }

    @GetMapping("/forms/byFather")
    public String formsByFather(Model model){
        List<Form> list = formRepo.findByStatus(Status.EXIST,Sort.by(Sort.Direction.ASC, "person.father"));
        model.addAttribute("forms", list);
        return "forms.html";
    }

    @GetMapping("/forms/byBirthDate")
    public String formsByBirthDate(Model model){
        List<Form> list = formRepo.findByStatus(Status.EXIST,Sort.by(Sort.Direction.ASC, "person.birthDate"));
        model.addAttribute("forms", list);
        return "forms.html";
    }

}
