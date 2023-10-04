package xyz.gamars.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = ((Player) sender).getPlayer();
        if (player.getMainHand().equals(null)) {
            ItemStack mainHand = player.getInventory().getItemInMainHand();
            ItemMeta meta = mainHand.getItemMeta();
            meta.setDisplayName("Piercer");

            mainHand.setItemMeta(meta);
            return true;
        }

        return false;
    }

}
