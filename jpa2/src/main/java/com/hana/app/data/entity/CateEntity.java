package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="cate")
@Table(name="t_cate")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Getter
public class CateEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cate_id")
    private int id;
    @Column(nullable = false,unique = true,columnDefinition = "varchar(30)")
    private String name;
}
