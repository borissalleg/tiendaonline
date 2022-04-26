package com.empleado.v1.repository;

import com.empleado.v1.model.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
    Usuarios findByUsername(String username);
    
}
