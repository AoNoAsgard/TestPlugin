package com.aonoasgard.test.command.hunt;

import com.aonoasgard.test.PrimoPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HuntCommandExecutor implements CommandExecutor {
    private final PrimoPlugin plugin;

    public static boolean incorso=false;

    public HuntCommandExecutor(PrimoPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("hunt")){
            if(args.length!=1){
                sender.sendMessage("Prova ad eseguire /hunt help");
                return false;
            }

            if(args[0].equals("help")){
                sender.sendMessage(ChatColor.GREEN+"LISTA DEI COMANDI");
                sender.sendMessage(ChatColor.GOLD+"/hunt help"+ChatColor.GREEN+" -Apre questa lista dei comandi.");
                sender.sendMessage(ChatColor.GOLD+"/hunt info"+ChatColor.GREEN+" -Da informazioni riguardo la caccia.");
                sender.sendMessage(ChatColor.GOLD+"/hunt start"+ChatColor.GREEN+" -Inizia l'evento della caccia.");
                sender.sendMessage(ChatColor.GOLD+"/hunt stop"+ChatColor.GREEN+" -Ferma l'evento della caccia.");
                sender.sendMessage(ChatColor.GOLD+"/hunt status"+ChatColor.GREEN+" -Da informazioni riguardo lo stato della caccia.");
                return true;
            }
            if(args[0].equals("start")){
                if(incorso)
                    sender.sendMessage(ChatColor.DARK_RED+"La caccia è già iniziata");
                else {
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "LA CACCIA E' INIZIATA");
                    ((Player) sender).playEffect(EntityEffect.TOTEM_RESURRECT);
                    ((Player) sender).playEffect(EntityEffect.CAT_TAME_SUCCESS);
                    ((Player) sender).playEffect(EntityEffect.ARROW_PARTICLES);
                    incorso = true;
                }
                return true;
            }
            if(args[0].equals("stop")){
                if(!incorso)
                    sender.sendMessage(ChatColor.DARK_RED+"La caccia non è iniziata");
                else {
                    Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "LA CACCIA E' FINITA");
                    ((Player) sender).playEffect(EntityEffect.THORNS_HURT);
                    ((Player) sender).playEffect(EntityEffect.FOX_CHEW);
                    ((Player) sender).playEffect(EntityEffect.BREAK_EQUIPMENT_CHESTPLATE);
                    incorso = false;
                }
                return true;
            }
            if(args[0].equals("status")){
                if(incorso)
                    sender.sendMessage(ChatColor.DARK_GREEN+"La caccia è in corso");
                else
                    sender.sendMessage(ChatColor.DARK_RED+"La caccia non è in corso");
                return true;
            }


        }
        return false;
    }
}
