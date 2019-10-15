package ch.herzog.thorium.command.commands;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.command.Command;
import ch.herzog.thorium.command.exception.CommandException;
import ch.herzog.thorium.command.exception.InvalidSyntaxException;
import ch.herzog.thorium.module.Module;
import ch.herzog.thorium.module.ModuleManager;

public class ToggleCommand extends Command {

    public ToggleCommand() {
        super("Toggle", "Toggle Modules", "toggle");
    }

    @Override
    public void call(String[] args) throws CommandException {
        if (args.length != 1) {
            throw new InvalidSyntaxException("Wrong arguments");
        }
        ModuleManager moduleManager = ThoriumClient.INSTANCE.getModuleManager();
        Module module = moduleManager.getModule(args[0]);
        if (module != null) {
            module.setActive(!module.isActive());
        } else {
            throw new CommandException("Module not found");
        }
    }
}
