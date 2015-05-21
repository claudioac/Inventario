package com.inventario.interfaces;

import com.inventario.model.Producto;

import java.util.List;

/**
 * Created by Claudio on 20/05/2015.
 */
public interface ProductoService {

    List<Producto> findAllProductos();

}
