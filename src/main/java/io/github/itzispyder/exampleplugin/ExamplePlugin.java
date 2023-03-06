/**
 * This file is for tutorial purposes made by ImproperIssues. Distribute if you want :)
 */

package io.github.itzispyder.exampleplugin;

import io.github.itzispyder.exampleplugin.commands.CommandExample;
import io.github.itzispyder.exampleplugin.data.Config;
import io.github.itzispyder.exampleplugin.events.ExampleEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * This is your main class, you register everything important here.
 *
 * To build the jar, go to terminal and run "./gradlew build"
 */
public final class ExamplePlugin extends JavaPlugin {

    public static final PluginManager manager = Bukkit.getPluginManager();
    public static String starter = "";
    public static final Logger log = Bukkit.getLogger();

    /**
     * Plugin startup logic
     */
    @Override
    public void onEnable() {

        // Files
        getConfig().options().copyDefaults();
        saveDefaultConfig(); 

        // Plugin startup logic
        log.info("Example plugin has loaded! (" + getDescription().getVersion() + ")");
        starter = Config.Plugin.getPrefix() + " ";

        // Commands -> BE SURE TO REGISTER ANY NEW COMMANDS IN PLUGIN.YML (src/main/java/resources/plugin.yml)!
        getCommand("example").setExecutor(new CommandExample());
        getCommand("example").setTabCompleter(new CommandExample.Tabs());

        // Events
        manager.registerEvents(new ExampleEvent(),this);

    }

    /**
     * Plugin shutdown logic
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log.info("Example plugin has disabled! (" + getDescription().getVersion() + ")");
    }

    /**
     * Returns an instance of this plugin
     * @return an instance of this plugin
     */
    public static Plugin getInstance() {
        return manager.getPlugin("ExamplePlugin");
    }
}
