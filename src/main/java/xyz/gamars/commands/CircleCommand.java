package xyz.gamars.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CircleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            Location playerLoc =  player.getLocation();
            for (int degrees = 0; degrees < 360; degrees++) {
                double radians = Math.toRadians(degrees);
                double x = Math.cos(radians) * 10;
                double z = Math.sin(radians) * 10;

                Location loc = new Location(player.getWorld(), playerLoc.getX() + x, playerLoc.getY(), playerLoc.getZ() + z);
                player.getWorld().getBlockAt(loc).breakNaturally();

            }
            return true;
        }

        return false;
    }
}
