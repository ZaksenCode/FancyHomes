package org.zaksen.fancyhomes.data;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private Material icon;
    private String name;
    private Player owner;
    private List<Player> allowed = new ArrayList<>();
    private Location homeLocation;

    public Home(String name, Player owner, Material icon, Location location) {
        this.name = name;
        this.owner = owner;
        this.icon = icon;
        this.homeLocation = location;
        HomeManager.getInstance().createHomeFor(owner, this);
    }

    public ItemStack getAsStack() {
        ItemStack stackIcon = new ItemStack(icon);
        ItemMeta stackIconMeta = stackIcon.getItemMeta();
        stackIconMeta.setDisplayName(getName());
        stackIcon.setItemMeta(stackIconMeta);
        return stackIcon;
    }

    public void teleport(Player player) {
        player.teleport(homeLocation);
    }

    public Material getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public Player getOwner() {
        return owner;
    }

    public List<Player> getAllowed() {
        return allowed;
    }

    public Location getHomeLocation() {
        return homeLocation;
    }

    public void setIcon(Material icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setAllowed(List<Player> allowed) {
        this.allowed = allowed;
    }

    public void setHomeLocation(Location homeLocation) {
        this.homeLocation = homeLocation;
    }
}