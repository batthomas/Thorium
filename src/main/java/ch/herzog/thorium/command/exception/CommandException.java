package ch.herzog.thorium.command.exception;

public class CommandException extends Exception {

    public CommandException(String message) {
        super(message);
    }

    public void print() {
        System.out.println(getMessage());
    }
}
