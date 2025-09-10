package com.webapp.agridoce.restaurante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "restaurante")
@Data
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

    @Column(name = "telefone_rest", nullable = false, length = 11)
    private String telefoneRestaurante;

}
