package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="cust")
@Table(name="t_cust")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Getter
public class CustEntity extends BaseEntity {
    @Id
    @Column(name = "cust_id", length = 30)
    private String id;
    @Column(nullable = false,columnDefinition = "varchar(60)")
    private String pwd;
    @Column(nullable = false,columnDefinition = "varchar(30)")
    private String name;

    @OneToOne(mappedBy = "cust")
    CustInfoEntity custInfo;

    @OneToMany(mappedBy = "cust", fetch = FetchType.EAGER)
    @Builder.Default
    List<CustAddrEntity> custAddrs = new ArrayList<>();
}
