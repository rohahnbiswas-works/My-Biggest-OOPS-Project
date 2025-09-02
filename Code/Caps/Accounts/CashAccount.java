package Caps.Accounts;

import java.math.BigDecimal;

public class CashAccount extends TradeAccount {
    private BigDecimal cashBalance;

    public CashAccount(String id,BigDecimal cashBalance){
        super(id);
        setCashbalance(cashBalance);
    }

    public void setCashbalance(BigDecimal cashBalance){
        BigDecimal copy = cashBalance;
        this.cashBalance=copy;
    }

    public BigDecimal getCashBalance(){
        BigDecimal copy=cashBalance;
        return copy;
    }

    @Override
    public TradeAccount clone(){
        CashAccount copy= new CashAccount(this.getID(), this.cashBalance);
        return copy;
    }
}
