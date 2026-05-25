package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest // Ele torna a classe capaz de realizar as mesma ações de uma Application
public class AutorRepositoryTest {

    @Autowired // Injeção do repository
    AutorRepository repository;

    @Test // Torna o código executável
    public void salvarAutorTest(){
        Autor autor = new Autor();
        autor.setNome("Fábio M.");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1956, 9, 21));

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
}
