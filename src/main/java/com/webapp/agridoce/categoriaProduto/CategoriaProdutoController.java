package com.webapp.agridoce.categoriaProduto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
