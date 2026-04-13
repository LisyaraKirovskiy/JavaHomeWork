package Exceptions;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException() {
        super("Неверно указан логин! Логин не может быть пустым и меньше 4 символов!");
    }
}
