package Classes.Classwork;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()){
            this.name="Не указано";
        }else{
            this.name = name;
        }

    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age<0){
            this.age = 0;
        }else{
            this.age=age;
        }
    }
    public void makeSound(){
        System.out.println("Животное издает звук");
    }
}
