package ch.herzog.thorium.mixin;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.events.ChatOutputEvent;
import ch.herzog.thorium.event.events.UpdateEvent;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {

    public ClientPlayerEntityMixin(ClientWorld clientWorld, GameProfile gameProfile) {
        super(clientWorld, gameProfile);
    }

    @Inject(at = @At(value = "INVOKE"),
            method = "tick()V")
    private void onTick(CallbackInfo callbackInfo) {
        UpdateEvent updateEvent = new UpdateEvent();
        ThoriumClient.INSTANCE.getEventManager().fire(updateEvent);
    }

    @Inject(at = @At(value = "HEAD"),
            method = "sendChatMessage(Ljava/lang/String;)V",
            cancellable = true)
    private void onSendChatMessage(String message, CallbackInfo callbackInfo) {
        ChatOutputEvent chatOutputEvent = new ChatOutputEvent(message);
        ThoriumClient.INSTANCE.getEventManager().fire(chatOutputEvent);
        if (chatOutputEvent.isCancelled()) {
            callbackInfo.cancel();
        }
    }

}
