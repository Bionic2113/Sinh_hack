package application.controller;

import application.model.Form;
import application.model.Person;
import application.repository.AdditionalFieldRepo;
import application.repository.AdditionalFieldValuesRepo;
import application.repository.FormRepo;
import application.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FormsPage {
    @Autowired
    FormRepo formRepo;

    @Autowired
    PersonRepo personRepo;

    @Autowired
    AdditionalFieldRepo fieldRepo;

    @Autowired
    AdditionalFieldValuesRepo valuesRepo;

    @GetMapping("/forms")
    public String getFormsPage(Model model){
        List<Form> formList = formRepo.findAll();
        model.addAttribute("forms", formList);
        return "forms.html";
    }

    @GetMapping("/forms/create/{id}")
    public String getCreateFormPage(@PathVariable int id, Model model){
        Person person = personRepo.findByIdPeople(id);
        Form form = new Form();
        form.setPerson(person);

        model.addAttribute("form", form);
        model.addAttribute("fields", fieldRepo.findAll());

        return "createForm.html";
    }

    @GetMapping("/form/{id}")
    public String getFormPage(@PathVariable int id, Model model){
        Form form = formRepo.findByIdForm(id);
        model.addAttribute("form", form);
        model.addAttribute("fields", fieldRepo.findAll());
        model.addAttribute("values", valuesRepo.findAll());
        return "form.html";
    }
}
