package io.github.pokechamp1.shootinggalleryevent;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FireballLauncher implements Listener, CommandExecutor
{

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {

            Player player = (Player) sender;
            ItemStack fb = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta fbmeta = fb.getItemMeta();
            fbmeta.setDisplayName(ChatColor.YELLOW + "Fireball Launcher");
            fb.setItemMeta(fbmeta);
            player.getInventory().addItem(fb);

        }
        return true;
    }
    @EventHandler
    public void onRightClick ( PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
        {
            ItemStack item = p.getInventory().getItemInHand();
            if (item.getType() == Material.DIAMOND_HOE)
            {
                if(item.hasItemMeta() &&
                        item.getItemMeta().hasDisplayName() &&
                        item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Fireball Launcher"))
                {
                    p.getEyeLocation().multiply(2).spawn(Fireball.class)
                    p.sendMessage(ChatColor.AQUA + "Ability Used!");
                }
            }
        }
    }
}
