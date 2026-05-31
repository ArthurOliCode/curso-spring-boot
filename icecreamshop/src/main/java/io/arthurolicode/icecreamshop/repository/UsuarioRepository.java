package io.arthurolicode.icecreamshop.repository;

import io.arthurolicode.icecreamshop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
