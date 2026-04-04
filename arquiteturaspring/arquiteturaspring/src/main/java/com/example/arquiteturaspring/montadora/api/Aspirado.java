package com.example.arquiteturaspring.montadora.api;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Define o ciclo de vida da annotation
@Target({ElementType.FIELD, ElementType.METHOD}) // Específica o alvo da annotation como métodos, classes, campos, etc.
@Qualifier("motorAspirado")
public @interface Aspirado {
}
