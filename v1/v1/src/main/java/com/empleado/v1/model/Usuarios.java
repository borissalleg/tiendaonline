package com.empleado.v1.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 50,nullable = false)
    private String nombre;

    @Column(length = 50,nullable = false)
    private String email;

    @Column(length = 50,nullable = false)
    private String username;

    @Column(length = 50,nullable = false)
    private String password;
    
    private int estatus;

    private LocalDate fechaRegistro;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="UsuarioPerfil", 
                joinColumns = @JoinColumn(name= "idUsuario"),
                inverseJoinColumns = @JoinColumn(name="idPerfil")
                )
    private List<Perfiles> perfiles; 
  public void agregar(Perfiles temPerfil){
      if (perfiles == null){
          perfiles = new LinkedList<Perfiles>();
      }
      perfiles.add(temPerfil);
  }



    public Usuarios() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstatus() {
        return this.estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public List<Perfiles> getPerfiles() {
        return this.perfiles;
    }

    public void setPerfiles(List<Perfiles> perfiles) {
        this.perfiles = perfiles;
    }

}
