package com.webapp.agridoce.pagamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webapp.agridoce.pedido.Pedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamento")
@Data
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
