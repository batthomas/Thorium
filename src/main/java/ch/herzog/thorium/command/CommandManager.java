package ch.herzog.thorium.command;

import ch.herzog.thorium.command.commands.ToggleCommand;
import ch.herzog.thorium.command.exception.CommandException;
import ch.herzog.thorium.command.exception.CommandNotFoundException;
import ch.herzog.thorium.event.events.ChatOutputEvent;
import ch.herzog.thorium.event.listeners.ChatOutputListener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandManager implements ChatOutputListener {

    private char prefix;
    private Map<String, Command> commands;

    public CommandManager() {
        commands = new HashMap<>();
        prefix = '*';
        initCommands();
    }

    private void initCommands() {
        Command cmd = new ToggleCommand();
        commands.put(cmd.getAlias(), cmd);
    }

    @Override
    public void onSendMessage(ChatOutputEvent event) {
        String message = event.getMessage().trim();
        if (!message.startsWith(String.valueOf(prefix)) || message.length() < 2) {
            return;
        }
        event.setCancelled(true);

        try {
            Command command = processCommand(message.substring(1));
            invokeCommand(command, message);
        } catch (CommandException e) {
            e.print();
        }

    }

    private Command processCommand(String input) throws CommandException {
        String commandName = input.split(" ")[0];
        Command command = commands.get(commandName);
        if (command != null) {
            return command;
        }
        throw new CommandNotFoundException(input);
    }

    private void invokeCommand(Command command, String input) throws CommandException {
        String[] args = input.split(" ");
        if (args.length >= 2) {
            args = Arrays.copyOfRange(args, 1, args.length);
        } else {
            args = new String[]{};
        }
        command.call(args);
    }

}
