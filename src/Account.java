import java.lang.Math;

public class Account {

    private int accountNumber;
    private int pin;
    private int balance;
    private String accountHolder;

    public Account(int accountNumber, int pin, String accountHolder){
        this.accountNumber=accountNumber;
        this.pin=pin;
        this.accountHolder=accountHolder;
        this.balance=0;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public int getBalance(){
        return this.balance;
    }

    public void deposit(int deposit){
        this.balance+=deposit;
    }

    public void withdrawal(int withdrawal){
        this.balance-=withdrawal;
    }

    public int getPin(){
        return this.pin;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

}
