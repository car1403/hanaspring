package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="custinfo")
@Table(name="t_custinfo")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString(exclude = "cust")
@Getter
public class CustInfoEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custinfo_id")
    private int id;
    @Column(nullable = false,columnDefinition = "int default 1")
    private int age;

    @OneToOne // EAGER
    @JoinColumn(name="cust_id")
    private CustEntity cust;

}
