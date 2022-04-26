package com.empleado.v1.repository;

import com.empleado.v1.model.Perfiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilesRepository  extends JpaRepository<Perfiles, Integer>{
    
}
