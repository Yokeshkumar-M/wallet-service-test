package com.datajpa.demo.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {

    Optional<Wallet> findByEmail(String email);
    Optional<Wallet> findByPassword(String password);

    @Query("Select wallet from Wallet wallet where wallet.email=?1")
    Wallet searchByEmail(String email);

    @Query(value = "Select * from Wallet where email=?1", nativeQuery = true)
    Wallet searchByEmailNative(@Param("email") String email);

    @Query("Select wallet from Wallet wallet")
    List<Wallet> findAllWallet();


}
