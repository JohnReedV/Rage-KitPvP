package ragekitpvp.ragekitpvp;

import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import static org.bukkit.Bukkit.getServer;

public class CommandHandler {

    public boolean handleHead(CommandSender sender, String[] args) {
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
        return true;
    }

    public boolean handleKits(CommandSender sender, Inventory inv) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("players only BOSS");
        }
        if (sender.hasPermission("kits.open")) {
            Player player = (Player) sender;
            player.openInventory(inv);
        }
        return true;
    }

    public boolean handleSetspawn(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("players only BOSS");
        }
        if (sender.hasPermission("kits.setspawn")){
            Player player = (Player) sender;
            World world = player.getWorld();
            Location loc = player.getLocation();
            world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
        }
        return true;
    }

    public boolean handleFlex(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("players only BOSS");
        } else {
            Player player = (Player) sender;
            Integer kills = player.getStatistic(Statistic.PLAYER_KILLS);
            Integer deaths = player.getStatistic(Statistic.DEATHS);
            Integer dmgDone = player.getStatistic(Statistic.DAMAGE_DEALT);
            Integer dmgTaken = player.getStatistic(Statistic.DAMAGE_TAKEN);
            Integer time = player.getStatistic(Statistic.TOTAL_WORLD_TIME);

            getServer().dispatchCommand(getServer().getConsoleSender(), "say Here are "
                    + player.getName() + "'s stats...");

            getServer().dispatchCommand(getServer().getConsoleSender(),"say Died : " + deaths.toString());
            getServer().dispatchCommand(getServer().getConsoleSender(),"say Killed : " + kills.toString());
            getServer().dispatchCommand(getServer().getConsoleSender(),"say Damage done : " + dmgDone.toString());
            getServer().dispatchCommand(getServer().getConsoleSender(),"say Damage Taken : " + dmgTaken.toString());
            getServer().dispatchCommand(getServer().getConsoleSender(),"Time on server : " + time.toString());
        }
        return true;
    }

    public boolean handlePing(CommandSender sender) {
        if (sender instanceof  Player){
            Player player = (Player) sender;
            player.sendMessage(("Your ping is " + player.getPing()));
        } else sender.sendMessage("players only king");
        return true;
    }
    public boolean handleDie(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.setHealth(0.0);
            player.sendMessage("ya done now");
        } else sender.sendMessage("players only king");
        return true;
    }

    public boolean handleIp(CommandSender sender, String[] args) {
        if (sender instanceof  Player && sender.hasPermission("kits.ip")) {
            if (args[0] == null) {
                sender.sendMessage("Provide the players name");
            }
            try {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                sender.sendMessage(player.getName() + "'s ping is : " + player.getAddress());
            }
            catch(Exception e) {
                sender.sendMessage("not a player. I got : "  + args[0]);
            }
        } else sender.sendMessage("can't use that king");
        return true;
    }
}
