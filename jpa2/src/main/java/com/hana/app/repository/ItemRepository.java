package com.hana.app.repository;

import com.hana.app.data.entity.CateEntity;
import com.hana.app.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository
        extends JpaRepository<ItemEntity,Integer> {
}
