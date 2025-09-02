import java.math.BigDecimal;

import Caps.Accounts.CashAccount;
import Caps.Accounts.MarginAccount;
import Caps.Accounts.TradeAccount;
import Caps.Repositories.TradeAccountRepository;
import Caps.Service.CashAccountService;
import Caps.Service.MarginAccountService;;


public class Main {
    public static void main(String[] args){
        CashAccount cashAccount = new CashAccount("C123", new BigDecimal("1000.00"));
        System.out.println("Cash Account Details:");
        System.out.println("ID: " + cashAccount.getID());
        System.out.println("Cash Balance: " + cashAccount.getCashBalance());
 
        CashAccount clonedCashAccount =  (CashAccount)cashAccount.clone();
        System.out.println("Cloned Cash Account Details:");
        System.out.println("ID: " + clonedCashAccount.getID());
        System.out.println("Cash Balance: " + clonedCashAccount.getCashBalance());
 
        System.out.println();
 
        MarginAccount marginAccount = new MarginAccount("M456", new BigDecimal("5000.00"));
        System.out.println("Margin Account Details:");
        System.out.println("ID: " + marginAccount.getID());
        System.out.println("Margin: " + marginAccount.getMargin());
 
        MarginAccount clonedMarginAccount = (MarginAccount) marginAccount.clone();
        System.out.println("Cloned Margin Account Details:");
        System.out.println("ID: " + clonedMarginAccount.getID());
        System.out.println("Margin: " + clonedMarginAccount.getMargin());

        TradeAccountRepository repository = new TradeAccountRepository();
 
        CashAccount cashAccount1 = new CashAccount("C123", new BigDecimal("1000.00"));
        repository.createTradeAccount(cashAccount1);
 
        MarginAccount marginAccount1 = new MarginAccount("M456", new BigDecimal("5000.00"));
        repository.createTradeAccount(marginAccount1);
 
        TradeAccount retrievedCashAccount = repository.getTradeAccount("C123");
        System.out.println("Retrieved Cash Account ID: " + retrievedCashAccount.getID());
        System.out.println("Cash Balance: " + ((CashAccount) retrievedCashAccount).getCashBalance());
 
        TradeAccount retrievedMarginAccount = repository.getTradeAccount("M456");
        System.out.println("Retrieved Margin Account ID: " + retrievedMarginAccount.getID());
        System.out.println("Margin: " + ((MarginAccount) retrievedMarginAccount).getMargin());

    TradeAccountRepository repository1 = new TradeAccountRepository();
    CashAccountService cashAccountService = new CashAccountService(repository);
    MarginAccountService marginAccountService = new MarginAccountService(repository);
 
    // Create CashAccount and MarginAccount objects
    CashAccount cashAccount2 = new CashAccount("1", BigDecimal.valueOf(1000));
    MarginAccount marginAccount2 = new MarginAccount("2", BigDecimal.valueOf(2000));
 
    // Add the accounts to the repository
    cashAccountService.createTradeAccount(cashAccount2);
    marginAccountService.createTradeAccount(marginAccount2);
 
    // Deposit and withdraw amounts
    cashAccountService.deposit("1", BigDecimal.valueOf(500));
    cashAccountService.withdraw("1", BigDecimal.valueOf(200));
    marginAccountService.deposit("2", BigDecimal.valueOf(1000));
    marginAccountService.withdraw("2", BigDecimal.valueOf(500));
 
    // Retrieve and print the updated account balances
    CashAccount updatedCashAccount = cashAccountService.retreiveTradeAccount("1");
    MarginAccount updatedMarginAccount = marginAccountService.retreiveTradeAccount("2");
    System.out.println("Updated CashAccount balance: " + updatedCashAccount.getCashBalance());
    System.out.println("Updated MarginAccount margin: " + updatedMarginAccount.getMargin());
 
    // Delete the accounts
    cashAccountService.deleteTradeAccount("1");
    marginAccountService.deleteTradeAccount("2");
    }
    
}
