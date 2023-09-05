package org.zaksen.fancyhomes.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.zaksen.fancyhomes.gui.item.PassItem;

public class HomeMenu extends Menu {
    public HomeMenu() {
        super(54, "Homes");
        for (int i = 0; i < 9; i++) {
            addPassItem(new PassItem(i, new ItemStack(Material.LIME_STAINED_GLASS_PANE)));
        }
        for (int i = inventory.getSize() - 1; i > inventory.getSize() - 10; i--) {
            addPassItem(new PassItem(i, new ItemStack(Material.LIME_STAINED_GLASS_PANE)));
        }
    }

    public void fillByPlayer(Player player) {

    }
}
