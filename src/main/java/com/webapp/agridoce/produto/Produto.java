package com.webapp.agridoce.produto;

import com.webapp.agridoce.categoriaProduto.CategoriaProduto;
import com.webapp.agridoce.restaurante.Restaurante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
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
    private CategoriaProduto categoria; //criar classe Categoria dps

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurante_prod", referencedColumnName = "id_restaurante")
    private Restaurante restaurante; //criar classe Restaurante dps
}
