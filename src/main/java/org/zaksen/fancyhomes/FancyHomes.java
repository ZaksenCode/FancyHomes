package org.zaksen.fancyhomes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.zaksen.fancyhomes.commands.HomeCMD;
import org.zaksen.fancyhomes.events.MenuEvents;

public final class FancyHomes extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MenuEvents(), this);
        // Plugin startup logic
        getCommand("home").setExecutor(new HomeCMD());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
