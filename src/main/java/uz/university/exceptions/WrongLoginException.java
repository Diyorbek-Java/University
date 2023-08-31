package uz.university.exceptions;

public class WrongLoginException extends Throwable{
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }

}
