package com.webapp.agridoce.controller;

import com.webapp.agridoce.entity.Cliente;
import com.webapp.agridoce.repository.ClienteRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarTodosClientes(){
        return clienteRepository.findAll();
    }
}
