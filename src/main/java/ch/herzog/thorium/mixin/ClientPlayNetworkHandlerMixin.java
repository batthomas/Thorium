package ch.herzog.thorium.mixin;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.events.PacketSendEvent;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {

    @Inject(at = {@At("INVOKE")},
            method = {"sendPacket(Lnet/minecraft/network/Packet;)V"},
            cancellable = true)
    private void onSendPacket(Packet<?> packet, CallbackInfo callbackInfo) {
        PacketSendEvent event = new PacketSendEvent(packet);
        ThoriumClient.INSTANCE.getEventManager().fire(event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }

}
