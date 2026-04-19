package Classes.Classwork;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println("Собака говорит Гав");
    }
}
