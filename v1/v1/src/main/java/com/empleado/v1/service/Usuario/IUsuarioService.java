package com.empleado.v1.service.Usuario;

import java.util.List;

import com.empleado.v1.model.Usuarios;

public interface IUsuarioService {
    
   Usuarios saveUsuario(Usuarios usuario);
   List<Usuarios> retornarUsuarios();
  
   void deleteUsuario(int id);
   Usuarios updateusuario(Usuarios usuario);
   Usuarios buscarPorUsername(String username);
}
