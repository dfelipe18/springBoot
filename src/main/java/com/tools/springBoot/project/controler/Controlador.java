package com.tools.springBoot.project.controler;


import com.tools.springBoot.project.interfaceService.IpersonaService;
import com.tools.springBoot.project.modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IpersonaService service;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/crear")
    public String agregar(Model model) {
        model.addAttribute("persona", new Persona());
        return "form";
    }

    @PostMapping("/guardar")
    public String save(@Validated Persona p, Model model) {
        service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<Persona> persona = service.listarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String delete(Model model, @PathVariable int id) {
        service.delete(id);
        return "redirect:/listar";
    }
}
