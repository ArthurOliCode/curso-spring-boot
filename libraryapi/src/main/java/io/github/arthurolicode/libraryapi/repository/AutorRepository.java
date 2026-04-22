package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// JPARepository<Entidade -> Exemplo: Autor, Tipo do ID da Entidade --> Exemplo: UUID>
public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
