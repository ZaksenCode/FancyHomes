package org.zaksen.fancyhomes.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.zaksen.fancyhomes.data.Home;
import org.zaksen.fancyhomes.data.HomeManager;
import org.zaksen.fancyhomes.gui.HomeEditor;
import org.zaksen.fancyhomes.gui.HomeMenu;
import org.zaksen.fancyhomes.gui.Menu;
import org.zaksen.fancyhomes.gui.MenuManager;
import org.zaksen.fancyhomes.gui.item.ClickableItem;

import java.util.List;

public class HomeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Menu newHomeMenu = MenuManager.getInstance().createMenu(new HomeMenu());
            List<Home> homes = HomeManager.getInstance().getHomesFor(player);
            int i = 9;
            if(homes != null) {
                for (Home home : homes) {
                    newHomeMenu.addPassItem(new ClickableItem(i, home.getAsStack()) {
                        @Override
                        public void onClick(Player player, ClickType clickType) {
                            if (clickType.isLeftClick()) {
                                home.teleport(player);
                            } else if (clickType.isRightClick()) {
                                Menu creatorMenu = MenuManager.getInstance().createMenu(new HomeEditor(newHomeMenu, home));
                                creatorMenu.open(player);
                            }
                        }
                    });
                    i++;
                }
            }
            newHomeMenu.addPassItem(new ClickableItem(i, new ItemStack(Material.NAME_TAG)) {
                @Override
                public void onClick(Player player, ClickType clickType) {
                    HomeManager.getInstance().createHomeFor(player, new Home("home", player, Material.GRASS_BLOCK, player.getLocation()));
                    newHomeMenu.exit(player);
                }
            });
            newHomeMenu.open(player);
        }
        return true;
    }
}