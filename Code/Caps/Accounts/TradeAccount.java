package Caps.Accounts;

public abstract class TradeAccount{
    private String id;

    public TradeAccount(String id){
        setID(id);
    }

    public void setID(String id){
        String copy=id;
        this.id=copy;
    }

    public String getID(){
        String copy=id;
        return copy;
    }

    public abstract TradeAccount clone();
}