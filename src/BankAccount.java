public class BankAccount {
    String owner;
    double balance;

    public BankAccount(String owner,double balance){
        this.owner=owner;
        if(balance<0) throw new IllegalArgumentException("Начальный баланс меньше нуля!");
        this.balance=balance;
    }

    public void deposit(double amount){
        if(amount<=0) throw new IllegalArgumentException("Невозможно внести сумму меньше или равную нулю!");
        this.balance+=amount;
    }

    public void withdraw(double amount){
        if(amount<=0) throw new IllegalArgumentException("Невозможно снять сумму меньше или равную нулю!");
        if(this.balance>=amount){
            this.balance-=amount;
        }else{
            throw new IllegalArgumentException("На балансе нет столько денег для снятия!");
        }
    }

    private double getBalance(){
        return this.balance;
    }

    private String getOwner(){
        return this.owner;
    }

    public void printInfo(){
        System.out.println("Владелец счета: "+getOwner()+"\n"+"Баланс счета: "+ getBalance());
    }
}
