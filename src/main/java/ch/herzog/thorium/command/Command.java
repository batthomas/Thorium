package ch.herzog.thorium.command;

import ch.herzog.thorium.command.exception.CommandException;

public abstract class Command {

    private String name;
    private String description;
    private String alias;

    public Command(String name, String description, String alias) {
        this.name = name;
        this.description = description;
        this.alias = alias;
    }

    public abstract void call(String[] args) throws CommandException;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
