package com.empleado.v1.service.Empleado;

import java.util.List;

import com.empleado.v1.model.Empleado;
import com.empleado.v1.repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository; 

    @Override
    public Empleado saveEmpleado(Empleado e) {
        
        return empleadoRepository.save(e);
    }

    @Override
    public List<Empleado> retornarEmpleado() {
       
        return empleadoRepository.findAll();
    }

    @Override
    public void deleteEmpleado(int id) {
       
       empleadoRepository.deleteById(id);
    }

    @Override
    public Empleado uodateEmpleado(Empleado e) {
      
        return empleadoRepository.save(e);
    }
    
}
