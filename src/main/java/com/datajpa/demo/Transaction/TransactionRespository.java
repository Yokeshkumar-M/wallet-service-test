package com.datajpa.demo.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRespository extends JpaRepository<Transaction, Integer> {
}
