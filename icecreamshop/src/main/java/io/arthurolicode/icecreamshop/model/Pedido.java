package io.arthurolicode.icecreamshop.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "precoTot")
    private BigDecimal precoTotal;

    @Column(name = "status")
    private String status;

    @Column(name = "horarioPedido")
    private LocalDate horarioPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();
}
