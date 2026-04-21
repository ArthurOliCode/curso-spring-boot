package com.example.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        try{
            return this.service.salvar(todo);
        }catch(IllegalArgumentException e){ // Tratamento de erro caso já exista o todo
            var mensagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro); // Poderia utilizar tanto o CONFLICT, quanto o BAD_REQUEST
        }
    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id,
                                @RequestBody TodoEntity todo){
        todo.setId(id);
        service.atualizarStatus(todo);
    }

    @GetMapping("{id}")
    public void buscar(@PathVariable("id") Integer id){
        service.buscarPorId(id);
    }
}
