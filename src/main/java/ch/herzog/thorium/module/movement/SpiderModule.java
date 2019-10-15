package ch.herzog.thorium.module.movement;

import ch.herzog.thorium.ThoriumClient;
import ch.herzog.thorium.event.listeners.UpdateListener;
import ch.herzog.thorium.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;

public class SpiderModule extends Module implements UpdateListener {

    private double speed;

    public SpiderModule() {
        super("Spider", "Climb walls like a spider");
        speed = 0.2;
    }

    @Override
    public void onUpdate() {
        ClientPlayerEntity player = ThoriumClient.INSTANCE.getMinecraft().player;
        if (player.horizontalCollision){
            Vec3d velocity = player.getVelocity();
            if (velocity.y >= 0.2){
                return;
            }
            player.setVelocity(velocity.x, speed, velocity.z);
        }
    }

}
