package com.aonoasgard.test.event;

import com.aonoasgard.test.PrimoPlugin;
import com.aonoasgard.test.event.join.JoinEventListener;
import com.aonoasgard.test.event.sleep.SleepEventListener;

public class EventsInitializer {
    public static void initialize(PrimoPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new JoinEventListener(),plugin);
        plugin.getServer().getPluginManager().registerEvents(new SleepEventListener(),plugin);
    }
}
