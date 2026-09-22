package com.datajpa.demo.Transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Random;

@Setter
@Getter
@Entity
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    private String trans_id =
            "TXN-" +
                    System.currentTimeMillis() +
                    "-" +
                    new Random().nextInt(1000);

    private Double trans_amount;
    private LocalDateTime trans_datetime;
    private String transaction_status;
    private LocalDateTime created_at;

    // RENAMED: was "TransactionType" (same name as its type) — this caused the Jackson error
    private TransactionType transactionType;

    public Transaction(Integer id, String trans_id, Double trans_amount, LocalDateTime trans_datetime, String transaction_status, LocalDateTime created_at, TransactionType transactionType) {
        this.id = id;
        this.trans_id = trans_id;
        this.trans_amount = trans_amount;
        this.trans_datetime = trans_datetime;
        this.transaction_status = transaction_status;
        this.created_at = created_at;
        this.transactionType = transactionType;
    }

    public Transaction() {
    }
}
