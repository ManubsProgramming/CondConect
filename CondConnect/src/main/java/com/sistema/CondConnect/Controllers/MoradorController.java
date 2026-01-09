package com.sistema.CondConnect.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MoradorController {

    @GetMapping("/morador/dashboard")
    public String dashboard() {
        return "morador/dashboard"; // src/main/resources/templates/morador/dashboard.html
    }
}
