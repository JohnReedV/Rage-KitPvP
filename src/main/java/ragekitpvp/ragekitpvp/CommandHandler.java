package ragekitpvp.ragekitpvp;

import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import static org.bukkit.Bukkit.getServer;

public class  CommandHandler {
    Kits kits = new Kits();

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
        } else {sender.sendMessage("Can't use that"); }
        return true;
    }

    public boolean handleKits(CommandSender sender, Inventory inv) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("players only BOSS");
        }
        if (sender.hasPermission("kits.open")) {
            Player player = (Player) sender;
            player.openInventory(inv);
        } else {sender.sendMessage("Can't use that"); }
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
        } else {sender.sendMessage("Can't use that"); }
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
            Location loc = player.getLocation().clone();
            if (loc.getY() >= 175) { player.sendMessage("Can't use that up here"); return true;}
            player.setHealth(0.0);
            player.sendMessage("ya done now");
        } else sender.sendMessage("players only BOSS");
        return true;
    }

    public boolean handleIp(CommandSender sender, String[] args) {
        if (sender instanceof  Player && sender.hasPermission("kits.ip")) {
            if (args[0] == null) {
                sender.sendMessage("Provide the players name");
                return true;
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

    public boolean handleRandomKit(CommandSender sender) {
        if (sender instanceof Player && sender.hasPermission("kits.random")) {
            kits.getRandomKit(((Player) sender).getPlayer());
        }
        return true;
    }

    public Boolean resetStats(CommandSender sender, String[] args) {
        if (sender instanceof Player && sender.hasPermission("kits.resetstats")) {
            if (args.length == 0) {
                sender.sendMessage("Provide the players name");
                return true;
            }
            try {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                if (player != null) {
                    player.setStatistic(Statistic.PLAYER_KILLS, 0);
                    player.setStatistic(Statistic.DAMAGE_DEALT, 0);
                    player.setStatistic(Statistic.DAMAGE_TAKEN, 0);
                    player.setStatistic(Statistic.DEATHS, 0);
                    sender.sendMessage("Stats reset for " + player.getName());
                }
            }
            catch(Exception e) {
                sender.sendMessage("not a player. I got : "  + args[0]);
            }

        } else { sender.sendMessage("can't use that"); }
        return true;
    }

    public Boolean reloadStats(CommandSender sender) {
        if (sender.hasPermission("kits.reloadstats")) {
            StatisticsInventory statsInv = new StatisticsInventory();
            statsInv.getInv();
            sender.sendMessage("reloaded");
        } else {sender.sendMessage("Can't do that");}

        return true;
    }

    public Boolean spawn(CommandSender sender, String[] args) {
        if (sender.hasPermission("kits.spawn") && sender instanceof Player) {
            if (args.length == 0) {
                Player player = ((Player) sender).getPlayer();
                if (player != null) { player.teleport(player.getWorld().getSpawnLocation()); }
                return true;
            }
            try {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                if (player != null) {
                    player.teleport(player.getWorld().getSpawnLocation());
                    sender.sendMessage("sent  " + player.getName() + "to spawn");
                }
            }
            catch(Exception e) {
                sender.sendMessage("not a player. I got : "  + args[0]);
            }

        } else {sender.sendMessage("Can't do that");}
        return true;
    }
}
