package ch.herzog.thorium.mixin;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.events.GUIRenderEvent;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(at = @At(value = "TAIL"),
            method = "render(F)V")
    private void onRender(float partialTicks, CallbackInfo callbackInfo) {
        GUIRenderEvent event = new GUIRenderEvent(partialTicks);
        ThoriumClient.INSTANCE.getEventManager().fire(event);
    }
}
