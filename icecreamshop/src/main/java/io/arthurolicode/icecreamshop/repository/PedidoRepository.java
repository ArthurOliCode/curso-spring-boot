package io.arthurolicode.icecreamshop.repository;

import io.arthurolicode.icecreamshop.model.Pedido;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
