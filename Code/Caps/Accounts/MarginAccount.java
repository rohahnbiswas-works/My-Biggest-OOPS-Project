package Caps.Accounts;

import java.math.*;

public class MarginAccount extends TradeAccount {
    private BigDecimal margin;

    public MarginAccount(String id,BigDecimal margin){
        super(id);
        setMargin(margin);
    }

    public void setMargin(BigDecimal margin){
        BigDecimal copy= margin;
        this.margin=copy;
    }

    public BigDecimal getMargin(){
        BigDecimal copy= margin;
        return copy;
    }

    @Override
    public TradeAccount clone(){
        MarginAccount copy=new MarginAccount(this.getID(),this.margin);
        return copy;
    }
}
