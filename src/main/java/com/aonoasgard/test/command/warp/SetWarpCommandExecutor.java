package com.aonoasgard.test.command.warp;

import com.aonoasgard.test.PrimoPlugin;
import com.aonoasgard.test.file.JsonIstructions;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;

public class SetWarpCommandExecutor implements CommandExecutor {
    private final PrimoPlugin plugin;

    public SetWarpCommandExecutor(PrimoPlugin plugin){ this.plugin = plugin;}


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("setwarp")){
            if(args.length != 1) {
                sender.sendMessage("Devi specificare il nome da assegnare al warp");
                return false;
            }
            if(!(sender instanceof Player)){
                sender.sendMessage("Solo i giocatori possono eseguire questo comando");
                return false;
            }
            Location posizione = ((Player) sender).getLocation();
            JSONObject oggetto = JsonIstructions.locToJson(posizione);
            plugin.jsonIstructions.setObject(args[0],oggetto);
            plugin.jsonIstructions.save();
            sender.sendMessage(ChatColor.GREEN+"il warp "+ChatColor.YELLOW+args[0]+ChatColor.GREEN+
                    " e' stato settato alla posizione "+
                    ChatColor.AQUA +" X:" +ChatColor.YELLOW+posizione.getBlockX()+
                    ChatColor.AQUA +" Y:" +ChatColor.YELLOW+posizione.getBlockY()+
                    ChatColor.AQUA +" Z:" +ChatColor.YELLOW+posizione.getBlockZ());

            return true;
        }
        return false;
    }
}
