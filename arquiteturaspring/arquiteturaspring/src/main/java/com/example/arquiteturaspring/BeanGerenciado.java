package com.example.arquiteturaspring;

import com.example.arquiteturaspring.todos.TodoEntity;
import com.example.arquiteturaspring.todos.TodoRepository;
import com.example.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope("singleton")  Padrão de escopo para Beans
//@Scope("request")
//@Scope("session")
//@Scope("application")
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator; // Menos recomendado por ser imutável, e não denotar opicionalidade ou obrigatoriedade

    @Autowired
    public BeanGerenciado(TodoValidator validator) { // Recomendado pelo próprio Spring, por exigir obrigatóriedade da dependência para instaciar o objeto.
        this.validator = validator;
    }

    private void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoRepository repository){
        this.validator = validator;
    }
}
