package Classes.Classwork;

public class Manager extends Employee{
    private int teamSize;

    public Manager(String name,int salary){
        super(name,salary);
        this.teamSize=(int)Math.floor(Math.random()*10);
    }

    @Override
    public void work(){
        System.out.printf("Менеджер %s управляет командой из %d человек, зарплата: %d\n",super.getName(),getTeamSize(),super.getSalary());
    }

    private int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize>0?teamSize:0;
    }
}
