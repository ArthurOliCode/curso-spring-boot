package com.example.arquiteturaspring.montadora.api;

import com.example.arquiteturaspring.montadora.CarroStatus;
import com.example.arquiteturaspring.montadora.Chave;
import com.example.arquiteturaspring.montadora.HondaHRV;
import com.example.arquiteturaspring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    @Autowired // Auto-gestão do Spring com container e dependências no @Bean.
    // @Qualifier("motorEletrico") --> Tem a função de identificar para o @Autowired qual @Bean de mesmo tipo será utilizado.
    @Turbo // Annotation personalizada para definir o tipo de motor, fazendo uma injeção de dependência. 
    private Motor motor;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new HondaHRV(motor);
        return carro.darIngnicao(chave);
    }
}
