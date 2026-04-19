package Classes.Classwork;

import Classes.BankAccount;

public class BankCard extends PaymentMethod{
    public BankCard(String ownerName,double balance){
        super(ownerName,balance);
    }

    @Override
    public void pay(double amount) {
        if(super.getBalance()>amount) {
            super.setBalance(-amount);
        }else{
            System.out.println("Ошибка: Недостаточно денег для оплаты");
        }
    }
}
