package Caps.Service;

import java.math.BigDecimal;
import Caps.Accounts.*;
import Caps.Repositories.*;

public class MarginAccountService implements TradeAccountService{

    private TradeAccountRepository tradeAccountRepository;

    public MarginAccountService(TradeAccountRepository tradeAccountRepository){
        this.tradeAccountRepository=tradeAccountRepository;
    }
    @Override
    public void deposit(String id, BigDecimal amount){ 
       MarginAccount copy1= (MarginAccount)tradeAccountRepository.getTradeAccount(id).clone();
       BigDecimal copy2=copy1.getMargin();
       BigDecimal copy3=copy2.add(amount);
       copy1.setMargin(copy3);
    }
    @Override
    public void withdraw(String id, BigDecimal amount){
       MarginAccount copy1= (MarginAccount)tradeAccountRepository.getTradeAccount(id).clone();
        BigDecimal copy2=copy1.getMargin();
        BigDecimal copy3=copy2.subtract(amount);
        copy1.setMargin(copy3);
    }

    public void createTradeAccount(TradeAccount tradeAccount){
       MarginAccount copy= (MarginAccount)tradeAccount.clone();
       tradeAccountRepository.createTradeAccount(copy);
    }

    public MarginAccount retreiveTradeAccount(String id){
       MarginAccount copy= (MarginAccount)tradeAccountRepository.getTradeAccount(id).clone();
        return copy;
    }

    public void updateTradeAccount(TradeAccount tradeAccount){
       MarginAccount copy= (MarginAccount)tradeAccount.clone();
        tradeAccountRepository.createTradeAccount(copy);
    }

    public void deleteTradeAccount(String id){
        tradeAccountRepository.deleteTradeAccount(id);
    }

}
