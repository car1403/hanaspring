package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="item")
@Table(name="t_item")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Getter
public class ItemEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private int id;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, columnDefinition = "int default 0")
    private int price;
    @ManyToOne
    @JoinColumn(name = "cate_id") // EAGER
    private CateEntity cate;

}
