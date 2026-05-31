package io.arthurolicode.icecreamshop.dto;

import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

public class PedidoDTO {

    private UUID pedidoId;
    private BigDecimal preco;
    private String status;
}
