package org.zaksen.fancyhomes.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.zaksen.fancyhomes.gui.Menu;
import org.zaksen.fancyhomes.gui.MenuManager;
import org.zaksen.fancyhomes.gui.item.ClickableItem;
import org.zaksen.fancyhomes.gui.item.PassItem;

public class MenuEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Menu menu = MenuManager.getMenuBy(player);
        if(menu != null) {
            PassItem clickItem = menu.getClick(event.getSlot());
            if(clickItem != null) {
                if(clickItem instanceof ClickableItem) {
                    ((ClickableItem) clickItem).onClick(player, event.getClick());
                }
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onExit(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Menu menu = MenuManager.getMenuBy(player);
        if(menu != null) {
            menu.exit(player);
        }
    }
}