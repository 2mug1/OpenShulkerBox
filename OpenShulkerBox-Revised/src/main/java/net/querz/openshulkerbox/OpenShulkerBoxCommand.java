package net.querz.openshulkerbox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import java.util.Arrays;

public class OpenShulkerBoxCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String uuid = player.getUniqueId().toString();
            if (OpenShulkerBoxPlugin.getInstance().getEnabledPlayers().contains(uuid)) {
                OpenShulkerBoxPlugin.getInstance().getEnabledPlayers().remove(uuid);
            } else {
                OpenShulkerBoxPlugin.getInstance().getEnabledPlayers().add(uuid);
            }
            player.sendMessage("OpenShulkerBox: " + (OpenShulkerBoxPlugin.getInstance().getEnabledPlayers().contains(uuid) ? ChatColor.GREEN + "ON" : ChatColor.RED + "OFF"));
            OpenShulkerBoxPlugin.getInstance().getConfig().set("enabled-players", OpenShulkerBoxPlugin.getInstance().getEnabledPlayers());
            OpenShulkerBoxPlugin.getInstance().saveConfig();
            return true;
        }
        return false;
    }
}
