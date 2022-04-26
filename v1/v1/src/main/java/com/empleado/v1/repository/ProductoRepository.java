package com.empleado.v1.repository;

import com.empleado.v1.model.Productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository  extends JpaRepository<Productos,Integer>{
    
}
