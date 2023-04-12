package com.JeffDziad;

import com.JeffDziad.command.MapCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class JacxPlugin extends JavaPlugin {

    private FileConfiguration config = this.getConfig();

    @Override
    public void onDisable() {
        sendMessage("Disabled");
        super.onDisable();
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getCommand("map").setExecutor(new MapCommand(config));
        sendMessage("Enabled");
        super.onEnable();
    }

    public static void sendMessage(String message) {
        Bukkit.getConsoleSender().sendMessage("[Jacx Plugin] " + message);
    }

}
