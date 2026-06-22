package io.github.arthurolicode.libraryapi.repository;

import io.github.arthurolicode.libraryapi.service.TransactionalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionalTest {

    /**
     * commit --> confirma as alterações
     * Rollback --> desfaz as alterações
     */

    @Autowired
    TransactionalService transactionalService;

    @Test
    void transacaoSimples(){
        transactionalService.executar();
    }

    void transacaoEntidadeManaged(){
        transactionalService.atualizarSemAtualizar();
    }
}
