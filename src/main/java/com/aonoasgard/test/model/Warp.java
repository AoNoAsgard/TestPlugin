package com.aonoasgard.test.model;

import org.bukkit.Location;
import org.json.simple.JSONObject;

public class Warp {
    private int id;
    private String nome;
    private Location loc;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public Location getLoc() {
        return loc;
    }
}

