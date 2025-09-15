package com.webapp.agridoce.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
