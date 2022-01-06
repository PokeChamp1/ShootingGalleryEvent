package io.github.pokechamp1.shootinggalleryevent;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class TargetIdentify implements Listener
 {

	@EventHandler
    public void ProjectileHit(ProjectileHitEvent e)
    {
        Player p = (Player) e.getEntity().getShooter();
        p.sendMessage(e.getEntity().getLocation().getBlock().getType().toString());
    }
}

