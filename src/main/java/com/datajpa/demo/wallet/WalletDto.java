package com.datajpa.demo.wallet;

public class WalletDto {
    private Integer fromid;
    private Integer toid;
    private Double amount;

    public WalletDto(){

    }

    public WalletDto(Integer fromid, Integer toid, Double amount) {
        this.fromid = fromid;
        this.toid = toid;
        this.amount = amount;
    }

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public Integer getToid() {
        return toid;
    }

    public void setToid(Integer toid) {
        this.toid = toid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
