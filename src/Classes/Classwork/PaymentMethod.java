package Classes.Classwork;

public abstract class PaymentMethod {
    private String ownerName;
    private double balance;

    public PaymentMethod(){
        this.ownerName="Не указано";
        this.balance=0;
    }
    public PaymentMethod(String ownerName, double balance){
        setOwnerName(ownerName);
        setBalance(balance);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance>0?balance:0;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName.isEmpty()?"Не указано": ownerName;
    }

    public void deposit(double amount){
        if(amount>0) this.balance+=amount;
    }

    public abstract void pay(double amount);
}
