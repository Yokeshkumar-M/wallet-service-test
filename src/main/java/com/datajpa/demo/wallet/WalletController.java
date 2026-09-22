package com.datajpa.demo.wallet;

import jakarta.persistence.Entity;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/wallet")
@CrossOrigin(origins = "http://localhost:4200")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @GetMapping
    public String hello(){
        return "hello";
    }
    //Register New Wallet User
    @PostMapping("/register")
    Wallet registerNewWallet(@Valid @RequestBody Wallet newWallet){
        return this.walletService.registerNewWalletUser(newWallet);

    }

    @GetMapping("/{walletID}")
    public Wallet getWalletByID(@PathVariable("walletID") Integer walletID){
        return this.walletService.getUserWalletById(walletID);
    }

    @PatchMapping("/update")
    public Wallet updateUserWallet(@RequestBody WalletDto walletDto ){
        return this.walletService.updateUserWallet(walletDto.getFromid());
    }

    @PatchMapping("/addFund")
    public Double addFundsToWalletByID(@RequestBody WalletDto walletDto){
        return this.walletService.addFundsToWalletByID(walletDto.getFromid(),walletDto.getToid(),walletDto.getAmount());
    }

    @PatchMapping("/withdraw")
    public Double withdrawFundsToWalletByID(@RequestBody WalletDto walletDto){
        return this.walletService.withdrawFundsToWalletByID(walletDto.getFromid(),walletDto.getAmount());
    }

    @PatchMapping("/transferFund")
    public Boolean fundTransfer(@RequestBody WalletDto walletDto){
        return this.walletService.fundTransfer(walletDto.getFromid(),walletDto.getToid(),walletDto.getAmount());
    }
    @PostMapping("deactivate/{walletID}")
    public Boolean deactivateWalletByID(@PathVariable("walletID") Integer walletID){
        return this.walletService.deactivateWalletByID(walletID);
    }
    @PostMapping("activate/{walletID}")
    public Boolean activateWalletByID(@PathVariable("walletID") Integer walletID){
        return this.walletService.activateWalletByID(walletID);
    }


}

