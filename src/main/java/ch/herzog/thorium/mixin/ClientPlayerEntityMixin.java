package ch.herzog.thorium.mixin;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.events.ChatOutputEvent;
import ch.herzog.thorium.event.events.UpdateEvent;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Inject(at = @At(value = "INVOKE"),
            method = "tick()V")
    private void onTick(CallbackInfo callbackInfo) {
        UpdateEvent event = new UpdateEvent();
        ThoriumClient.INSTANCE.getEventManager().fire(event);
    }

    @Inject(at = @At(value = "HEAD"),
            method = "sendChatMessage(Ljava/lang/String;)V",
            cancellable = true)
    private void onSendChatMessage(String message, CallbackInfo callbackInfo) {
        ChatOutputEvent event = new ChatOutputEvent(message);
        ThoriumClient.INSTANCE.getEventManager().fire(event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }

}
