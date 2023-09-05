package org.zaksen.fancyhomes.gui.item;

import org.bukkit.inventory.ItemStack;

public class PassItem {
    protected final ItemStack stack;
    protected final int slot;

    public PassItem(int slot, ItemStack stack) {
        this.slot = slot;
        this.stack = stack;
    }

    public ItemStack getStack() {
        return stack;
    }

    public int getSlot() {
        return slot;
    }
}