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
import java.util.Optional;
import java.util.UUID;

@SpringBootTest 
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarLivro(){
        Livro livro = new Livro();
        livro.setIsdn("234214-93204");
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
        livro.setIsdn("234214-93204");
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
        livro.setIsdn("234214-93204");
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

}