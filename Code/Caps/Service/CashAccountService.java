package Caps.Service;

import java.math.BigDecimal;
import Caps.Accounts.*;
import Caps.Repositories.*;

public class CashAccountService implements TradeAccountService{

    private TradeAccountRepository tradeAccountRepository;

    public CashAccountService(TradeAccountRepository tradeAccountRepository){
        this.tradeAccountRepository=tradeAccountRepository;
    }
    @Override
    public void deposit(String id, BigDecimal amount){ 
       CashAccount copy1= (CashAccount)tradeAccountRepository.getTradeAccount(id).clone();
       BigDecimal copy2=copy1.getCashBalance();
       BigDecimal copy3=copy2.add(amount);
       copy1.setCashbalance(copy3);
    }
    @Override
    public void withdraw(String id, BigDecimal amount){
        CashAccount copy1= (CashAccount)tradeAccountRepository.getTradeAccount(id).clone();
        BigDecimal copy2=copy1.getCashBalance();
        BigDecimal copy3=copy2.subtract(amount);
        copy1.setCashbalance(copy3);
    }

    public void createTradeAccount(TradeAccount tradeAccount){
        CashAccount copy= (CashAccount)tradeAccount.clone();
        tradeAccountRepository.createTradeAccount(copy);
    }

    public CashAccount retreiveTradeAccount(String id){
        CashAccount copy= (CashAccount)tradeAccountRepository.getTradeAccount(id).clone();
        return copy;
    }

    public void updateTradeAccount(TradeAccount tradeAccount){
        CashAccount copy= (CashAccount)tradeAccount.clone();
        tradeAccountRepository.createTradeAccount(copy);
    }

    public void deleteTradeAccount(String id){
        tradeAccountRepository.deleteTradeAccount(id);
    }

}
