package com.empleado.v1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "tbl_empleado")
public class Empleado implements Serializable {
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id;
    

    @Column(name = "nombre_empleado", length = 30, nullable = false)
    @NotEmpty(message = "Debe indicar el nombre del usuario.")
    private String nombre;
    @Column(name = "apellido_empleado", length = 30, nullable = false)
    private String apellido;

    @Column(name = "estado_empleado", nullable = false)
    private int estado;

    @Column(name = "foto_empleado", length = 30, nullable = true)
    private String imagenFoto;


    public String getImagenFoto() {
        return this.imagenFoto;
    }

    public void setImagenFoto(String imagenFoto) {
        this.imagenFoto = imagenFoto;
    }

  





    public Empleado() {
    }


    public int getEstado() {
        return this.estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String Apellido) {
        this.apellido = Apellido;
    }
    private static final long serialVersionUID = 1l;
}
