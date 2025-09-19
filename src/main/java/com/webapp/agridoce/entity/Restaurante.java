package com.webapp.agridoce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restaurante")
    private Long id;

    @Column(name = "cnpj", nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "nome_restaurante", nullable = false)
    private String nomeRestaurante;

    @Column(name = "telefone_restaurante", nullable = false, length = 11)
    private String telefoneRestaurante;

}
