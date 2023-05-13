package application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePage {

    @GetMapping(value = {"/", "", "/welcome"})
    public String getString(){
        return "welcome.html";
    }
}
