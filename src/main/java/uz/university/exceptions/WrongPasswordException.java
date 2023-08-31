package uz.university.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class WrongPasswordException extends Throwable{
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }

    public WrongPasswordException(String message, Throwable cause) {
        super(message, cause);
    }
}
