package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="custaddr")
@Table(name="t_custaddr")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString(exclude = "cust")
@Getter
public class CustAddrEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "custaddr_id")
    private int id;
    private String addr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cust_id")
    private CustEntity cust;

    public void addCust(CustEntity cust) {
        this.cust = cust;
        this.cust.getCustAddrs().add(this);
    }

}
