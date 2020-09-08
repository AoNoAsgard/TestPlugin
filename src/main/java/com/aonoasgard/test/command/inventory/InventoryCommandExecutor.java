package com.aonoasgard.test.command.inventory;

import com.aonoasgard.test.PrimoPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryCommandExecutor implements CommandExecutor {
    private final PrimoPlugin plugin;

    public InventoryCommandExecutor(PrimoPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("inventory")){
            if(args.length != 1) {
                sender.sendMessage("Devi specificare un giocatore");
                return false;
            }
            if(!(sender instanceof Player)){
                sender.sendMessage("Solo i giocatori possono eseguire questo comando");
                return false;
            }
            Player target = plugin.getServer().getPlayer(args[0]);

            if(target ==null){
                sender.sendMessage(args[0]+ " non è online");
                return false;
            }

            if(target.getName().equals(sender.getName())){
                sender.sendMessage("Non puoi aprire il tuo inventario");
                return false;
            }


            Inventory inventario = target.getInventory();
            Player giocatore = (Player) sender;

            giocatore.openInventory(inventario);

        }
        return false;
    }
}
