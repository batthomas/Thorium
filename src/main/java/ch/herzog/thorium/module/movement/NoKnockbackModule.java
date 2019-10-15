package ch.herzog.thorium.module.movement;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.events.PacketReceiveEvent;
import ch.herzog.thorium.event.listeners.PacketReceiveListener;
import ch.herzog.thorium.module.Module;
import net.minecraft.client.network.packet.EntityVelocityUpdateS2CPacket;

public class NoKnockbackModule extends Module implements PacketReceiveListener {

    public NoKnockbackModule() {
        super("NoKnockback", "Disables Knockback");
    }

    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        if (event.getPacket() instanceof EntityVelocityUpdateS2CPacket) {
            EntityVelocityUpdateS2CPacket packet = (EntityVelocityUpdateS2CPacket) event.getPacket();
            if (ThoriumClient.INSTANCE.getMinecraft().player.getEntityId() == packet.getId()) {
                event.setCancelled(true);
            }
        }
    }

}
