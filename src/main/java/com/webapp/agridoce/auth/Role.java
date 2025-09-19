package com.webapp.agridoce.auth;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_roles")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nome", length = 20, unique = true)
    private RoleNames name;
}
