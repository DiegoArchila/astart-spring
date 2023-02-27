package com.app.astart.persistence.entity;

import javax.persistence.*;
import java.util.List;

/*************************************************
 * TABLE
 ************************************************/
@Entity
@Table(name = "categorias")
public class Categoria {

    /*************************************************
     * COLUMNS
     ************************************************/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(length = 45)
    private String descripcion;

    private Boolean estado;

    /*************************************************
     * RELATIONS
     *************************************************/

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    /*************************************************
     * METHODS
     *************************************************/

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
