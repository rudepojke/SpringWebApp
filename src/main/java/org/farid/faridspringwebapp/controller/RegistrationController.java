package org.farid.faridspringwebapp.controller;

import org.farid.faridspringwebapp.service.RegistrationRequest;
import org.farid.faridspringwebapp.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("regRequest", new RegistrationRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("regRequest") RegistrationRequest req,
                               BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "register";
        }
        try {
            registrationService.register(req);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
        return "redirect:/login";
    }
}
