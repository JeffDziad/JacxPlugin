package com.JeffDziad.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.net.URL;

public class MapCommand implements CommandExecutor {

    private FileConfiguration config;

    public MapCommand(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            // Player is sending command.
            Player player = (Player) commandSender;
            String url = config.getString("blueMapUrl");
            if(url != null && isValid(url)) {
                player.sendMessage("Sending player map url...");
                sendLink(player, "Click here to open the map...", url);
            }
        }
        return true;
    }

    private void sendLink(Player player, String message, String url) {
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "/tellraw " + player.getName() + " {text:\"" + message + "\",clickEvent:{action:open_url,value:\"" + url + "\"}}");
    }

    private static boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
