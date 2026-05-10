package Classes.Classwork;

public class StudentClasswork {
    private String name;
    private String group;
    private int grade;

    public StudentClasswork(String name,String group,int grade){
        this.name=name;
        this.group=group;
        this.grade=grade;
    }
    public StudentClasswork(){
        this.name="Undefined";
        this.group="Undefined";
        this.grade=-1;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getGrade() {
        return grade;
    }
}
