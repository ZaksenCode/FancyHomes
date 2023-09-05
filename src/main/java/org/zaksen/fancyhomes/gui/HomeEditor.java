package org.zaksen.fancyhomes.gui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.zaksen.fancyhomes.data.Home;
import org.zaksen.fancyhomes.gui.item.ClickableItem;
import org.zaksen.fancyhomes.gui.item.PassItem;

public class HomeEditor extends Menu {

    private final Home home;

    public HomeEditor(Menu parent, Home editing) {
        super(45, "Editing home");
        this.home = editing;
        for (int i = 0; i < inventory.getSize(); i++) {
            addPassItem(new PassItem(i, new ItemStack(Material.LIME_STAINED_GLASS_PANE)));
        }
        addPassItem(new ClickableItem(10, new ItemStack(Material.NAME_TAG)) {
            @Override
            public void onClick(Player player, ClickType clickType) {
                // TODO - name editing
            }
        });
        addPassItem(new ClickableItem(13, new ItemStack(Material.BEACON)) {
            @Override
            public void onClick(Player player, ClickType clickType) {
                editing.setHomeLocation(player.getLocation());
            }
        });
        addPassItem(new ClickableItem(16, new ItemStack(Material.NETHER_STAR)) {
            @Override
            public void onClick(Player player, ClickType clickType) {
                // TODO - icon editing
            }
        });
        addPassItem(new ClickableItem(31, new ItemStack(Material.LIME_CONCRETE)) {
            @Override
            public void onClick(Player player, ClickType clickType) {
                // TODO - add home logic
                exit(player);
            }
        });
    }
}