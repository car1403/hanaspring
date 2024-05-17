package com.hana.v1.item.repository;


import com.hana.v1.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    Optional<ItemEntity> findByName(String name);
}
