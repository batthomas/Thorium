package ch.herzog.thorium.module.movement;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.listeners.UpdateListener;
import ch.herzog.thorium.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.server.network.packet.PlayerMoveC2SPacket;

public class NoFallModule extends Module implements UpdateListener {

    public NoFallModule() {
        super("NoFall", "No fall damage");
    }

    @Override
    public void onUpdate() {
        ClientPlayerEntity player = ThoriumClient.INSTANCE.getMinecraft().player;
        if(player.fallDistance >= 2){
            player.networkHandler.sendPacket(new PlayerMoveC2SPacket(true));
        }
    }
}