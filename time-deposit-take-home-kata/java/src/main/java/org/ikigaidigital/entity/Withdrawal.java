package org.ikigaidigital.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name ="withdrawals")
@Data
public class Withdrawal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "timeDepositId",nullable = false)
    private TimeDeposit timeDeposit ;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private Date date;
}
