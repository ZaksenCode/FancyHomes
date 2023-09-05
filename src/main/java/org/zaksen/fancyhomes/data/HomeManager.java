package org.zaksen.fancyhomes.data;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeManager {
    private static final HomeManager instance = new HomeManager();
    private static final HashMap<Player, List<Home>> playersHomes = new HashMap<>();

    private HomeManager() { }

    public static HomeManager getInstance() {
        return instance;
    }

    public List<Home> getHomesFor(Player player) {
        return playersHomes.get(player);
    }

    public Home createHomeFor(Player player, Home home) {
        List<Home> homes = playersHomes.get(player);
        if(homes == null) {
            homes = new ArrayList<>();
        }
        homes.add(home);
        playersHomes.remove(player);
        playersHomes.put(player, homes);
        return home;
    }

}