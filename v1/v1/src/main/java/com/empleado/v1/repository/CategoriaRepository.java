package com.empleado.v1.repository;

import com.empleado.v1.model.Categorias;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {
    
}
