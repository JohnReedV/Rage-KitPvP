package ragekitpvp.ragekitpvp;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;


public class StatisticsInventory {
    public Inventory inv;
    OfflinePlayer[] offlinePlayers = Bukkit.getOfflinePlayers();

    public void getInv() {
        long highestKills = 0;
        long highestDmg = 0;
        long highestDeaths = 0;
        OfflinePlayer killsPlayer = offlinePlayers[0];
        OfflinePlayer dmgPlayer = offlinePlayers[0];
        OfflinePlayer deathsPlayer = offlinePlayers[0];

        for (OfflinePlayer player : offlinePlayers) {
            if (player.getName().equalsIgnoreCase("spiigot") ||
                    player.getName().equalsIgnoreCase("peelion")) { continue; }
            long kills = player.getStatistic(Statistic.PLAYER_KILLS);
            long dmg = player.getStatistic(Statistic.DAMAGE_DEALT);
            long deaths = player.getStatistic(Statistic.DEATHS);
            if (kills > highestKills) {
                highestKills = kills;
                killsPlayer = player;
            }
            if (dmg > highestDmg) {
                highestDmg = dmg;
                dmgPlayer = player;
            }
            if (deaths > highestDeaths) {
                highestDeaths = deaths;
                deathsPlayer = player;
            }
        }

        inv = Bukkit.createInventory(null, 9, ChatColor.RED + "" + ChatColor.BOLD + "Statistics");

        inv.setItem(2, this.highestHead(killsPlayer, "KILLS"));
        inv.setItem(4, this.highestHead(dmgPlayer, "DAMAGE"));
        inv.setItem(6, this.highestHead(deathsPlayer, "DEATHS"));
    }

    public ItemStack highestHead(OfflinePlayer player, String most) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta)head.getItemMeta();
        meta.setOwner(player.getName());
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + player.getName() +
                ChatColor.RESET + ChatColor.GOLD + " has the most " + most );
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        double kd = ((double) player.getStatistic(Statistic.PLAYER_KILLS)) / ((double) player.getStatistic(Statistic.DEATHS));

        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GRAY + "KD Ratio : " + ChatColor.RESET + "" + ChatColor.ITALIC + kd);
        lore.add(ChatColor.GRAY + "Kills : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.PLAYER_KILLS));
        lore.add(ChatColor.GRAY + "Deaths : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.DEATHS));
        lore.add(ChatColor.GRAY + "Damage : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.DAMAGE_DEALT));
        lore.add(ChatColor.GRAY + "Damage Taken : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.DAMAGE_ABSORBED));
        lore.add(ChatColor.GRAY + "Total Server Time : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.TOTAL_WORLD_TIME));
        lore.add(ChatColor.GRAY + "Jumps : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.JUMP));
        lore.add(ChatColor.GRAY + "Sneak Time : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.SNEAK_TIME));
        meta.setLore(lore);
        head.setItemMeta(meta);

        return head;
    }
}
