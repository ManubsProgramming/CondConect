package com.sistema.CondConnect.Services;

import com.sistema.CondConnect.entitys.Usuario;
import com.sistema.CondConnect.Repositorios.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("usersDetailsService") // define explicitamente o nome do bean
public class UsersDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsersDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
@Override
public UserDetails loadUserByUsername(String username) {

    Usuario usuario = usuarioRepository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

    return new User(
        usuario.getEmail(),   // username
        usuario.getSenha(),   // password (BCrypt)
        usuario.getStatus(),
        true,
        true,
        true,
        Collections.singleton(
            new SimpleGrantedAuthority("ROLE_" + usuario.getPerfil())
        )
    );
}

}
