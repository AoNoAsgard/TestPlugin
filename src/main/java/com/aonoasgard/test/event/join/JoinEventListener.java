package com.aonoasgard.test.event.join;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinEventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(ChatColor.GREEN +"Benvenuto "+ ChatColor.DARK_PURPLE +event.getPlayer().getName()+"!");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        event.setQuitMessage(ChatColor.DARK_PURPLE +event.getPlayer().getName()+ ChatColor.RED +" ha abbandonato il server");
    }



}
