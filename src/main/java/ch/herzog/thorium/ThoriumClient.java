package ch.herzog.thorium;

import ch.herzog.thorium.command.CommandManager;
import ch.herzog.thorium.event.EventManager;
import ch.herzog.thorium.gui.hud.InGameHud;
import ch.herzog.thorium.module.ModuleManager;
import net.minecraft.client.MinecraftClient;

public enum ThoriumClient {
    INSTANCE;

    private EventManager eventManager;
    private ModuleManager moduleManager;
    private CommandManager commandManager;

    public void initialize() {
        eventManager = new EventManager();
        moduleManager = new ModuleManager();

        commandManager = new CommandManager();
        eventManager.add(commandManager);

        InGameHud hud = new InGameHud();
        hud.setActive(true);
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public MinecraftClient getMinecraft() {
        return MinecraftClient.getInstance();
    }

}
