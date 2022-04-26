package com.empleado.v1.controller;

import com.empleado.v1.repository.PerfilesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/perfil")
public class perfilController {
    @Autowired
    PerfilesRepository perfilRepository;

    @GetMapping(value="/list")
    public String listarPerfiles(Model model){
        model.addAttribute("listaPerfiles" , perfilRepository.findAll());

          return "/perfiles/listPerfil";

    }
}
