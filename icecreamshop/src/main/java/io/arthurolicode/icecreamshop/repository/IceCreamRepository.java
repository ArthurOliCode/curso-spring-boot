package io.arthurolicode.icecreamshop.repository;

import io.arthurolicode.icecreamshop.model.IceCream;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IceCreamRepository extends JpaRepository<IceCream, UUID> {
}
