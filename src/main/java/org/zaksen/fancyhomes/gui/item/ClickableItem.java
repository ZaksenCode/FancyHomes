package org.zaksen.fancyhomes.gui.item;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class ClickableItem extends PassItem {
    public ClickableItem(int slot, ItemStack stack) {
        super(slot, stack);
    }

    public void onClick(Player player, ClickType clickType) {

    }
}