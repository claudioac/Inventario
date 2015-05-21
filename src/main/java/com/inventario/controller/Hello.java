package com.inventario.controller;

import com.inventario.interfaces.ProductoService;
import com.inventario.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Claudio on 13/05/2015.
 */
@Controller
@RequestMapping(value = "/")
public class Hello  {

    @Autowired
    private ProductoService productoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/index");
        List<Producto> productos = productoService.findAllProductos();
        mv.addObject("productos",productos);
        return mv;
    }
}
