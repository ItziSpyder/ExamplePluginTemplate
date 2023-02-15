/**
 * This file is for tutorial purposes made by ImproperIssues. Distribute if you want :)
 */

package io.github.itzispyder.exampleplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * An example event listener
 */
public class ExampleEvent implements Listener {

    /**
     * Listens for join event, set any event you want in the parameter type!
     * Provided by Bukkit API
     * @param e the event to listen for
     */
    @EventHandler
    public static void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("Hello, welcome!");
    }
}
