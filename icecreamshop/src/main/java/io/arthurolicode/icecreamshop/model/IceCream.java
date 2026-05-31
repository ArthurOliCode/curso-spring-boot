package io.arthurolicode.icecreamshop.model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;

@Entity
@Table(name = "icecream", schema = "public")
public class IceCream {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "sabor", length = 100)
    private String sabor;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    @Column(name = "estoque", precision = 10)
    private Integer estoque;

//    @ManyToOne
//    @Transient
//    private Vendor vendor;

}
