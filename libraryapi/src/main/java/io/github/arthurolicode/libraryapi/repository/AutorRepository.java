package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * @see Autor
 * @see AutorRepositoryTest
 */

// JPARepository<Entidade -> Exemplo: Autor, Tipo do ID da Entidade --> Exemplo: UUID>
public interface AutorRepository extends JpaRepository<Autor, UUID> {

    @Query(" select a from Autor as a")
    List<Autor> listarAutores();
}
