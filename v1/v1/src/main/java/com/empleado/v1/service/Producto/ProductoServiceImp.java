package com.empleado.v1.service.Producto;

import java.util.List;

import com.empleado.v1.model.Productos;
import com.empleado.v1.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements IProductoService  {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Productos saveProducto(Productos producto) {
        
        return productoRepository.save(producto);
    }

    @Override
    public List<Productos> retornarProductos() {
        
        return productoRepository.findAll();
    }

    @Override
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
        
    }

    @Override
    public Productos updateProducto(Productos producto) {
        
        return productoRepository.save(producto);
    }
    
}
