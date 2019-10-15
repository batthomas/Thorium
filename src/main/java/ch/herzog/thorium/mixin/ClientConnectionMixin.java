package ch.herzog.thorium.mixin;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.events.PacketReceiveEvent;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public class ClientConnectionMixin {

    @Inject(at = @At(value = "INVOKE"),
            method = "method_10770(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V",
            cancellable = true)
    private void onPacketReceive(ChannelHandlerContext channelHandlerContext, Packet<?> packet, CallbackInfo callbackInfo) {
        PacketReceiveEvent event = new PacketReceiveEvent(packet);
        ThoriumClient.INSTANCE.getEventManager().fire(event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }

}
