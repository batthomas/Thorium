package ch.herzog.thorium.command.commands;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.command.Command;
import ch.herzog.thorium.command.exception.CommandException;
import ch.herzog.thorium.command.exception.InvalidSyntaxException;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Optional;

public class EnchantCommand extends Command {

    public EnchantCommand() {
        super("Enchant", "Enchant Items", "enchant");
    }

    @Override
    public void call(String[] args) throws CommandException {
        if (args.length != 2 || !args[1].matches("^\\d+$")) {
            throw new InvalidSyntaxException("Wrong arguments");
        }

        ClientPlayerEntity player = ThoriumClient.INSTANCE.getMinecraft().player;
        if (!player.isCreative()) {
            throw new CommandException("Creative mode only");
        }

        ItemStack itemStack = player.getMainHandStack();
        if (itemStack == null || itemStack.getItem() == null) {
            return;
        }
        Optional<Enchantment> enchantment = Registry.ENCHANTMENT.getOrEmpty(new Identifier(args[0]));
        if (!enchantment.isPresent()) {
            throw new CommandException("Enchantment not found");
        }
        itemStack.addEnchantment(enchantment.get(), Integer.parseInt(args[1]));
    }
}
