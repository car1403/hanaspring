package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="db_cust")
@Getter
@ToString
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

}
