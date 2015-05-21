package com.inventario.repository;

import com.inventario.interfaces.ProductoService;
import com.inventario.model.Producto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Claudio on 20/05/2015.
 */
@Repository
public class ProductoRepo implements ProductoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Producto> findAllProductos() {
       return this.entityManager.createQuery("Select p from Producto p",Producto.class).getResultList();
    }
}
