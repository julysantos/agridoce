package com.webapp.agridoce.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome_cliente", nullable = false, length = 120)
    private String nomeCliente;

    @Column(name = "telefone_cliente", nullable = false, length = 11)
    private String telefoneCliente;
}
