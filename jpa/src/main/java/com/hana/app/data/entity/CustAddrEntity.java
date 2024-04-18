package com.hana.app.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="custaddr")
@Table(name = "db_custaddr")
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@ToString(exclude = "cust")
@EntityListeners(AuditingEntityListener.class)
public class CustAddrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custaddr_id")
    private Long id;

    @Column(nullable = true, length = 50)
    private String name;
    @Column(nullable = true, length = 100)
    private String addr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cust_id")
    private CustEntity cust;

    public void addCust(CustEntity cust) {
        this.cust = cust;
        cust.getCustAddrEntityList().add(this);
    }

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regdatedAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}





