package com.webapp.agridoce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.webapp.agridoce.auth.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome_cliente", nullable = false, length = 120)
    private String nomeCliente;

    @Column(name = "telefone_cliente", nullable = false, length = 11)
    private String telefoneCliente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_cli", referencedColumnName = "id")
    private Usuario usuario;
}
