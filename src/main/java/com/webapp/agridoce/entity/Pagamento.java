package com.webapp.agridoce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long id;

    @JoinColumn(name = "id_pedido_pag", referencedColumnName = "id_pedido")
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Pedido pedido;

    @Column(name = "valor_pag", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorPag;

    @Column(name = "metodo_pag", nullable = false, length = 120)
    private String metodoPag;
}
