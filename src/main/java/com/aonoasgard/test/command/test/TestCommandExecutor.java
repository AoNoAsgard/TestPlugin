package com.aonoasgard.test.command.test;

import com.aonoasgard.test.PrimoPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommandExecutor implements CommandExecutor {
    private final PrimoPlugin plugin;

    public TestCommandExecutor(PrimoPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command ,String label,String[] args){
        if(command.getName().equalsIgnoreCase("test")){
            sender.sendMessage(ChatColor.AQUA+"CIAO :D");
        }
        return true;
    }

}
