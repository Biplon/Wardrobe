package me.LucFr.Wardrobe.DataManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.LucFr.Wardrobe.Main;

public class PlayerOldPermission {
	
	private Main plugin;
	private FileConfiguration dataConfig = null;
	private File configFile = null;
	
	public PlayerOldPermission(Main plugin) {
		this.plugin = plugin;
		saveDefaultConfig();
	}
	
	public void ReloadConfig() {
		if (this.configFile == null)
			this.configFile = new File(this.plugin.getDataFolder(), "Player Old Permission.yml");
		
		
		this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);
		
		InputStream defaultStream = this.plugin.getResource("Player Old Permission.yml");
		if (defaultStream != null) {
			YamlConfiguration defaultCongfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
			this.dataConfig.setDefaults(defaultCongfig);
		}
	}
	
	public FileConfiguration getConfig() {
		if (this.dataConfig == null)
			ReloadConfig();
		
		return this.dataConfig;
	}
	
	public void saveConfig() {
		if (this.dataConfig == null || this.configFile == null) 
			return;
		
		try {
			this.getConfig().save(this.configFile);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Could not save Data to " + this.configFile, e);
		}
	}
	// First Open
	public void saveDefaultConfig() {
		if (this.dataConfig == null)
			this.configFile = new File(this.plugin.getDataFolder(), "Player Old Permission.yml");
		
		if (!this.configFile.exists()) {
			this.plugin.saveResource("Player Old Permission.yml", false);
		}
	}
}
