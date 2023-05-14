package application.controller;

import application.enums.Status;
import application.model.AdditionalFieldValues;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class FormsPage {
    int id;
    Person person;

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
        List<Form> formList = formRepo.findByStatus(Status.EXIST);
        model.addAttribute("forms", formList);
        return "forms.html";
    }

    @GetMapping("/forms/create/{id}")
    public String getCreateFormPage(@PathVariable int id, Model model){
        this.id = id;
        Form form = new Form();

        for (int i = 0; i < fieldRepo.findAll().size(); i++) {
            AdditionalFieldValues value = new AdditionalFieldValues();
            value.setForm(form);
            form.getValues().add(value);
        }

        model.addAttribute("values", form.getValues());
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

    @PostMapping("/form/create")
    public String createForm(@ModelAttribute("form") Form form){
        for (int i = 0; i < form.getValues().size(); i++) {
            form.getValues().get(i).setForm(form);
            form.getValues().get(i).setAdditionalField(fieldRepo.findByIdField(i+1));
        }
        System.out.println(id);
        Person person = personRepo.findByIdPeople(id);
        form.setPerson(person);

        for (int i = 0; i < form.getValues().size(); i++) {
            String value = form.getValues().get(i).getValue();
            if(value.isBlank()||value==""){
                form.getValues().remove(i);
                i--;
            }
        }
        form.setStatus(Status.EXIST);
        formRepo.save(form);
        return "redirect:/forms";
    }

    @GetMapping("/forms/byPerson/{id}")
    public String formsByPerson(@PathVariable int id, Model model){
        Person person = personRepo.findByIdPeople(id);
        List<Form> list = formRepo.findByPersonAndStatus(person, Status.EXIST);
        model.addAttribute("forms", list);
        return "personForms.html";
    }

    @PostMapping("/form/delete/{id}")
    public String deleteForm(@PathVariable int id){
        Form form = formRepo.findByIdForm(id);
        form.setStatus(Status.DELETED);
        formRepo.save(form);
        return "redirect:/forms";
    }

    @PostMapping("/person/form/delete/{id}")
    public String deletePersonForm(@PathVariable int id){
        Form form = formRepo.findByIdForm(id);
        int index = form.getPerson().getIdPeople();
        form.setStatus(Status.DELETED);
        formRepo.save(form);
        return "redirect:/forms/byPerson/"+index+"?";
    }
}
