package Exceptions;

public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException() {
        super("Неверно указан возраст! Возраст должен быть не менее 12 лет");
    }
}
