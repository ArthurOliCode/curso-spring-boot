package io.github.arthurolicode.libraryapi.controller;

import io.github.arthurolicode.libraryapi.controller.dto.AutorDTO;
import io.github.arthurolicode.libraryapi.model.Autor;
import io.github.arthurolicode.libraryapi.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("autores")
// http://localhost:8080/autores
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service){
        this.service = service;
    }

      @PostMapping
//      @RequestMapping(method = RequestMethod.POST) --> Possível alternativa de mapeamento
      public ResponseEntity<Void> salvar(@RequestBody AutorDTO autor){
          Autor autorEntidade = autor.mapearParaAutor();
          service.salvar(autorEntidade);

          URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                  .path("/{id}")
                  .buildAndExpand(autorEntidade.getId())
                  .toUri();

          return ResponseEntity.created(location).build();
    }
}
