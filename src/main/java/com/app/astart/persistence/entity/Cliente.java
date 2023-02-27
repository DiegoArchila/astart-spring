package com.app.astart.persistence.entity;

import javax.persistence.*;
import java.util.List;

/*************************************************
 * TABLE
 ************************************************/
@Entity
@Table(name = "clientes")
public class Cliente {

    /*************************************************
     * COLUMNS
     ************************************************/

    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 40)
    private String nombre;

    @Column(length = 100)
    private String apellidos;

    @Column(length = 20)
    private String celular;

    @Column(length = 80)
    private String direccion;

    @Column(length = 70, name = "correo_electronico")
    private String correoElectronico;

    /*************************************************
     * RELATIONS
     *************************************************/

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    /*************************************************
     * METHODS
     *************************************************/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
