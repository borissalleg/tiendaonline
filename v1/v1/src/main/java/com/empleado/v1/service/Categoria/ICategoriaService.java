package com.empleado.v1.service.Categoria;

import com.empleado.v1.model.Categorias;
import java.util.List;
public interface ICategoriaService {
      
   Categorias  saveCategoria( Categorias categoria);
   List<Categorias> retornarCategorias();
}
