package Exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
        super("Неверно указана почта! В почте должен содержаться знак @");
    }
}
