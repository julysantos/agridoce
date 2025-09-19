package com.webapp.agridoce.controller;

import com.webapp.agridoce.auth.*;
import com.webapp.agridoce.dto.LoginRequestDTO;
import com.webapp.agridoce.dto.LoginResponseDTO;
import com.webapp.agridoce.dto.RegisterRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequestDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.gerarToken(auth);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequestDTO data){
        if (this.usuarioRepository.findByLogin(data.login()).isPresent()){
            return ResponseEntity.badRequest().body("Erro: Nome de usuário já existe");
        }
        String encryptedPassword = passwordEncoder.encode(data.senha());
        Usuario newUser = new Usuario(data.login(), data.senha());

        Role userRole = roleRepository.findByName(RoleNames.ROLE_USER)
                .orElseThrow(()-> new RuntimeException("Erro: Role não encontrado"));
        newUser.setRoles(Set.of(userRole));

        this.usuarioRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
