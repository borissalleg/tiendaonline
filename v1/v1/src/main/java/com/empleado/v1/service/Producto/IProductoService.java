package com.empleado.v1.service.Producto;

import com.empleado.v1.model.Productos;
import java.util.List;
public interface IProductoService {

    
   Productos saveProducto(Productos producto);
   List<Productos> retornarProductos();
  
   void deleteProducto(int id);
   Productos updateProducto(Productos producto);
}
