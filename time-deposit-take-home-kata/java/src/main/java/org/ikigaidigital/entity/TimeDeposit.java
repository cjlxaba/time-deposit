package org.ikigaidigital.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="timeDeposits")
@Data
public class TimeDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, name = "planType")
    private String planType;
    @Column(nullable = false)
    private Integer days;
    @Column(nullable = false)
    private Double balance;

    // One-to-many relationship to transactions
    @OneToMany(mappedBy = "timeDeposit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Withdrawal> withdrawals = new ArrayList<>();
}
