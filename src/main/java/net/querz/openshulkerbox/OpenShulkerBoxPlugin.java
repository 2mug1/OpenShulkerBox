package net.querz.openshulkerbox;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;

public class OpenShulkerBoxPlugin extends JavaPlugin {
	private static OpenShulkerBoxPlugin instance;
	private boolean openWhileSneaking;
	private List<String> enabledPlayers;

	public void onEnable() {
		instance = this;
		this.getCommand("openshulkerbox").setExecutor(new OpenShulkerBoxCommand());
		Bukkit.getPluginManager().registerEvents(new OpenShulkerBoxListener(), this);
		loadConfig();
	}

	private void loadConfig() {
		saveDefaultConfig();
		openWhileSneaking = getConfig().getBoolean("open-while-sneaking", false);
		enabledPlayers = getConfig().getStringList("enabled-players");
	}

	public static OpenShulkerBoxPlugin getInstance() {
		return instance;
	}

	public boolean openWhileSneaking() {
		return openWhileSneaking;
	}

	public List<String> getEnabledPlayers() {
		return enabledPlayers;
	}
}

