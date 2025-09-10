package com.webapp.agridoce.categoriaProduto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nome_categoria", nullable = false, length = 120)
    private String nomeCategoria;

    @Column(name = "descricao")
    private String descricao;
}
