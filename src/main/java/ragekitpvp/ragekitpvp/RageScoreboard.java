package ragekitpvp.ragekitpvp;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.scoreboard.*;

public class RageScoreboard {

    public void createBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("Rage", "dummy",
                ChatColor.BOLD + "" + ChatColor.RED + "RAGE PVP");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score kills = obj.getScore(ChatColor.AQUA + "Kills: " + ChatColor.GREEN +
                player.getStatistic(Statistic.PLAYER_KILLS));
        kills.setScore(0);
        Score deaths = obj.getScore(ChatColor.AQUA + "Deaths: " + ChatColor.GREEN +
                player.getStatistic(Statistic.DEATHS));
        deaths.setScore(0);
        Score dmg = obj.getScore(ChatColor.AQUA + "Damage Dealt: " + ChatColor.GREEN +
                player.getStatistic(Statistic.DAMAGE_DEALT));
        dmg.setScore(0);
        Score dmgt = obj.getScore(ChatColor.AQUA + "Damage Taken: " + ChatColor.GREEN +
                player.getStatistic(Statistic.DAMAGE_TAKEN));
        dmgt.setScore(0);
        player.setScoreboard(board);
    }
}
