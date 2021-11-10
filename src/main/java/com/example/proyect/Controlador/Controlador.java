package com.example.proyect.Controlador;

import com.example.proyect.Interfaz.PersonaI;
import com.example.proyect.Modelo.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/persona")
public class Controlador{


    @Autowired
    private PersonaI personaI;


    @GetMapping("")
    public String home(Model model){
        model.addAttribute("persona", personaI.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(){
        return "form";
    }

    @PostMapping("/save")
    public String save(Persona personas ){
        personaI.save(personas);
        return "redirect:/persona";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Persona p= personaI.getOne(id);
        model.addAttribute("personas", p);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Persona p= personaI.getOne(id);
        personaI.delete(p);
        return "redirect:/persona"; 
    }

    
}