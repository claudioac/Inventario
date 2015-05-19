package com.inventario.controller;

import com.inventario.model.Producto;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/index");
        List<Producto> productos = Producto.findAllProductos();
        mv.addObject("productos",productos);
        return mv;
    }
}
