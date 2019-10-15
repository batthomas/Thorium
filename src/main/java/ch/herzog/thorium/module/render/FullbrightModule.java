package ch.herzog.thorium.module.render;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.module.Module;
import net.minecraft.client.options.GameOptions;

public class FullbrightModule extends Module {

    public FullbrightModule() {
        super("Fullbright", "No darkness");
    }

    @Override
    protected void onEnable() {
        super.onEnable();
        GameOptions options = ThoriumClient.INSTANCE.getMinecraft().options;
        options.gamma = 16;
    }

    @Override
    protected void onDisable() {
        super.onDisable();
        GameOptions options = ThoriumClient.INSTANCE.getMinecraft().options;
        options.gamma = 0.5;
    }
}
