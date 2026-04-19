package Classes.Classwork;

import Classes.BankAccount;

public class BankCard extends PaymentMethod{
    public BankCard(String ownerName,double balance){
        super(ownerName,balance);
    }

    @Override
    public void pay(double amount) {
        if(super.getBalance()>=amount) {
            double newBalance= super.getBalance()-amount;
            super.setBalance(newBalance);
        }else{
            System.out.println("\nОшибка: Недостаточно денег для оплаты");
        }
    }
}
