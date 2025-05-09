package org.farid.faridspringwebapp.controller;

import org.farid.faridspringwebapp.model.ApplicationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ManagerController {

    /**
     * Hanterar GET /manager.
     * Lägger in en lista med ManagerInfo-objekt i modellen.
     */
    @GetMapping("/manager")
    public String managerPage(Model model) {
        // några exempelobjekt
        List<ApplicationManager> infos = List.of(
                new ApplicationManager("Översikt", "Här är en sammanfattning av statistiken."),
                new ApplicationManager("Rapport", "Detaljerad rapport från senaste kvartalet."),
                new ApplicationManager("Uppgifter", "Lista på tilldelade uppgifter.")
        );

        // Lägg listan i modellen under attributnamnet "infos"
        model.addAttribute("infos", infos);
        return "manager";  // Thymeleaf-vyn manager.html
    }
}
