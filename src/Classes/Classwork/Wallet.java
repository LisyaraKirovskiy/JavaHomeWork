package Classes.Classwork;

public class Wallet extends PaymentMethod{
    public Wallet(String ownerName, double balance) {
        super(ownerName, balance);
    }

    @Override
    public void pay(double amount) {
        double amountWithCommission= amount+amount*0.02;
        if(amountWithCommission<=super.getBalance()){
            double newBalance= super.getBalance()-amountWithCommission;
            super.setBalance(newBalance);
        }else{
            System.out.println("\nНедостаточно денег для оплаты с комиссией");
        }
    }
}
