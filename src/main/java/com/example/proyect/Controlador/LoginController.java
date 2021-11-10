package com.example.proyect.Controlador;

import com.example.proyect.Modelo.Usuario;
import com.example.proyect.Servicio.IUsuarioS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @Autowired
    private IUsuarioS usuarioS;

    @GetMapping("/auth/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";

    }

    @GetMapping("/auth/registro") 
    public String registroForm(Model model){
        model.addAttribute("usuario", new Usuario());

        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@Validated @ModelAttribute Usuario usuario, BindingResult result,Model model){
        if(result.hasErrors()){
            return "redirect:/auth/registro";
        }else{
            model.addAttribute("usuario", usuarioS.registrar(usuario));
        }
        return "redirect:/auth/login";
    }
}
