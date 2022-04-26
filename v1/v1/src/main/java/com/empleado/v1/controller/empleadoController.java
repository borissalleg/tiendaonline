package com.empleado.v1.controller;


import com.empleado.v1.model.Empleado;

import com.empleado.v1.repository.EmpleadoRepository;
import com.empleado.v1.util.Utileria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/empleado")
public class empleadoController {
    
    private final Logger logg = LoggerFactory.getLogger(Empleado.class);
   
    //@Value("${empleado.v1.ruta.images}")
    //private String ruta;

    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    
   @GetMapping(value="/create")
    public String createEmpleado(){
        return"empleados/formEmpleado";

    }

    @GetMapping("/list")
    public String retornaEmpleados(Model model){
        List<Empleado> empleado = empleadoRepository.findAll();
        List<Empleado> empleadoSort = empleado.stream().sorted((x,y) -> x.getNombre().compareToIgnoreCase(y.getNombre())).collect(Collectors.toList());
        model.addAttribute("listaE",empleadoSort);
        return "empleados/listarEmpleados";
    }

    @PostMapping("/save")
    public String saveEmpleado(@RequestParam(name="archivoImg", required = false) MultipartFile multipart,  Empleado e, Model model, RedirectAttributes attributes){
        logg.info("Informacion sobre el objeto empleado ", e);
        if (!multipart.isEmpty()){
          
            String ruta ="C://Temp//uploads/";
          
            try {
                 String rd = Utileria.guardarArchivo(multipart, ruta);
                 e.setImagenFoto(rd);
               } catch (Exception ex) {
                //TODO: handle exception
        }
        empleadoRepository.save(e);
        attributes.addFlashAttribute("mesg", "Registro guardado correctamente");
        model.addAttribute("elemento", e);
        }
        return "redirect:/empleado/list";
        
    }

    @GetMapping("/update/{id}")
    public String updateEmpleado(@PathVariable(value="id") Integer id, Model model){
        logg.info("Informacion sobre el id del  empleado ", id);
        Empleado emp = empleadoRepository.getById(id);
        model.addAttribute("emple", emp);
        return "empleados/actualizarEmpleado";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmpleado(@PathVariable(value = "id") Integer id) {
        empleadoRepository.deleteById(id);
        return "redirect:/empleado/list";
  
    }    

}
