package com.aonoasgard.test.command;

import com.aonoasgard.test.PrimoPlugin;
import com.aonoasgard.test.command.hunt.HuntCommandExecutor;
import com.aonoasgard.test.command.inventory.InventoryCommandExecutor;
import com.aonoasgard.test.command.test.TestCommandExecutor;
import com.aonoasgard.test.command.warp.SetWarpCommandExecutor;

public class CommandsInitializer {
    public static void initialize(PrimoPlugin plugin){
        plugin.getCommand("test").setExecutor(new TestCommandExecutor(plugin));
        plugin.getCommand("inventory").setExecutor(new InventoryCommandExecutor(plugin));
        plugin.getCommand("hunt").setExecutor(new HuntCommandExecutor(plugin));
        plugin.getCommand("setwarp").setExecutor(new SetWarpCommandExecutor(plugin));
    }
}
