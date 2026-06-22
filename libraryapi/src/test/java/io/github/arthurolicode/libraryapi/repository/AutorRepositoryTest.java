package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import io.github.arthurolicode.libraryapi.model.GeneroLivro;
import io.github.arthurolicode.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @see AutorRepository
 */

@SpringBootTest // Ele torna a classe capaz de realizar as mesma ações de uma Application
public class AutorRepositoryTest {

    @Autowired // Injeção do repository
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository; // repository do livro --  método: void salvarAutorComLivros()

    @Test // Torna o código executável
    public void salvarAutorTest(){
        Autor autor = new Autor();
        autor.setNome("Maria Mortris");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1989, 8, 20));

        var autorsalvo = repository.save(autor);
        System.out.println("Autor salvo: " + autorsalvo);
    }

    @Test
    public void atualizarTest(){

        var id = UUID.fromString("2cf0ac01-24c0-4194-856a-a35ea2a7337e");

        Optional<Autor> possivelAutor = repository.findById(id);
        if(possivelAutor.isPresent()) {

            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do Autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1960, 2, 29));

            repository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTest(){
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    public void deletePorIdAutor(){
        var id = UUID.fromString("fda1c055-034d-4dfb-82c3-1cd5314f74d3");

        Optional<Autor> possivelAutor = repository.findById(id);
        if(possivelAutor.isPresent()){

            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do Autor: ");
            System.out.println(autorEncontrado);

            repository.deleteById(id);
            System.out.println("Usuário deletado!");
        }
    }

    @Test
    public void deleteEntityAutor(){
        var id = UUID.fromString("d9b1af71-b24c-4911-9be9-3644147fa950");


        Optional<Autor> possivelAutor = repository.findById(id);
        if(possivelAutor.isPresent()){

            var fabioM = repository.findById(id).get();
            System.out.println("Dados do Autor: ");
            System.out.println(fabioM);

            repository.delete(fabioM); // Esse modo, deleta o objeto, ou seja a entidade em si.
            System.out.println("Usuário deletado!");
        }
    }

    @Test
    void salvarAutorComLivros(){
        Autor autor = new Autor();
        autor.setNome("Marta Gisele");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1992, 4, 10));


        Livro livro = new Livro();
        livro.setTitulo("Amor olímpico");
        livro.setIsbn("408475-23234");
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setPreco(BigDecimal.valueOf(164));
        livro.setDataPublicacao(LocalDate.of(2022, 11, 2));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setTitulo("Maremotriz");
        livro2.setIsbn("491658-93232");
        livro2.setGenero(GeneroLivro.FICCAO);
        livro2.setPreco(BigDecimal.valueOf(192));
        livro2.setDataPublicacao(LocalDate.of(2020, 9, 13));
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);
//        livroRepository.saveAll(autor.getLivros()); --> Forma manual, caso não tenha cascade para salva ambas as entidades.
    }

    @Test
//    @Transactional
    void listarLivrosAutor(){
        UUID id = UUID.fromString("40828e45-7ffe-41a5-93ae-f27e750d0633");
        var autor = repository.findById(id).orElse(null);

//      Buscar os livros do autor através de um Query Method
//      A forma correta de se consultar é com um Query Method ao invés de utilizar o Eager ou Transactional nessas situações.
//      para não quebrar a Database.

        List<Livro> livrosLista = livroRepository.findByAutorOrderByAutor(autor);
        autor.setLivros(livrosLista);

        autor.getLivros().forEach(System.out::println);


    }

    @Test
    void listarAutoresJPQL(){
        var lista = repository.listarAutores();
        lista.forEach(System.out::println);
    }
}
