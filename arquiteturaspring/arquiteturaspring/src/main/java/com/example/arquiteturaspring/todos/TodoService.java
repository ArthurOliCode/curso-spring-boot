package com.example.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    // @AutoWired não se faz necessário, pois, automaticamente o Spring entende a injeção, por ser um Bean gerenciado.
    private TodoRepository repository; // Foi utilizado o private apenas para encapsulamento.

    public TodoService(TodoRepository todoRepository){ // Construtor se faz necessário para a injeção de dependências do Repository para o Service
        this.repository = todoRepository;
    }
    /*
        Caso haja mais de um repository para a injeção de dependências, se faz
        necessário apenas adicionar a vírgula após o que já foi declarado.
        ex: public TodoService(TodoRepository todorepository, OutroRepository, outroRepository)
    */

    public TodoEntity salvar(TodoEntity novoTodo){
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }
}
