package Caps.Repositories;

import java.util.HashMap;
import java.util.Map;
import Caps.Accounts.*;

public class TradeAccountRepository {
     private Map<String, TradeAccount> datastore = new HashMap<>();

     public void createTradeAccount(TradeAccount tradeAccount){
        TradeAccount copy=tradeAccount.clone();
        datastore.put(copy.getID(), copy);
     }

     public TradeAccount getTradeAccount(String id){
            return this.datastore.get(id)==null? null:this.datastore.get(id).clone();
     }

     public void updateTradeAccount(TradeAccount tradeAccount){
        TradeAccount copy=tradeAccount.clone();
        datastore.put(copy.getID(), copy);
     }

     public void deleteTradeAccount(String id){
        datastore.remove(id);
     }
}
