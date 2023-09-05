package org.zaksen.fancyhomes.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.zaksen.fancyhomes.gui.item.ClickableItem;
import org.zaksen.fancyhomes.gui.item.PassItem;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    protected final List<Player> viewers = new ArrayList<>();
    protected final List<PassItem> passItems = new ArrayList<>();
    protected final Inventory inventory;

    public List<ClickableItem> getClickableItems() {
        List<ClickableItem> items = new ArrayList<>();
        for(PassItem item : passItems) {
            if(item instanceof ClickableItem) {
                items.add((ClickableItem) item);
            }
        }
        return items;
    }

    public Menu(int size, String title) {
        inventory = Bukkit.createInventory(null, size, title);
    }

    public void addPassItem(PassItem item) {
        inventory.setItem(item.getSlot(), item.getStack());
        passItems.add(item);
    }

    public PassItem getClick(int slot) {
        for(PassItem item : passItems) {
            if(item.getSlot() == slot) {
                return item;
            }
        }
        return null;
    }

    public void open(Player player) {
        player.openInventory(inventory);
        viewers.add(player);
    }

    public void exit(Player player) {
        player.closeInventory();
        viewers.remove(player);
        if(viewers.size() < 1) {
            MenuManager.getInstance().deleteMenu(this);
        }
    }

    public void stop() {
        for(Player player : viewers) {
            exit(player);
        }
    }
}