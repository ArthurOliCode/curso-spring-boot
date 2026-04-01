package com.example.arquiteturaspring.configuration;

import com.example.arquiteturaspring.montadora.Motor;
import com.example.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MontadoraConfiguration {

    @Bean
    public Motor motor(){
        var motor = new Motor();
        motor.setCavalos(20);
        motor.setCilindros(6);
        motor.setLitragem(2.0);
        motor.setModelo("Hamzd-1");
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor();
    }
}
