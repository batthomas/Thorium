package ch.herzog.thorium.command.exception;

public class CommandNotFoundException extends CommandException {

    public CommandNotFoundException(String input) {
        super("Command not found: " + input);
    }

}
