package com.example.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository --> É opcional, pois esse é um dos únicos casos em que a classe é escaneada automaticamente devido ao JPA
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    boolean existsByDescricao(String descricao);
}
