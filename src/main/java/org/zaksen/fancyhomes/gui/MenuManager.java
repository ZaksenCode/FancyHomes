package org.zaksen.fancyhomes.gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private static final MenuManager instance = new MenuManager();
    public final List<Menu> menus = new ArrayList<>();

    public static Menu getMenuBy(Player player) {
        for(Menu menu : getInstance().menus) {
            if(menu.viewers.contains(player)) {
                return menu;
            }
        }
        return null;
    }

    public static MenuManager getInstance() {
        return instance;
    }

    private MenuManager() { }

    public Menu createMenu(Menu menu) {
        menus.add(menu);
        return menu;
    }

    public Menu createMenu(int size, String name) {
        Menu menu = new Menu(size, name);
        menus.add(menu);
        return menu;
    }

    public void deleteMenu(Menu menu) {
        menu.stop();
        menus.remove(menu);
    }
}