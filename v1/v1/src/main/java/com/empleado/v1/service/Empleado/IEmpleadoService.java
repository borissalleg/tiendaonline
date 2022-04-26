package com.empleado.v1.service.Empleado;

import com.empleado.v1.model.Empleado;
import java.util.List;





public interface IEmpleadoService {

   Empleado saveEmpleado(Empleado e);
   List<Empleado> retornarEmpleado();
   void deleteEmpleado(int id);
   Empleado uodateEmpleado(Empleado e);
    
    }



 
    


