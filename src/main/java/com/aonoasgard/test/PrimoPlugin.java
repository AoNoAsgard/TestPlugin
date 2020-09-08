package com.aonoasgard.test;

import com.aonoasgard.test.command.CommandsInitializer;
import com.aonoasgard.test.event.EventsInitializer;
import org.bukkit.plugin.java.JavaPlugin;

public class PrimoPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage("Plugin Test Pronto");
        CommandsInitializer.initialize(this);
        EventsInitializer.initialize(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
