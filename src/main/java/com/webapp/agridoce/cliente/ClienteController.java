package com.webapp.agridoce.cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarTodosClientes(){
        return clienteRepository.findAll();
    }
}
