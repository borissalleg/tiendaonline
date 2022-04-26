package com.empleado.v1.controller;


import com.empleado.v1.model.Categorias;
import com.empleado.v1.model.Productos;
import com.empleado.v1.repository.CategoriaRepository;
import com.empleado.v1.repository.ProductoRepository;
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





@Controller 
@RequestMapping(value="/producto")
public class productoController {

    private final Logger logg = LoggerFactory.getLogger(Productos.class);

    @Autowired
    private ProductoRepository productoRepository; 

    @Autowired
    private CategoriaRepository categoriaRepository;
    

    @GetMapping(value="/list")
    public String ListarProductos(Model model){
        model.addAttribute("listaProducto", productoRepository.findAll());
        return"productos/listProductos";
    }

    @GetMapping(value="/create")
    public String createProdcuto(Model model){
        
        model.addAttribute("listaProducto",productoRepository.findAll());
        model.addAttribute("categoriaR",  categoriaRepository.findAll());
        return"productos/formProducto";

    }

    @PostMapping("/save")
    public String saveProducto(@RequestParam(name="cate") int cat, @RequestParam(name="archivoImg2", required = false) MultipartFile multipart,  Productos producto, Model model, RedirectAttributes attributes){
        logg.info("Informacion sobre el objeto producto ", producto.getDescripcion());
      
       String ruta ="C://Temp//uploads/";
       String rd = Utileria.guardarArchivo(multipart, ruta);
       producto.setImagen(rd);
       
       Categorias categoria = new Categorias();
       categoria.setId(cat);
       producto.setCategoria(categoria);
       productoRepository.save(producto);
       attributes.addFlashAttribute("mesg", "Registro guardado correctamente");
       model.addAttribute("producto",producto);

        return "redirect:/producto/list";
        
    }

    @GetMapping("/update/{id}")
    public String updateProducto(@PathVariable(value="id") Integer id, Model model){
        logg.info("Informacion sobre el id del producto ", id);
        Productos prod = productoRepository.getById(id);
        model.addAttribute("producto", prod);
        return "empleados/actualizarEmpleado";
    }

    @GetMapping("/delete/{id}")
    public String deleteProducto(@PathVariable(value = "id") Integer id) {
        productoRepository.deleteById(id);
        return "redirect:/producto/list";
  
    }    


}
