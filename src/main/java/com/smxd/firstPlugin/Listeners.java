package com.smxd.firstPlugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Listeners implements org.bukkit.event.Listener {

    /*
    玩家加入
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(event.getPlayer().getName() + "进入了服务，哇哦~");
        event.getPlayer().sendMessage(ChatColor.GREEN + "欢迎你, " + event.getPlayer().getName() + "!");
    }

    /*
    签到
     */
    @EventHandler
    public void onSignIn(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("菜单")) {
            event.setCancelled(true);//不可拿取
            if (event.getRawSlot() == 0) {
                ItemStack item = new ItemStack(Material.DIAMOND, 1);
                event.getWhoClicked().getInventory().addItem(item);
            }
        }
    }

}
