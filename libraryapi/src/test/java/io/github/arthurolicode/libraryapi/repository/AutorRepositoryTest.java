package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest // Ele torna a classe capaz de realizar as mesma ações de uma Application
public class AutorRepositoryTest {

    @Autowired // Injeção do repository
    AutorRepository repository = null;

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

}
