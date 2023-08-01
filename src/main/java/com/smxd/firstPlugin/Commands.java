package com.smxd.firstPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Commands implements CommandExecutor {

    private static final Logger logger = Logger.getLogger("firstPlugin");

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length > 0) {
            switch (strings[0]) {
                case "gm":
                    gameMode(commandSender, command, s, strings);
                    break;
                case "open":
                    openInventory(commandSender, command, s, strings);
                    break;
            }
            return true;
        } else {
            openMenu(commandSender, command, s, strings);
            return true;
        }
    }

    /**
     * 切换模式
     *
     * @param commandSender
     * @param command
     * @param s
     * @param strings
     */
    public static void gameMode(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            //指令由玩家发送
            Player player = (Player) commandSender;
            if (strings.length == 2) {
                //指令长度正确
                if (strings[1].equals("1")) {
                    //切换创造模式
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(ChatColor.BLUE + "已切换到 " + ChatColor.GREEN + "创造模式");
                } else if (strings[1].equals("0")) {
                    //切换生存模式
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.BLUE + "已切换到 " + ChatColor.GREEN + "生存模式");
                } else {
                    //指令参数错误
                    player.sendMessage(ChatColor.RED + "指令错误");
                }
            } else {
                //长度错误
                player.sendMessage(ChatColor.RED + "指令错误");
            }
        } else {
            //指令不是玩家发出
            logger.info("这个指令只能由玩家使用");
        }


    }

    /**
     * 打开容器
     *
     * @param commandSender
     * @param command
     * @param s
     * @param strings
     */
    public static void openInventory(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            //指令由玩家发送
            Player player = (Player) commandSender;
            if (strings.length == 2) {
                //指令长度正确
                if (strings[1].equals("chest")) {
                    //打开箱子
                    player.openInventory(Bukkit.createInventory(null, 9, "随身箱子"));
                } else if (strings[1].equals("work")) {
                    //打开工作台
                    player.openInventory(Bukkit.createInventory(null, InventoryType.WORKBENCH, "随身工作台"));
                } else {
                    // 参数错误
                    player.sendMessage(ChatColor.RED + "指令错误");
                }
            } else {
                //长度错误
                player.sendMessage(ChatColor.RED + "指令错误");
            }
        } else {
            //指令不是玩家发出
            logger.info("这个指令只能由玩家使用");
        }
    }

    /**
     * 打开菜单
     *
     * @param commandSender
     * @param command
     * @param s
     * @param strings
     */
    public static void openMenu(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Inventory inventory = Bukkit.createInventory(null, 54, "菜单");
            ItemStack item = new ItemStack(Material.CLOCK);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<>();

            lore.add(ChatColor.BLUE+"签到获取奖励");
            lore.add("666");

            meta.setDisplayName("签到");
            meta.setLore(lore);
            item.setItemMeta(meta);
            inventory.addItem(item);
            player.openInventory(inventory);
        } else {
            logger.info("这个指令只能由玩家使用");
        }
    }


//end
}
