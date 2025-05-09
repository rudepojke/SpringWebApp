package org.farid.faridspringwebapp.controller;

import org.farid.faridspringwebapp.model.ApplicationAdmin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin(Model model) {
        List<ApplicationAdmin> docs = List.of(
                new ApplicationAdmin("Rapport A", "Detaljer om A"),
                new ApplicationAdmin("Rapport B", "Detaljer om B")
        );
        model.addAttribute("documents", docs);
        return "admin";
    }
}
