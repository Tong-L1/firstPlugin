package com.smxd.firstPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin implements org.bukkit.event.Listener {

    private final Logger logger = this.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info("Plugin loaded");
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        Bukkit.getPluginCommand("firstPlugin").setExecutor(new Commands());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("Plugin Stoped");
    }
}
