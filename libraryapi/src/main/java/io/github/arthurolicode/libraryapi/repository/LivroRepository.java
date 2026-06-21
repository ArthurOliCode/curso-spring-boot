package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import io.github.arthurolicode.libraryapi.model.GeneroLivro;
import io.github.arthurolicode.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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
}
