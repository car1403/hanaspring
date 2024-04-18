package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="custaddr")
@Table(name = "db_custaddr")
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@ToString
public class CustAddrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custaddr_id")
    private Long id;

    @Column(nullable = true, length = 50)
    private String name;
    @Column(nullable = true, length = 100)
    private String addr;

    @ManyToOne
    @JoinColumn(name="cust_id")
    private CustEntity cust;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regdatedAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}





