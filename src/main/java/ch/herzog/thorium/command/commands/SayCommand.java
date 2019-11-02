package ch.herzog.thorium.command.commands;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.command.Command;
import ch.herzog.thorium.command.exception.CommandException;
import ch.herzog.thorium.command.exception.InvalidSyntaxException;
import net.minecraft.server.network.packet.ChatMessageC2SPacket;

import java.util.Objects;

public class SayCommand extends Command {

    public SayCommand() {
        super("Say", "Write in the chat", "say");
    }

    @Override
    public void call(String[] args) throws CommandException {
        if (args.length == 0) {
            throw new InvalidSyntaxException("Wrong arguments");
        }
        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            builder.append(arg);
        }
        ChatMessageC2SPacket packet = new ChatMessageC2SPacket(builder.toString());
        Objects.requireNonNull(ThoriumClient.INSTANCE.getMinecraft().getNetworkHandler()).sendPacket(packet);
    }

}
