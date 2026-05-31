package io.arthurolicode.icecreamshop.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private IceCream iceCream;
}
