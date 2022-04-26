package com.empleado.v1.service.Usuario;

import java.util.List;

import com.empleado.v1.model.Usuarios;
import com.empleado.v1.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements IUsuarioService {

    @Autowired
    UsuariosRepository usuariorepository;
    @Override
    public Usuarios saveUsuario(Usuarios usuario) {
        
        return usuariorepository.save(usuario);
    }

    @Override
    public List<Usuarios> retornarUsuarios() {
        
        return usuariorepository.findAll();
    }

    @Override
    public void deleteUsuario(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Usuarios updateusuario(Usuarios usuario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuarios buscarPorUsername(String username) {
        
        return usuariorepository.findByUsername(username);
    }
    
}
