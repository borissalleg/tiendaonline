package com.empleado.v1.controller;

import com.empleado.v1.repository.CategoriaRepository;
import com.empleado.v1.service.Usuario.UsuarioServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/usuario")
public class usuarioController {
    @Autowired
    UsuarioServiceImp usuario;
    @Autowired
    CategoriaRepository catego;

    
    
    @GetMapping(value="/create")
    public String createUsuario(Model model){

        model.addAttribute("categoria",catego.findAll() );
        
        return "/usuarios/formUsuario";
    }
}
