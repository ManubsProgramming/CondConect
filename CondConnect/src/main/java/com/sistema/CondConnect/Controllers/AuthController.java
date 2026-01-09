package com.sistema.CondConnect.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public String acessarLogin(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               org.springframework.ui.Model model) {
        if (error != null) {
            model.addAttribute("errorMsg", "Usuário ou senha inválidos.");
        }
        if (logout != null) {
            model.addAttribute("msg", "Você saiu com sucesso.");
        }
        return "auth/login"; 
                          

    }
@GetMapping("/auth/home")
public String homeRedirect(Authentication authentication) {
    if (authentication.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_SINDICO"))) {
        return "redirect:/sindico/dashboard";
    } else if (authentication.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_PORTEIRO"))) {
        return "redirect:/porteiro/dashboard";
    } else if (authentication.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_MORADOR"))) {
        return "redirect:/morador/dashboard";
    } else {
        return "redirect:/auth/login?error";
    }
}

}
