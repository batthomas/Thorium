package ch.herzog.thorium.module;

import ch.herzog.thorium.module.movement.NoFallModule;
import ch.herzog.thorium.module.movement.SpiderModule;
import ch.herzog.thorium.module.render.FullbrightModule;

import java.util.HashMap;
import java.util.Map;

public class ModuleManager {

    private Map<String, Module> modules;

    public ModuleManager() {
        modules = new HashMap<>();
        initModules();
    }

    private void initModules() {
        addModule(new NoFallModule());
        addModule(new SpiderModule());
        addModule(new FullbrightModule());
    }

    private void addModule(Module module) {
        modules.put(module.getName().toLowerCase(), module);
    }

    public Module getModule(String name) {
        return modules.get(name.toLowerCase());
    }
}
