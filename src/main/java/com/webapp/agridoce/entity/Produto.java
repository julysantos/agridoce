package com.webapp.agridoce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nome_prod", nullable = false, length = 120)
    private String nomeProduto;

    @Enumerated(EnumType.STRING)
    @Column(name = "dispon_prod", nullable = false)
    private DisponibilidadeProduto disponibilidadeProduto;

    @Column(name = "descricao_prod", length = 120)
    private String descricaoProduto;

    @Column(name = "preco_prod", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoProd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_prod", referencedColumnName = "id_categoria")
    @JsonIgnore
    private CategoriaProduto categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurante_prod", referencedColumnName = "id_restaurante")
    @JsonIgnore
    private Restaurante restaurante;
}
