package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "cust")
@Table(name="db_cust")
@Getter
@ToString()
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class CustEntity {
    @Id
    @Column(name="cust_id", length = 30)
    private String id;
    @Column(length = 60,nullable = false)
    private String pwd;
    @Column(length = 50,nullable = false)
    private String name;

    @OneToOne(mappedBy = "cust") // EAGER COMPOSITION
    private CustInfoEntity custInfo;

    @OneToMAany(mappedBy = "cust", fetch = FetchType.EAGER) // LAZY AGGREGATION
    @Builder.Default
    private List<CustAddrEntity> custAddrEntityList = new ArrayList<CustAddrEntity>();

}
