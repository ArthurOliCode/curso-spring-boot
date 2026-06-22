package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import io.github.arthurolicode.libraryapi.model.GeneroLivro;
import io.github.arthurolicode.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 @see LivroRepositoryTest
 */

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    //Query Method
//    Select * from livro where id_autor = id
    List<Livro> findByAutorOrderByAutor(Autor autor);

    List<Livro> findByTituloOrderByTitulo(String titulo);

    List<Livro> findByIsbn(String isbn);

    List<Livro> findByTituloAndPrecoOrderByTitulo(String titulo, BigDecimal preco);

    List<Livro> findByTituloOrIsbnOrderByTitulo(String titulo, String isbn);

    List<Livro> findByTituloLikeOrderByTitulo(String titulo);

    List<Livro> findByGenero(GeneroLivro genero);

//    JPQL -> referencia entidades e suas propriedades
//    select l.* from Livro as l order by l.titulo
    @Query(" select l from Livro as l order by l.titulo")
    List<Livro> listarLivros();

    @Query(" select a from Livro as l Join l.autor a")
    List<Autor> listarAutoresdosLivros();

    @Query(" select distinct l.titulo from Livro as l")
    List<String> listarTituloLivros();

    @Query("""
        select l.genero
        from Livro l
        join l.autor a
        where a.nacionalidade = "Brasileira"
        order by l.genero
    """)
    List<String> listarGenerosAtuoresBrasileiros();

//    Named Parameters --> Parâmetros Nomeados, melhores para consultas mais extensas.
    @Query(" select l from Livro l where l.genero = :genero order by :preco")
    List<Livro> findByGeneroQueryParam(@Param("genero") GeneroLivro generoLivro,
                             @Param("preco") String preco);

//    Positional Parameters --> Parâmetros por posição, são melhores para consultas curtas
    @Query(" select l from Livro l where l.genero = ?1 order by ?2")
    List<Livro> findByGeneroPosParam(GeneroLivro generoLivro, String preco);

    @Modifying
    @Transactional
    @Query(" delete from Livro l where l.genero = ?1")
    void deleteByGenero(GeneroLivro generoLivro);

    @Modifying
    @Transactional
    @Query(" update Livro set genero = ?1 where isbn = ?2 or titulo = ?3")
    void updateGeneroLivro(GeneroLivro generoLivro, String isbn, String titulo);

    @Modifying
    @Transactional
    @Query(" update Livro set isbn = ?1 where titulo = ?2")
    void updateIsbn(String isbn, String titulo);
}
