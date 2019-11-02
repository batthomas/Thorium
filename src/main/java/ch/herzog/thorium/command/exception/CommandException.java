package ch.herzog.thorium.command.exception;

import ch.herzog.thorium.ThoriumClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.LiteralText;

public class CommandException extends Exception {

    public CommandException(String message) {
        super(message);
    }

    public void print() {
        ChatHud chatHud = ThoriumClient.INSTANCE.getMinecraft().inGameHud.getChatHud();
        chatHud.addMessage(new LiteralText("[Thorium] " + getMessage()));
    }
}
