package ragekitpvp.ragekitpvp;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;


public class StatisticsInventory {
    public Inventory inv;
    OfflinePlayer[] offlinePlayers = Bukkit.getOfflinePlayers();

    enum Place {
        FIRST,
        SECOND,
        THIRD;
    }

    public void getInv() {
        List<OfflinePlayer> players = new ArrayList<>();
        HashMap<String, Double> kdMap = new HashMap<String, Double>();

        for (int i = 0; i < offlinePlayers.length; i++) {
            OfflinePlayer player =  offlinePlayers[i];

            if (player.getName().equalsIgnoreCase("spiigot") || player.getName().equalsIgnoreCase("peelion")
                    || player.getStatistic(Statistic.PLAYER_KILLS) < 20) { continue; }

            kdMap.put(player.getName(), ((double) player.getStatistic(Statistic.PLAYER_KILLS)) / ((double) player.getStatistic(Statistic.DEATHS)));

            players.add(player);
        }

        OfflinePlayer[][] kingList = {this.removeLeastKD(players, kdMap), this.removeLeast(players, Statistic.PLAYER_KILLS),
                this.removeLeast(players, Statistic.DAMAGE_DEALT), this.removeLeast(players, Statistic.DEATHS)};


        inv = Bukkit.createInventory(null, 27, ChatColor.DARK_BLUE + "" + ChatColor.MAGIC + "nske0" +
                ChatColor.RED + "" + ChatColor.BOLD + " Rage PvP" + ChatColor.GOLD + "" + ChatColor.BOLD + " Kings " +
                ChatColor.DARK_BLUE + "" + ChatColor.MAGIC + "nske0");

        inv.setItem(0, getPlace(Place.FIRST));
        inv.setItem(9, getPlace(Place.SECOND));
        inv.setItem(18, getPlace(Place.THIRD));

        int kdIndex = -7;
        int killerIndex = -5;
        int damageIndex = -3;
        int deathsIndex =  -1;
        for (int p = 0; p < kingList.length; p++) {
            for (int j = 0; j < kingList[p].length; j++) {
                OfflinePlayer player = kingList[p][j];

                if (p == 0) {
                    kdIndex += 9;
                    inv.setItem(kdIndex, this.highestHead(player, "KD"));
                }
                if (p == 1) {
                    killerIndex += 9;
                    inv.setItem(killerIndex, this.highestHead(player, "KILLS"));
                }
                if (p == 2) {
                    damageIndex += 9;
                    inv.setItem(damageIndex, this.highestHead(player, "DAMAGE"));
                }
                if (p == 3) {
                    deathsIndex += 9;
                    inv.setItem(deathsIndex, this.highestHead(player, "DEATHS"));
                }
            }
        }
    }

    public ItemStack getPlace(Place type) {
        ItemStack item = new ItemStack(Material.FIRE);
        if (type == Place.FIRST) {
            item = new ItemStack(Material.DIAMOND);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "FIRST PLACE");
            meta.addEnchant(Enchantment.LURE, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }
        else if (type == Place.SECOND) {
            item = new ItemStack(Material.GOLD_INGOT);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "SECOND PLACE");
            meta.addEnchant(Enchantment.LURE, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }
        else if (type == Place.THIRD) {
            item = new ItemStack(Material.IRON_INGOT);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "THIRD PLACE");
            meta.addEnchant(Enchantment.LURE, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            item.setItemMeta(meta);
        }
        return item;
    }

    public ItemStack highestHead(OfflinePlayer player, String type) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta)head.getItemMeta();
        meta.setOwner(player.getName());
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + player.getName() + "'s " + ChatColor.RESET + ChatColor.GOLD+""+ChatColor.BOLD+ type);
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
        lore.add(ChatColor.GRAY + "Damage Taken : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.DAMAGE_TAKEN));
        lore.add(ChatColor.GRAY + "Total Server Time : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.TOTAL_WORLD_TIME));
        lore.add(ChatColor.GRAY + "Jumps : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.JUMP));
        lore.add(ChatColor.GRAY + "Sneak Time : " + ChatColor.RESET + "" + ChatColor.ITALIC + player.getStatistic(Statistic.SNEAK_TIME));
        meta.setLore(lore);
        head.setItemMeta(meta);

        return head;
    }

    public OfflinePlayer[] removeLeast(List<OfflinePlayer> players, Statistic type) {
        players.sort((p1, p2) -> Integer.compare(Bukkit.getOfflinePlayer(p1.getUniqueId()).getStatistic(type),
                Bukkit.getOfflinePlayer(p2.getUniqueId()).getStatistic(type)));
        Collections.reverse(players);
        OfflinePlayer[] ar = {players.get(0), players.get(1), players.get(2)};
        return ar;
    }

    public OfflinePlayer[] removeLeastKD(List<OfflinePlayer> players, HashMap<String, Double> kdMap) {
        players.sort((p1, p2) -> kdMap.get(p1.getName()).compareTo(kdMap.get(p2.getName())));
        Collections.reverse(players);
        OfflinePlayer[] ar = {players.get(0), players.get(1), players.get(2)};
        return ar;
    }
}
