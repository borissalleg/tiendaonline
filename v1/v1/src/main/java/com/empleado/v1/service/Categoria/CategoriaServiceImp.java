package com.empleado.v1.service.Categoria;

import java.util.List;

import com.empleado.v1.model.Categorias;
import com.empleado.v1.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaServiceImp implements  ICategoriaService{

    @Autowired
    CategoriaRepository categoriaRepository;


    @Override
    public Categorias saveCategoria(Categorias categoria) {
        
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categorias> retornarCategorias() {
        
        return categoriaRepository.findAll();
    }
    
}
