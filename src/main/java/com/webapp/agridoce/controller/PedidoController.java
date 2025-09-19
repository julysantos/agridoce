package com.webapp.agridoce.controller;

import com.webapp.agridoce.entity.Pedido;
import com.webapp.agridoce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/pedidos")
public class PedidoController {
    @Autowired
    public PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> listarTodosPedidos(){
        return pedidoRepository.findAll();
    }
}
