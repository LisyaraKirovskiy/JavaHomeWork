public class Divider {
    int a;
    int b;
    int result;

    public Divider(int a,int b){
        this.a=a;
        this.b=b;
    }

    public void divide(){
        try{
            this.result=a/ b;
        }catch (ArithmeticException e){
            throw new ArithmeticException("Ошибка деления на ноль!");
        }
    }

    public void printResult(){
        System.out.println("Результат: " + a + " / " + b + " = " + this.result);
    }
}
