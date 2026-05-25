package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.model.Autor;
import io.github.arthurolicode.libraryapi.model.GeneroLivro;
import io.github.arthurolicode.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}