package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import io.github.arthurolicode.libraryapi.model.GeneroLivro;
import io.github.arthurolicode.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @see LivroRepository
 */

@SpringBootTest 
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarLivro(){
        Livro livro = new Livro();
        livro.setIsbn("234214-93204");
        livro.setGenero(GeneroLivro.MISTERIO);
        livro.setPreco(BigDecimal.valueOf(125));
        livro.setTitulo("Gone");
        livro.setDataPublicacao(LocalDate.of(1980, 3, 1));

        Autor autor =  autorRepository.findById(UUID.fromString("3399985b-5b80-4c09-be95-56dd3e6ec9dc")).orElse(null);

        livro.setAutor(autor);

        repository.save(livro);


    }

    @Test
    void salvarLivroEAutor(){
        Livro livro = new Livro();
        livro.setIsbn("234214-93204");
        livro.setGenero(GeneroLivro.FANTASIA);
        livro.setPreco(BigDecimal.valueOf(200));
        livro.setTitulo("As viagens de Marta");
        livro.setDataPublicacao(LocalDate.of(1980, 3, 1));

        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1990, 4, 30));

        autorRepository.save(autor);

        livro.setAutor(autor);

        repository.save(livro);


    }

    @Test
    void salvarLivroCascade(){
        Livro livro = new Livro();
        livro.setIsbn("234214-93204");
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setPreco(BigDecimal.valueOf(125));
        livro.setTitulo("Lombok");
        livro.setDataPublicacao(LocalDate.of(1980, 3, 1));

        Autor autor = new Autor();
        autor.setNome("José");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1980, 11, 21));

        livro.setAutor(autor);

        repository.save(livro);


    }

    @Test
    void atualizarAutorDoLivro(){
        UUID id = UUID.fromString("03f1994a-2e9f-41e0-b01e-ed68d552442b");
        var atualizarAutor = repository.findById(id).orElse(null);

        UUID id_autor = UUID.fromString("ede1c922-a897-4d3b-8cae-ccd59a1d6c51");
        Autor fabioM = autorRepository.findById(id_autor).orElse(null);

        atualizarAutor.setAutor(fabioM);

        repository.save(atualizarAutor);
    }

    @Test
    void deleteLivro(){
        UUID id = UUID.fromString("1671ecf7-9055-4107-a05a-5b1eca6a165b");

        repository.deleteById(id);

    }

    @Test
    void deleteLivroCascade(){
       UUID id = UUID.fromString("6f0a5a3d-e1fa-47f5-b1c1-9e2c3d1b01dc");
       repository.deleteById(id);
    }

    @Test
    @Transactional
//    O transactional serve para manter a conexão com o banco aberta (Hibernate) até que o método seja varrido

    void buscarLivroTest(){
        UUID id = UUID.fromString("03f1994a-2e9f-41e0-b01e-ed68d552442b");
        var livro = repository.findById(id).orElse(null);
        System.out.println("Livro: ");
        System.out.println(livro.getTitulo());

//        UUID id_autor = UUID.fromString("ede1c922-a897-4d3b-8cae-ccd59a1d6c51");
//        var autor = autorRepository.findById(id_autor).orElse(null);

        System.out.println("Autor: ");
        System.out.println(livro.getAutor().getNome());
    }

    @Test
    void pesquisaPorTituloTest(){
        List<Livro> lista = repository.findByTituloOrderByTitulo("As viagens de Marta");
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisaPorIsbnTest(){
        List<Livro> lista = repository.findByIsbn("424235-93204");
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisaPorTituloAndPreco(){
        var preco = BigDecimal.valueOf(192.00);
        var titulo = "Martes, montes e mortes";

        List<Livro> lista = repository.findByTituloAndPrecoOrderByTitulo(titulo, preco);
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisaPorTituloOrIsbn(){
        var titulo = "";
        var isbn = "234214-93204";

        List<Livro> lista = repository.findByTituloOrIsbnOrderByTitulo(titulo, isbn);
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisarPorTituloComo(){
        var titulo = "%%";

        List<Livro> lista = repository.findByTituloLikeOrderByTitulo(titulo);
        lista.forEach(System.out::println);
    }

    @Test
    void pesquisarPorGenero(){
        GeneroLivro generoLivro =  GeneroLivro.MISTERIO;

        List<Livro> lista = repository.findByGenero(generoLivro);
        lista.forEach(System.out::println);
    }

    @Test
    void listarLivrosJPQL(){
        var resultados = repository.listarLivros();
        resultados.forEach(System.out::println);
    }

    @Test
    void listarAutoresJPQL(){
        var autores = repository.listarAutoresdosLivros();
        autores.forEach(System.out::println);
    }

    @Test
    void listarTitulosJPQL(){
        var titulos = repository.listarTituloLivros();
        titulos.forEach(System.out::println);
    }

    @Test
    void listarGeneroAutoresBrasileiros(){
        var generos = repository.listarGenerosAtuoresBrasileiros();
        generos.forEach(System.out::println);
    }

//    Named Parameters -> Parâmetros que são nomeados
    @Test
    void buscarGeneroLivrosQueryParam(){
        var generos = repository.findByGeneroQueryParam(GeneroLivro.MISTERIO, "preco");
        generos.forEach(System.out::println);
    }

    @Test
    void buscarGeneroLivrosPosParam(){
        var generos = repository.findByGeneroPosParam(GeneroLivro.MISTERIO, "preco");
        generos.forEach(System.out::println);
    }

    @Test
    void deletarPorGenero(){
        repository.deleteByGenero(GeneroLivro.CIENCIA);
    }

    @Test
    void updateGeneroLivro(){
        GeneroLivro genero_novo = GeneroLivro.ROMANCE;
        var isbn = "";
        var titulo = "Martes, montes e mortes";

        repository.updateGeneroLivro(genero_novo, isbn, titulo );
    }

    @Test
    void updateIsbn(){
        var titulo = "Maremotriz";
        var isbn = "352332-42371";

        repository.updateIsbn(isbn, titulo);
    }
}