package xyz.gamars.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class DamageEntityListener implements Listener {

    @EventHandler
    public void onDamageEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {

            if (((LivingEntity) event.getDamager()).getEquipment().getItemInMainHand().getItemMeta().getDisplayName().equals(null)) {
                return;
            }

            Player player = ((Player) event.getDamager()).getPlayer();
            LivingEntity damagedEntity = (LivingEntity) event.getEntity();
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Piercer")) {
                System.out.println("Pre-damage changes : (Health: " + damagedEntity.getHealth() + ")");
                System.out.println("Damage: " + event.getDamage());
                System.out.println("Final Damage: " + event.getFinalDamage());
                System.out.println("Health: " + damagedEntity.getHealth());

                if ((damagedEntity.getHealth() - event.getDamage()) > 0) {
                    damagedEntity.setHealth(damagedEntity.getHealth() - event.getDamage());
                } else if ((damagedEntity.getHealth() - event.getDamage()) <= 0) {
                    damagedEntity.setHealth(0);
                }

                event.setDamage(0);
                System.out.println(damagedEntity.getHealth());
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("Armorer")) {
                damagedEntity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                damagedEntity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                damagedEntity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                damagedEntity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                System.out.println("Armored Entity");
                event.setDamage(0);
            }
        }



    }

}
