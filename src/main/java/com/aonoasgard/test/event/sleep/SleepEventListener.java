package com.aonoasgard.test.event.sleep;

import org.bukkit.*;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SleepEventListener implements Listener {

    //@EventHandler
    public void onSleep(PlayerBedEnterEvent event){
        int random =(int)(Math.random()*10+1);
        //Bukkit.broadcastMessage(Integer.toString(random));
        if(random==1){
            int x = (int)(Math.random()*7-3);
            int z = (int)(Math.random()*7-3);
            Location loc = event.getPlayer().getLocation().add(x,0,z);
            //Bukkit.broadcastMessage("x="+x+",z="+z);
            loc.getWorld().spawnEntity(loc,EntityType.CREEPER);
        }
    }

    @EventHandler
    public void getUp(PlayerBedLeaveEvent event){
        int random =(int)(Math.random()*10+1);
        if(random==1) {
            event.getPlayer().sendMessage("Hai dormito male, ti senti rangrinzito e stanco");
            Collection<PotionEffect> effetti = new HashSet<PotionEffect>();
            effetti.add(new PotionEffect(PotionEffectType.BLINDNESS, 60, 3));
            effetti.add(new PotionEffect(PotionEffectType.SLOW, 60, 3));
            event.getPlayer().addPotionEffects(effetti);
            event.getPlayer().setFoodLevel(event.getPlayer().getFoodLevel()-4);
            effetti.clear();
        }
        if(random==2){
            event.getPlayer().sendMessage(ChatColor.GOLD+"HAI FATTO LA CACCA");
            event.getPlayer().damage(0.5);
            event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(),new ItemStack(Material.BROWN_DYE,12));
        }
    }

}
