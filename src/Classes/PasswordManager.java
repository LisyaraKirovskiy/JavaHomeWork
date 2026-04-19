package Classes;

import java.io.*;

public class PasswordManager {
    private String placeWhereWillBeUsed;
    private String typeOfPlace;
    private String login;
    private String password;
    final private String PATH = "src/Files";
    final private String FILE_NAME = "Passwords.txt";

    public PasswordManager() {
        this.placeWhereWillBeUsed = "Не указано";
        this.typeOfPlace = "Не указано";
        this.login = "Не указано";
        this.password = "Не указано";
    }

    public void generateRandomPassword() {
        boolean generated = false;
        StringBuilder readyPassword = new StringBuilder();
        while (!generated) {
            int randomNumber = (int) Math.floor(Math.random() * ((126 - 33) + 1) + 33);
            readyPassword.append((char) randomNumber);
            if (readyPassword.length() == 16) generated = true;
        }
        setPassword(readyPassword.toString());
    }

    public void savePassword() {
        File directory = new File(getPATH());
        if (!directory.exists()) {
            try {
                directory.mkdir();
            } catch (Exception e) {
                System.out.println("Ошибка создания папки Files\n" + e.toString());
            }
        }
        File passwordsFile = new File(getPATH(), getFILE_NAME());
        if (!passwordsFile.exists()) {
            try {
                passwordsFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка создания файла\n" + e.toString());
            }
        }
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(passwordsFile, true));
            printWriter.printf("%s : %s (%s) [%s]\n", getLogin(), getPassword(), getPlaceWhereWillBeUsed(), getTypeOfPlace());
        } catch (IOException e) {
            System.out.println("Ошибка добавления новой записи\n" + e.toString());
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    public void setPlaceWhereWillBeUsed(String placeWhereWillBeUsed) {
        if (!placeWhereWillBeUsed.isEmpty()) this.placeWhereWillBeUsed = placeWhereWillBeUsed;
    }

    private String getPlaceWhereWillBeUsed() {
        return this.placeWhereWillBeUsed;
    }

    public void setTypeOfPlace(String typeOfPlace) {
        if (!typeOfPlace.isEmpty()) this.typeOfPlace = typeOfPlace;
    }

    private String getTypeOfPlace() {
        return this.typeOfPlace;
    }

    public void setLogin(String login) {
        if (!login.isEmpty()) this.login = login;
    }

    private String getLogin() {
        return this.login;
    }

    public void setPassword(String password) {
        if (!password.isEmpty()) this.password = password;
    }

    private String getPassword() {
        return this.password;
    }

    private String getPATH() {
        return this.PATH;
    }

    private String getFILE_NAME() {
        return this.FILE_NAME;
    }

    public void getPasswords(String typeOfPlace) {
        File passwordsFile = new File(getPATH(), getFILE_NAME());
        if (passwordsFile.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(passwordsFile));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (typeOfPlace == "all" || typeOfPlace == "") {
                        System.out.println(line);
                    } else if (line.contains(typeOfPlace)) {
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла - его не существует\n" + e.toString());
            }
        }
    }

    public void deleteFileWithPasswords() {
        File passwordsFile = new File(getPATH(), getFILE_NAME());
        System.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        try {
            passwordsFile.delete();
        } catch (Exception e) {
            System.out.println("Ошибка удаления файла\n" + e.toString());
        }
    }

    public void clearFileWithPasswords() {
        File passwordsFile = new File(getPATH(), getFILE_NAME());
        try {
            PrintWriter printWriter = new PrintWriter(passwordsFile);
            printWriter.println("");
        } catch (Exception e) {
            System.out.println("Ошибка очищения файла\n" + e.toString());
        }
    }
}

