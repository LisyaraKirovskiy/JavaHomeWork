package Classes;

import java.io.*;

public class PasswordManager {
    String placeWhereWillBeUsed;
    String typeOfPlace;
    String login;
    String password;
    final private String PATH="src/Files";
    final private String FILE_NAME="Passwords.txt";

    public PasswordManager(){
        this.placeWhereWillBeUsed="Не указано";
        this.typeOfPlace="Не указано";
        this.login="Не указано";
        this.password="Не указано";
    }

    public void generateRandomPassword(){
        boolean generated=false;
        StringBuilder readyPassword= new StringBuilder();
        while(!generated){
            int randomNumber=(int)Math.floor(Math.random()*((126-33)+1)+33);
            readyPassword.append((char) randomNumber);
            if(readyPassword.length()==16) generated=true;
        }
        setPassword(readyPassword.toString());
    }

    public void savePassword(){
        File passwordsFile= new File(getPATH(),getFILE_NAME());
        if(!passwordsFile.exists()) {
            try {
                passwordsFile.createNewFile();
            }catch (IOException e){
                System.out.println("Ошибка создания файла\n"+e.toString());
            }
        }
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(passwordsFile, true));
            printWriter.printf("%s : %s (%s) [%s]\n",getLogin(),getPassword(),getPlaceWhereWillBeUsed(),getTypeOfPlace());
            printWriter.close();
        }catch (IOException e){
            System.out.println("Ошибка добавления новой записи\n"+e.toString());
        }
    }

    public void setPlaceWhereWillBeUsed(String placeWhereWillBeUsed){
        this.placeWhereWillBeUsed=placeWhereWillBeUsed;
    }
    private String getPlaceWhereWillBeUsed(){
        return this.placeWhereWillBeUsed;
    }

    public void setTypeOfPlace(String typeOfPlace){
        this.typeOfPlace=typeOfPlace;
    }
    private String getTypeOfPlace(){
        return this.typeOfPlace;
    }

    public void setLogin(String login){
        this.login=login;
    }
    private String getLogin(){
        return this.login;
    }

    public void setPassword(String password){
        this.password=password;
    }
    private String getPassword(){
        return this.password;
    }

    private String getPATH() {
        return this.PATH;
    }
    private String getFILE_NAME(){
        return this.FILE_NAME;
    }

    public void getPasswords(String typeOfPlace){
        File passwordsFile=new File(getPATH(),getFILE_NAME());
        if(passwordsFile.exists()){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(passwordsFile));
                String line;
                while((line=bufferedReader.readLine())!=null){
                    if(typeOfPlace=="all"|| typeOfPlace==""){
                        System.out.println(line);
                    }else if(line.contains(typeOfPlace)){
                        System.out.println(line);
                    }
                }
            }catch (IOException e){
                System.out.println("Ошибка чтения файла - его не существует\n"+e.toString());
            }
        }
    }

    public void deleteFileWithPasswords(){
        File passwordsFile=new File(getPATH(),getFILE_NAME());
        try {
            passwordsFile.delete();
        }catch (Exception e){
            System.out.println("Ошибка удаления файла\n"+e.toString());
        }
    }

    public void clearFileWithPasswords(){
        File passwordsFile=new File(getPATH(),getFILE_NAME());
        try {
            PrintWriter printWriter = new PrintWriter(passwordsFile);
            printWriter.println("");
        }catch (Exception e){
            System.out.println("Ошибка очищения файла\n"+e.toString());
        }
    }

}
