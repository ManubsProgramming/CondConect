package com.sistema.CondConnect.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SindicoController {

    @GetMapping("/sindico/dashboard")
    public String dashboard() {
        return "sindico/dashboard"; // src/main/resources/templates/sindico/dashboard.html
    }
}
