package com.webapp.agridoce.controller;

import com.webapp.agridoce.entity.CategoriaProduto;
import com.webapp.agridoce.repository.CategoriaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categoria-produtos")
public class CategoriaProdutoController {
    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @GetMapping
    public List<CategoriaProduto> listarTodasCategorias() {
        return categoriaProdutoRepository.findAll();
    }
}
