package io.github.pokechamp1.shootinggalleryevent;


import org.bukkit.plugin.java.JavaPlugin;
public final class ShootingGalleryEvent extends JavaPlugin 
{
    @Override
    public void onEnable() 
    { 
        this.getCommand("fb").setExecutor(new FireballLauncher());

        getServer().getPluginManager().registerEvents(new FireballLauncher(), this);
    }
    @Override
    public void onDisable() 
    {

    }      
}
