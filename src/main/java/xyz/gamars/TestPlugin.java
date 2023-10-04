package xyz.gamars;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.gamars.commands.CircleCommand;
import xyz.gamars.commands.TestCommand;
import xyz.gamars.listeners.DamageEntityListener;
import xyz.gamars.listeners.PlayerListener;

public final class TestPlugin extends JavaPlugin {

    public void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("testcommand").setExecutor(new TestCommand());
        getCommand("circle").setExecutor(new CircleCommand());

        registerEvent(new PlayerListener());
        registerEvent(new DamageEntityListener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
