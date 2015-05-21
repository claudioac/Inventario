package com.inventario.model;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Claudio on 17/05/2015.
 */
@Entity
@SequenceGenerator(initialValue = 1, name = "idAutoGen", sequenceName = "seq_producto")
public class Producto extends EntidadIdAutoLong {


    private String nombre;

    private String codigo;

    private BigDecimal precio;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

}
