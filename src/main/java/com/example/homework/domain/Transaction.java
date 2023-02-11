package com.example.homework.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Table(name ="Customer")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String customerId;
    @Column
    private int amount;
    @Column
    private Date date;

}
