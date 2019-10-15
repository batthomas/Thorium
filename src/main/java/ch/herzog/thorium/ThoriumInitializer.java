package ch.herzog.thorium;

import net.fabricmc.api.ModInitializer;

public class ThoriumInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        ThoriumClient client = ThoriumClient.INSTANCE;
        client.initialize();
    }

}
