package application.controller;

import application.model.Form;
import application.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FormsPage {
    @Autowired
    FormRepo formRepo;

    @GetMapping("/forms")
    public String getFormsPage(Model model){
        List<Form> formList = formRepo.findAll();
        model.addAttribute("forms", formList);
        return "forms.html";
    }
}
