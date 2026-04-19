package Classes.Classwork;

public class Employee {
    private String name;
    private int salary;

    public Employee(){
        this.name="Не указано";
        this.salary=0;
    }
    public Employee(String name,int salary){
        setName(name);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name.isEmpty()?"Не указано":name;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        if(salary>0){
            this.salary=salary;
        }else{
            this.salary=0;
        }
    }

    public void work(){
        System.out.println("Сотрудник работает\n");
    }

}
