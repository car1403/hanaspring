package com.hana.v1.item.dto.response;


import com.hana.v1.item.entity.ItemEntity;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class ItemResponseDto {
    Long id;
    String name;
    Long price;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    public ItemResponseDto(ItemEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

}
