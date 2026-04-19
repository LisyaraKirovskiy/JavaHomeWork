package Classes.Classwork;

public class Developer extends Employee{
    private String programmingLanguage;

    public Developer(String name,int salary,int numberOfLanguage){
        super(name,salary);
        String[] languages={"C++","C#","Java","Go"};
        if(numberOfLanguage<4 && numberOfLanguage>=0) {
            this.programmingLanguage=languages[numberOfLanguage];
        }else{
            this.programmingLanguage="Фуллстэк";
        }
    }

    @Override
    public void work(){
        System.out.printf("Разработчик %s пишет код, зарплата: %d\n",super.getName(),super.getSalary());
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage.isEmpty()?programmingLanguage:"Не указано";
    }
}
