import Exceptions.InvalidAgeException;
import Exceptions.InvalidEmailException;
import Exceptions.InvalidLoginException;

public class User {
    String login;
    String email;
    int age;

    public User(String login, String email, int age){
        this.login=validateLogin(login);
        this.email=validateEmail(email);
        this.age=validateAge(age);
    }

    private String validateLogin(String login){
        if(login==null || login.length()<4) throw new InvalidLoginException();
        return login;
    }

    private String validateEmail(String email){
        if(!email.contains("@")) throw new InvalidEmailException();
        return email;
    }

    private int validateAge(int age){
        if(age<12) throw new InvalidAgeException();
        return age;
    }

    public void printUserInfo(){
        System.out.printf("Логин: %s\nПочта: %s\nВозраст: %d",this.login,this.email,this.age);
    }

}
