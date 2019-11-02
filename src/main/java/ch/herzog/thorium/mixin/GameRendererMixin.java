package ch.herzog.thorium.mixin;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.events.RenderEvent;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(at = @At(value = "INVOKE"),
            method = "renderCenter(FJ)V")
    private void onRenderCenter(float partialTicks, long finishTimeNano, CallbackInfo ci) {
        RenderEvent event = new RenderEvent(partialTicks);
        ThoriumClient.INSTANCE.getEventManager().fire(event);
    }

}

