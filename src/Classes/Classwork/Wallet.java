package Classes.Classwork;

public class Wallet extends PaymentMethod{
    public Wallet(String ownerName, double balance) {
        super(ownerName, balance);
    }

    @Override
    public void pay(double amount) {
        double amountWithCommission= amount+amount*0.02;
        if(amountWithCommission<super.getBalance()){
            super.setBalance(-amountWithCommission);
        }else{
            System.out.println("Недостаточно денег для оплаты с комиссией");
        }
    }
}
