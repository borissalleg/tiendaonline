package com.empleado.v1.repository;
import com.empleado.v1.model.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
    
   
 
   
    
   
}