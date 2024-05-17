package com.hana.v1.item.entity;

import com.hana.common.entity.BaseEntity;
import com.hana.v1.item.dto.request.ItemRequestDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@Table(name="open_item")
public class ItemEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="item_id")
    private Long id;
    @Column(unique = true,
            columnDefinition = "varchar(20)")
    private String name;
    @Column(columnDefinition = "bigint default 0")
    private Long price;

    public ItemEntity(ItemRequestDto obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.price = obj.getPrice();
    }
    public void update(ItemRequestDto obj){
        this.name = obj.getName();
        this.price = obj.getPrice();
    }

}