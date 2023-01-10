package ragekitpvp.ragekitpvp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        kitInv inventory = new kitInv();
        inventory.createInv();
        if (label.equalsIgnoreCase("head")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("players only BOSS");
            }
            if (sender.hasPermission("kits.head")) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                    SkullMeta meta = (SkullMeta) head.getItemMeta();
                    meta.setOwner(player.getDisplayName());
                    meta.setDisplayName(ChatColor.GREEN + player.getDisplayName() + "s" + ChatColor.AQUA + " head");
                    head.setItemMeta(meta);
                    player.getInventory().addItem(head);
                    return true;
                }
                if (args.length > 0) {
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (args[0].equalsIgnoreCase(online.getDisplayName())) {
                            ItemStack head = new ItemStack(Material.PLAYER_HEAD);
                            SkullMeta meta = (SkullMeta) head.getItemMeta();
                            meta.setOwner(online.getDisplayName());
                            meta.setDisplayName(ChatColor.GREEN + online.getDisplayName() + "s" + ChatColor.AQUA + " head");
                            head.setItemMeta(meta);
                            player.getInventory().addItem(head);
                            return true;
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.GOLD + "Player not online");
                }
            }
        }
        if (label.equalsIgnoreCase("kits")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("players only BOSS");
            }
            if (sender.hasPermission("kits.open")) {
                Player player = (Player) sender;
                player.openInventory(inventory.inv);
            }
        }

        if (label.equalsIgnoreCase("setspawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("players only BOSS");
            }
            if (sender.hasPermission("kits.setspawn")){
                Player player = (Player) sender;
                World world = player.getWorld();
                Location loc = player.getLocation();
                world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
            }
        }

//        if (label.equalsIgnoreCase("flex")) {
//            if (!(sender instanceof Player)) {
//                sender.sendMessage("players only BOSS");
//            } else {
//                Player player = (Player) sender;
//                Integer kills = player.getStatistic(Statistic.PLAYER_KILLS);
//                Integer deaths = player.getStatistic(Statistic.DEATHS);
//                Integer dmgDone = player.getStatistic(Statistic.DAMAGE_DEALT);
//                Integer dmgTaken = player.getStatistic(Statistic.DAMAGE_TAKEN);
//                Integer time = player.getStatistic(Statistic.TOTAL_WORLD_TIME);
//
//                getServer().dispatchCommand(getServer().getConsoleSender(), "say Here are "
//                        + player.getName() + "'s stats...");
//
//                getServer().dispatchCommand(getServer().getConsoleSender(),"say Died : " + deaths.toString());
//                getServer().dispatchCommand(getServer().getConsoleSender(),"say Killed : " + kills.toString());
//                getServer().dispatchCommand(getServer().getConsoleSender(),"say Damage done : " + dmgDone.toString());
//                getServer().dispatchCommand(getServer().getConsoleSender(),"say Damage Taken : " + dmgTaken.toString());
//                getServer().dispatchCommand(getServer().getConsoleSender(),"Time on server : " + time.toString());
//            }
//
//        }

        return true;
    }
    
}
