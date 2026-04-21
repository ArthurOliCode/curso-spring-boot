package com.example.arquiteturaspring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.config")
public class AppProperties {
    private String variavel;
    private String valorB;

    public String getVariavel() {
        return variavel;
    }

    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }

    public String getValorB() {
        return valorB;
    }

    public void setValorB(String valorB) {
        this.valorB = valorB;
    }
}
