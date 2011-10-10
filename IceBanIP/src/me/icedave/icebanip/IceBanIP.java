package me.icedave.icebanip;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class IceBanIP extends JavaPlugin{
	
	private Logger log = Logger.getLogger("Minecraft");
	private IceBanIPCommandExecutor myExecutor;
	
	
	public void onEnable() {

		myExecutor = new IceBanIPCommandExecutor(this);
		
		getCommand("iceip").setExecutor(myExecutor);
		getCommand("iceban").setExecutor(myExecutor);
		getCommand("icebk").setExecutor(myExecutor);
		getCommand("icelist").setExecutor(myExecutor);
		
		this.logMessage("is enabled");

	}
	
	public void onDisable() {
		
		this.logMessage("is disabled");
		
	}

	protected void logMessage(String msg){
		
		PluginDescriptionFile pdFile = this.getDescription();
		this.log.info(pdFile.getAuthors() + "[" + pdFile.getName() + "] plugin Version [" + pdFile.getVersion() + "] : " + msg);
		
	}
}
