package com.example.proyect.Controlador;

import javax.servlet.http.HttpSession;

import com.example.proyect.Modelo.Usuario;
import com.example.proyect.Servicio.IUsuarioS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private")
public class PrivateController {
    
    @Autowired
    private IUsuarioS usuarioS; 

    @GetMapping("/index")
    public String index(Authentication auth, HttpSession session){

        String username = auth.getName();

        if(session.getAttribute("usuario") == null){
            Usuario usuario = usuarioS.findByUsername(username);
            usuario.setPassword(null);
            session.setAttribute("usuario", usuario);
        }
        return"index";
    }
}
