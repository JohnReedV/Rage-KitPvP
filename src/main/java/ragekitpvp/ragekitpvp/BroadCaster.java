package ragekitpvp.ragekitpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class BroadCaster {

    public void broadCast() {
        String[] possibilities = {"Discord", "ip", "vip"};
        String selection = possibilities[(int) Math.round(((Math.random() * (possibilities.length - 1)) + 0))];
        String prefix = ChatColor.RED + "" + ChatColor.BOLD + "Rage " + ChatColor.RESET + "" + ChatColor.GRAY + "" + "> ";

        if (selection.equalsIgnoreCase("ip")) {
            Bukkit.broadcastMessage(prefix + ChatColor.GOLD + "" + ChatColor.BOLD +
                    "Connect using our new IP : " + ChatColor.RED + "" + ChatColor.BOLD + "ragepvp.co");
            Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "All other IPs will be disabled soon");
        }
        if (selection.equalsIgnoreCase("discord")) { Bukkit.broadcastMessage(prefix +
                ChatColor.GOLD + "" + ChatColor.BOLD + "Join the server discord : " +
                        ChatColor.RED + "" + ChatColor.BOLD + "https://discord.gg/fZgBkgCzGb");
        }
        if (selection.equalsIgnoreCase("vip")) { Bukkit.broadcastMessage(prefix +
                ChatColor.GOLD + "" + ChatColor.BOLD + "All VIP kits are FREE until a sufficient player base is established");
        }

    }
}
