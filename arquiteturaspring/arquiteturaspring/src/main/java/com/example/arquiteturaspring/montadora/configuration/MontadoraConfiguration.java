package com.example.arquiteturaspring.montadora.configuration;

import com.example.arquiteturaspring.montadora.Motor;
import com.example.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {


    @Bean(name = "motorAspirado")
    public Motor motorAspirado(){
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setLitragem(2.0);
        motor.setModelo("Hamzd-1");
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(4);
        motor.setLitragem(3.0);
        motor.setModelo("PAS-912");
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Primary // Ao @Autowired encontrar mais de um @Bean do mesmo tipo, o @Primary vai definir algum como padrão.
    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(190);
        motor.setCilindros(4);
        motor.setLitragem(1.5);
        motor.setModelo("Hamzd-1");
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}
