package io.github.arthurolicode.libraryapi.service;

import io.github.arthurolicode.libraryapi.model.Autor;
import io.github.arthurolicode.libraryapi.model.GeneroLivro;
import io.github.arthurolicode.libraryapi.model.Livro;
import io.github.arthurolicode.libraryapi.repository.AutorRepository;
import io.github.arthurolicode.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransactionalService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;


    @Transactional
    public void salvarLivroComFoto(){
//        salvar livro
//        repository.save(livro);
//
//        resgatar ID do livro = livro.getId();
//        var id = livro.getId();
//
//        salvar foto do livro -> Bucket na nuvem
//        bucketService.salvar(livro.getFoto(), id + ".png");
//
//        Atualizar o nome do arquivo que foi salvo
//        livro.setNomeArquivoFoto(id + ".png");
    }

    @Transactional
    public void atualizarSemAtualizar(){
        String id = "0d2ef6a3-c488-4ddf-be3c-f32d7f20e7b2";

        var livro = livroRepository.findById(UUID.fromString(id)).orElse(null);

        livro.setDataPublicacao(LocalDate.of(2022, 4, 12));
    }

    @Transactional
    public void executar(){

//         Salvar o Autor
        Autor autor = new Autor();
        autor.setNome("Lauran");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1992, 4, 10));

        autorRepository.save(autor);

//         Salvar o Livro
        Livro livro = new Livro();
        livro.setTitulo("Olapim");
        livro.setIsbn("403075-23934");
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setPreco(BigDecimal.valueOf(201));
        livro.setDataPublicacao(LocalDate.of(2030, 11, 2));

        livro.setAutor(autor);

        livroRepository.save(livro);

        if(autor.getNome().equals("José")){
            throw new RuntimeException("Rollback!!");
        }

    }
}
