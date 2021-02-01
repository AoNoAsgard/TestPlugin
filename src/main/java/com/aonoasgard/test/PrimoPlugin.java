package com.aonoasgard.test;

import com.aonoasgard.test.command.CommandsInitializer;
import com.aonoasgard.test.event.EventsInitializer;
import com.aonoasgard.test.file.JsonIstructions;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class PrimoPlugin extends JavaPlugin {
    public JsonIstructions jsonIstructions ;

    @Override
    public void onEnable() {
        jsonIstructions = new JsonIstructions(new File("test/warps.json"));
        CommandsInitializer.initialize(this);
        EventsInitializer.initialize(this);

        getServer().getConsoleSender().sendMessage("Plugin Test Pronto");
    }

    @Override
    public void onDisable() {
        jsonIstructions.save();
        // Plugin shutdown logic
    }
}
