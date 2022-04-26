package com.empleado.v1.controller;




import javax.servlet.http.HttpSession;

import com.empleado.v1.model.Usuarios;
import com.empleado.v1.service.Usuario.UsuarioServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;




@Controller
@RequestMapping(value= "/")
public class homeControllet {

@Autowired
private UsuarioServiceImp usuarioService;

    @GetMapping(value="/")
    public String claseInicio(){
        System.out.println("estuvo por aca ");
        // String username = auth.getName();
        // System.out.println("Datos del usuario" + username);
        // model.addAttribute("user", username);
        return "home/home";
    }

    @GetMapping(value="/index")
    public String claseHome(Authentication auth, HttpSession session , Model model){
        String username = auth.getName();
        
        System.out.println("Datos del usaurio logeado "+ username);
        model.addAttribute("username",username);
        for (GrantedAuthority rol : auth.getAuthorities()){
            System.out.println("ROL : " + rol.getAuthority());
        }
        if (session.getAttribute("usuario")== null){
            Usuarios usuario = usuarioService.buscarPorUsername(username);
            usuario.setPassword(null);
            System.out.println("Usuario  : " + usuario.getNombre() +"  "
                                             + usuario.getUsername() +" " 
                                             + usuario.getEstatus() +" "  );
            session.setAttribute("usuario",usuario);
        }
        return "redirect:/";
    }

    // @GetMapping(value="/fuente")
    // public String claseFuente(Model model){
    //    List<String> listaEmp =  sourceDatos(); 
    //    model.addAttribute("lista", listaEmp );
    //     return "fuente";
    // }


    // private List<String> sourceDatos(){

    //     List<String> fuente = new ArrayList<String>();
    //     fuente.add("Juan");
    //     fuente.add("pedro");
    //     fuente.add("Maria");
       
        

    //     return fuente;
    // }

    // private List<Empleado> lista(){
    //     List<Empleado> listaEmpleado = new ArrayList<Empleado>(); 
    //         Empleado e1 = new Empleado();
    //         e1.setNombre("Julian");
    //         e1.setApellido("Garcia");
    //         Empleado e2 = new Empleado();
    //         e2.setNombre("Maria");
    //         e2.setApellido("Pacheco");

    //         Empleado e3 = new Empleado();
    //         e3.setNombre("Pedro ");
    //         e3.setApellido("Coral");


    //         listaEmpleado.add(e1);
    //         listaEmpleado.add(e2);
    //         listaEmpleado.add(e3);
            
    //     return listaEmpleado;
    // }
    


    
}
