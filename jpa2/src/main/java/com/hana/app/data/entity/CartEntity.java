package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="cart")
@Table(name="t_cart")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString(exclude = "cust")
@Getter
public class CartEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int id;
    private int cnt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cust_id")
    private CustEntity cust;
    @ManyToOne
    @JoinColumn(name="item_id")
    private ItemEntity item;
}
