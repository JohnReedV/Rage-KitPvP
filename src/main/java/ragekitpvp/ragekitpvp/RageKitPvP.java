package ragekitpvp.ragekitpvp;

import org.bukkit.Color;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.*;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.*;
import java.util.List;

public class RageKitPvP extends JavaPlugin implements Listener {
    Map<String, Long> cooldowns = new HashMap<String, Long>();

    public Inventory inv;

    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(this, this);
        createInv();
        System.out.println("GUI in");
    }
    @Override
    public void onDisable(){
        System.out.println("GUI out");
    }
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
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
                player.openInventory(inv);
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

        return true;
    }
    public void createInv() {
        inv = Bukkit.createInventory(null, 18, ChatColor.BOLD + "" + ChatColor.GOLD + "Kit Selector");
        ItemStack book1 = new ItemStack(Material.BOOK);
        ItemMeta meta7 = book1.getItemMeta();
        meta7.setDisplayName(ChatColor.GOLD + "Default Kits");
        List<String> lore7 = new ArrayList<String>();
        lore7.add("");
        lore7.add(ChatColor.RED + "---->");
        meta7.setLore(lore7);
        meta7.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        book1.setItemMeta(meta7);
        inv.setItem(0,book1);

        ItemStack book2 = new ItemStack(Material.BOOK);
        ItemMeta meta8 = book1.getItemMeta();
        meta8.setDisplayName(ChatColor.GOLD + "VIP Kits");
        List<String> lore8 = new ArrayList<String>();
        lore8.add("");
        lore8.add(ChatColor.RED + "---->");
        meta8.setLore(lore8);
        meta8.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        book2.setItemMeta(meta8);
        inv.setItem(9,book2);

        ItemStack chem = new ItemStack(Material.BREWING_STAND);
        ItemMeta meta6 = chem.getItemMeta();
        meta6.setDisplayName(ChatColor.DARK_GREEN + "Chemist");
        List<String> lore6 = new ArrayList<String>();
        lore6.add(ChatColor.ITALIC + "" + ChatColor.LIGHT_PURPLE + "hehehehe you a special kinda dude");
        meta6.setLore(lore6);
        meta6.addEnchant(Enchantment.LURE, 1, true);
        meta6.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta6.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chem.setItemMeta(meta6);
        inv.setItem(1, chem);

        ItemStack doom = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta1 = doom.getItemMeta();
        meta1.setDisplayName(ChatColor.DARK_RED + "DOOM");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Fly and wreak " + ChatColor.DARK_RED + ChatColor.BOLD + "DOOM" + ChatColor.RESET
                + ChatColor.GRAY + " if you dare!");
        meta1.setLore(lore);
        meta1.addEnchant(Enchantment.LURE, 1, true);
        meta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        doom.setItemMeta(meta1);
        inv.setItem(2, doom);

        ItemStack knight = new ItemStack(Material.IRON_HELMET);
        ItemMeta meta2 = knight.getItemMeta();
        meta2.setDisplayName(ChatColor.BLUE + "Knight");
        List<String> lore2 = new ArrayList<String>();
        lore2.add(ChatColor.ITALIC + "" + ChatColor.BLUE + "For Honor, for Glory!");
        meta2.setLore(lore2);
        meta2.addEnchant(Enchantment.LURE, 1, true);
        meta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        knight.setItemMeta(meta2);
        inv.setItem(3, knight);

        ItemStack archer = new ItemStack(Material.BOW);
        ItemMeta meta3 = archer.getItemMeta();
        meta3.setDisplayName(ChatColor.DARK_GREEN + "Archer");
        List<String> lore3 = new ArrayList<String>();
        lore3.add(ChatColor.ITALIC + "" + ChatColor.DARK_GREEN + "bow time");
        meta3.setLore(lore3);
        meta3.addEnchant(Enchantment.LURE, 1,true);
        meta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        archer.setItemMeta(meta3);
        inv.setItem(4, archer);

        ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
        ItemMeta meta4 = pyro.getItemMeta();
        meta4.setDisplayName(ChatColor.DARK_RED + "Pyro");
        List<String> lore4 = new ArrayList<String>();
        lore4.add(ChatColor.ITALIC + "" + ChatColor.RED + "Set your enemies" + ChatColor.BOLD + " ABLAZE");
        meta4.setLore(lore4);
        meta4.addEnchant(Enchantment.LURE,1,true);
        meta4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        pyro.setItemMeta(meta4);
        inv.setItem(5, pyro);

        ItemStack nin = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta meta5 = nin.getItemMeta();
        meta5.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Ninja");
        List<String> lore5 = new ArrayList<String>();
        lore5.add(ChatColor.ITALIC + "" + ChatColor.AQUA + "sneak upon them");
        meta5.setLore(lore5);
        meta5.addEnchant(Enchantment.LURE,1,true);
        meta5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta5.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        nin.setItemMeta(meta5);
        inv.setItem(6, nin);

        ItemStack horse = new ItemStack(Material.SADDLE);
        ItemMeta meta9 = horse.getItemMeta();
        meta9.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Jockey");
        List<String> lore9 = new ArrayList<String>();
        lore9.add(ChatColor.ITALIC + "" + ChatColor.AQUA + "horsey go NEIGH");
        meta9.setLore(lore9);
        meta9.addEnchant(Enchantment.LURE,1,true);
        meta9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta9.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        horse.setItemMeta(meta9);
        inv.setItem(10, horse);

        ItemStack tank = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta meta10 = tank.getItemMeta();
        meta10.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "TANK");
        List<String> lore10 = new ArrayList<String>();
        lore10.add(ChatColor.ITALIC + "" + ChatColor.GRAY + "ur pretty tough");
        meta10.setLore(lore10);
        meta10.addEnchant(Enchantment.LURE,1,true);
        meta10.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta10.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        tank.setItemMeta(meta10);
        inv.setItem(7, tank);

        ItemStack ender = new ItemStack(Material.ENDER_PEARL);
        ItemMeta meta11 = ender.getItemMeta();
        meta11.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Ender");
        List<String> lore11 = new ArrayList<String>();
        lore11.add(ChatColor.ITALIC + "" + ChatColor.AQUA + "enderman = BOSS");
        meta11.setLore(lore11);
        meta11.addEnchant(Enchantment.LURE,1,true);
        meta11.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta11.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ender.setItemMeta(meta11);
        inv.setItem(11, ender);

        ItemStack cactus = new ItemStack(Material.CACTUS);
        ItemMeta meta12 = cactus.getItemMeta();
        meta12.setDisplayName(ChatColor.RED + "Cactus");
        List<String> lore12 = new ArrayList<String>();
        lore12.add(ChatColor.ITALIC + "" + ChatColor.GRAY + "poke them!");
        meta12.setLore(lore12);
        meta12.addEnchant(Enchantment.LURE,1,true);
        meta12.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta12.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        cactus.setItemMeta(meta12);
        inv.setItem(12, cactus);

        ItemStack ak = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta meta13 = ak.getItemMeta();
        meta13.setDisplayName(ChatColor.DARK_RED + "TERRORIST");
        List<String> lore13 = new ArrayList<String>();
        lore13.add(ChatColor.ITALIC + "" + ChatColor.GRAY + "The Khalefeid has declared an eternal Jihad!");
        lore13.add(ChatColor.ITALIC + "" + ChatColor.GRAY + "The hordes of the west are no match for the");
        lore13.add(ChatColor.ITALIC + "" + ChatColor.GRAY + "Unstoppable wave of Islam, lets go my brothers!");
        meta13.setLore(lore13);
        meta13.addEnchant(Enchantment.LURE,1,true);
        meta13.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta13.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ak.setItemMeta(meta13);
        inv.setItem(16, ak);

        ItemStack outcast = new ItemStack(Material.WITHER_ROSE);
        ItemMeta meta14 = outcast.getItemMeta();
        meta14.setDisplayName(ChatColor.DARK_GRAY + "Outcast");
        List<String> lore14 = new ArrayList<String>();
        lore14.add(ChatColor.ITALIC + "" + ChatColor.RED + "outcast?? haha loser");
        meta14.setLore(lore14);
        meta14.addEnchant(Enchantment.LURE,1,true);
        meta14.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta14.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        outcast.setItemMeta(meta14);
        inv.setItem(8, outcast);
    }

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
    public ItemStack getDoom() {
        ItemStack doom = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = doom.getItemMeta();
        meta.setDisplayName(ChatColor.BLACK + "Sword O' Doom");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_RED + "+10 dmg dealt against pregnant women");
        lore.add("");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        doom.setItemMeta(meta);

        return doom;
    }
    public ItemStack doomStick() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.setDisplayName(ChatColor.BLACK + "Stick O' Doom");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_RED + "play with magic stick >:)");
        lore.add("");
        lore.add(ChatColor.DARK_PURPLE + "recharging skelly spawns take 25 seconds");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        stick.setItemMeta(meta);

        return stick;
    }
    public ItemStack doomBoots() {
        ItemStack gboots = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta meta = gboots.getItemMeta();
        meta.setDisplayName(ChatColor.BLACK + "Boots O' Doom");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_RED + "Boots for DOOM purposes");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        gboots.setItemMeta(meta);

        return gboots;
    }
    public ItemStack knightBoots() {
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Feet of the Knight");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack knightLegs() {
        ItemStack boots = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Legs of the Knight");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack knightChest() {
        ItemStack boots = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Chest of the Knight");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack knightHead() {
        ItemStack boots = new ItemStack(Material.IRON_HELMET);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Head of the Knight");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack knightSword(){
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = sword.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Sword of the Knight");
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        sword.setItemMeta(meta);

        return sword;
    }
    public ItemStack knightSheild() {
        ItemStack sheild = new ItemStack(Material.SHIELD);
        ItemMeta meta = sheild.getItemMeta();
        meta.setDisplayName("sugma BALLZ");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        sheild.setItemMeta(meta);
        return sheild;
    }
    public ItemStack archerBow() {
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta meta = bow.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Bow of Robin");
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 8, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bow.setItemMeta(meta);

        return bow;
    }
    public ItemStack archerArrow(){
        ItemStack arrow = new ItemStack(Material.ARROW);
        return arrow;
    }
    public ItemStack archerHead() {
        ItemStack boots = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "frog helm");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack archerFoot() {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "frog feet");
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack pyroSword(){
        ItemStack sword = new ItemStack(Material.STONE_SWORD);
        ItemMeta meta = sword.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Sword of FLAMES");
        meta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        sword.setItemMeta(meta);

        return sword;
    }
    public ItemStack pyroBoots() {
        ItemStack boots = new ItemStack(Material.GOLDEN_BOOTS);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Boots of FLAMES");
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack pyroLegs() {
        ItemStack boots = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Legs of FLAMES");
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack pyroChest() {
        ItemStack boots = new ItemStack(Material.GOLDEN_CHESTPLATE);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Chest of FLAMES");
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack pyroHelm() {
        ItemStack boots = new ItemStack(Material.GOLDEN_HELMET);
        ItemMeta meta = boots.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "Helm of FLAMES");
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 10, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        boots.setItemMeta(meta);

        return boots;
    }
    public ItemStack invStick() {
        ItemStack stick = new ItemStack(Material.STICK);
        ItemMeta meta = stick.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "Ninja death STICK");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "" + ChatColor.AQUA + "hold in hand and move to be granted INVIZILINE");
        lore.add("");
        lore.add(ChatColor.ITALIC + "" + ChatColor.WHITE + "sharpness 21 >:)");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 21, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        stick.setItemMeta(meta);

        return stick;
    }
    public ItemStack pot1() {
        ItemStack pot1 = new ItemStack(Material.POTION, 10);

        PotionMeta potionmeta = (PotionMeta) pot1.getItemMeta();
        potionmeta.setMainEffect(PotionEffectType.SPEED);
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 75, 4);
        PotionEffect reg = new PotionEffect(PotionEffectType.REGENERATION, 100, 2);
        potionmeta.addCustomEffect(speed, true);
        potionmeta.addCustomEffect(reg, true);
        potionmeta.setDisplayName("§9Potion of Speed and Regen");
        pot1.setItemMeta(potionmeta);

        return pot1;
    }
    public ItemStack pot4() {
        ItemStack pot1 = new ItemStack(Material.POTION, 32);

        PotionMeta potionmeta = (PotionMeta) pot1.getItemMeta();
        potionmeta.setMainEffect(PotionEffectType.SLOW);
        PotionEffect speed = new PotionEffect(PotionEffectType.SLOW, 150, 1);
        PotionEffect reg = new PotionEffect(PotionEffectType.WEAKNESS, 200, 1);
        potionmeta.addCustomEffect(speed, true);
        potionmeta.addCustomEffect(reg, true);
        potionmeta.setDisplayName("§6Potion Of Slowness and Weakness");
        potionmeta.setColor(Color.GRAY);
        pot1.setItemMeta(potionmeta);
        pot1.setType(Material.SPLASH_POTION);

        return pot1;
    }
    public ItemStack pot5() {
        ItemStack pot1 = new ItemStack(Material.POTION, 8);

        PotionMeta potionmeta = (PotionMeta) pot1.getItemMeta();
        potionmeta.setMainEffect(PotionEffectType.HARM);
        PotionEffect speed = new PotionEffect(PotionEffectType.HARM, 1000, 1);
        PotionEffect reg = new PotionEffect(PotionEffectType.WITHER, 90, 1);
        potionmeta.addCustomEffect(speed, true);
        potionmeta.addCustomEffect(reg, true);
        potionmeta.setDisplayName("§6Potion Of DEATH");
        potionmeta.setColor(Color.BLACK);
        pot1.setItemMeta(potionmeta);
        pot1.setType(Material.SPLASH_POTION);

        return pot1;
    }
    public ItemStack pot2() {
        ItemStack pot1 = new ItemStack(Material.POTION, 64);

        PotionMeta potionmeta = (PotionMeta) pot1.getItemMeta();
        potionmeta.setMainEffect(PotionEffectType.HEAL);
        PotionEffect speed = new PotionEffect(PotionEffectType.HEAL, 1000, 1);
        PotionEffect reg = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1);
        potionmeta.addCustomEffect(speed, true);
        potionmeta.addCustomEffect(reg, true);
        potionmeta.setDisplayName("§6Potion Of Healing");
        potionmeta.setColor(Color.PURPLE);
        pot1.setItemMeta(potionmeta);

        return pot1;
    }
    public ItemStack pot3() {
        ItemStack pot1 = new ItemStack(Material.POTION, 1);

        PotionMeta potionmeta = (PotionMeta) pot1.getItemMeta();
        potionmeta.setMainEffect(PotionEffectType.SLOW_FALLING);
        PotionEffect speed = new PotionEffect(PotionEffectType.SLOW_FALLING, 300, 1);
        PotionEffect reg = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000, 1);
        PotionEffect dog = new PotionEffect(PotionEffectType.WATER_BREATHING, 2000, 1);
        potionmeta.addCustomEffect(speed, true);
        potionmeta.addCustomEffect(reg, true);
        potionmeta.addCustomEffect(dog, true);
        potionmeta.setDisplayName("§6Potion Of WEIRD");
        potionmeta.setColor(Color.YELLOW);
        pot1.setItemMeta(potionmeta);
        pot1.setType(Material.SPLASH_POTION);

        return pot1;
    }
    public ItemStack pot6() {
        ItemStack pot1 = new ItemStack(Material.POTION, 32);

        PotionMeta potionmeta = (PotionMeta) pot1.getItemMeta();
        potionmeta.setMainEffect(PotionEffectType.POISON);
        PotionEffect speed = new PotionEffect(PotionEffectType.POISON, 1000, 1);
        PotionEffect reg = new PotionEffect(PotionEffectType.BAD_OMEN, 100, 1);
        potionmeta.addCustomEffect(speed, true);
        potionmeta.addCustomEffect(reg, true);
        potionmeta.setDisplayName("§6Potion of POISON");
        potionmeta.setColor(Color.PURPLE);
        pot1.setItemMeta(potionmeta);
        pot1.setType(Material.SPLASH_POTION);

        return pot1;
    }
    public ItemStack chemW() {
        ItemStack cax = new ItemStack(Material.GOLDEN_AXE);
        ItemMeta meta = cax.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Axe O' da ring");
        meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        cax.setItemMeta(meta);

        return cax;
    }
    public ItemStack chemHead() {
        ItemStack head = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Chemist HEAD");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "" + ChatColor.GREEN + "I want some chemist head");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack chemChest() {
        ItemStack head = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Chemist Chest");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack chemLegs() {
        ItemStack head = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Chemist Legs");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack chemFeed() {
        ItemStack head = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GREEN + "Chemist Feet");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack horseHead() {
        ItemStack head = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Jockey Helmet");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack horseChest() {
        ItemStack head = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Jockey Chest");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack horseLegs() {
        ItemStack head = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Jockey Leggings");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack horseFeet() {
        ItemStack head = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Jockey Boots");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack horseW() {
        ItemStack head = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "Neigh for me >:)");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public ItemStack horseSpawn() {
        ItemStack head = new ItemStack(Material.STICK);
        ItemMeta meta = head.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "Right click the ground to spawn your horse!");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        head.setItemMeta(meta);

        return head;
    }
    public void endermanSpawner(Block block) {
        BlockState blockState = block.getState();
        CreatureSpawner spawner = ((CreatureSpawner)blockState);
        spawner.setSpawnedType(EntityType.ENDERMAN);
        blockState.update();
    }
    public ItemStack compass() {
        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Kit Selector");
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        compass.setItemMeta(meta);

        return compass;
    }
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.STICK))
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta()
                    .getDisplayName().contains("Stick O' Doom")) {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                    Player player = (Player) event.getPlayer();
                    if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        if (cooldowns.containsKey(player.getName())) {
                            if (cooldowns.get(player.getName()) > System.currentTimeMillis()) {
                                return;
                            }
                        }
                        cooldowns.put(player.getName(), System.currentTimeMillis() + 25 * 1000);

                        Block b = player.getTargetBlock(null, 5);
                        Location loc = b.getLocation();
                        loc.setY(loc.getY() + 1);
                        int duck = 0;
                        while (3 != duck) {
                            loc.setX(loc.getX() + 1);
                            Entity sdrown = loc.getWorld().spawnEntity(loc, EntityType.WITHER_SKELETON);
                            sdrown.setCustomName("Skelly O' Doom!");
                            sdrown.setCustomNameVisible(true);
                            sdrown.setGlowing(true);
                            duck += 1;
                        }

                    }
                    if (event.getAction() == Action.LEFT_CLICK_AIR) {
                        player.launchProjectile(Fireball.class);
                    }
                }
            }
    }
    @EventHandler
    public void onJump(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.getInventory().getBoots() != null) {
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots O' Doom")) {
                if (player.getInventory().getBoots().getItemMeta().hasLore()) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 13));
                }
            }
        }
    }
    @EventHandler
    public void knightSpeed(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.getInventory().getBoots() != null) {
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Feet of the Knight")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 1));
            }
        }
    }
    @EventHandler
    public void invisstick(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.getInventory().getItemInMainHand().getType() == Material.STICK) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
                    .contains("Ninja death STICK")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 220, 1));
            }
        }
    }
    @EventHandler
    public void pyroStep(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.getInventory().getBoots() != null) {
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots of FLAMES")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 2));
                Location loc = event.getPlayer().getLocation().clone();
                if (loc.getBlock().getType() == Material.AIR) {
                    loc.getBlock().setType(Material.FIRE);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.GOLD + player.getName() + ChatColor.AQUA + " out lul");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        createBoard(e.getPlayer());
        player.getInventory().clear();
        player.getInventory().addItem(compass());

        player.getActivePotionEffects().stream()
                .map(PotionEffect::getType)
                .forEach(player::removePotionEffect);

        e.setJoinMessage(ChatColor.GOLD + player.getName() + ChatColor.AQUA + " in");
        player.teleport(player.getWorld().getSpawnLocation());
        player.setHealth(20);
        player.setFoodLevel(20);
        if (player.getPlayer().getGameMode() != GameMode.ADVENTURE){
            player.setGameMode(GameMode.ADVENTURE);
        }
    }

    @EventHandler
    public void motd(ServerListPingEvent event) {
        event.setMotd(ChatColor.DARK_RED + "" + ChatColor.BOLD + "RAGE " + ChatColor.RESET + ChatColor.BLUE
                + "Kit PvP");
    }

    @EventHandler()
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (!e.getInventory().equals(inv)) return;
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        e.setCancelled(true);
        if (e.getSlot() == 0 || e.getSlot() == 9) {
            player.sendMessage(ChatColor.GOLD + "Not a kit");
        }
        if (e.getSlot() == 1) {
            player.getInventory().clear();
            player.getInventory().addItem(chemW());
            player.getInventory().addItem(pot1());
            player.getInventory().addItem(pot2());
            player.getInventory().addItem(pot6());
            player.getInventory().addItem(pot3());
            player.getInventory().addItem(pot4());
            player.getInventory().addItem(pot5());
            player.getInventory().setHelmet(chemHead());
            player.getInventory().setChestplate(chemChest());
            player.getInventory().setLeggings(chemLegs());
            player.getInventory().setBoots(chemFeed());
            player.closeInventory();
        }
        if (e.getSlot() == 2) {
            player.getInventory().clear();
            player.getInventory().addItem(getDoom());
            player.getInventory().addItem(doomStick());
            player.getInventory().setBoots(doomBoots());
            player.closeInventory();
        }
        if (e.getSlot() == 3) {
            player.getInventory().clear();
            player.getInventory().setBoots(knightBoots());
            player.getInventory().setLeggings(knightLegs());
            player.getInventory().setChestplate(knightChest());
            player.getInventory().setHelmet(knightHead());
            player.getInventory().setItemInMainHand(knightSword());
            player.getInventory().setItemInOffHand(knightSheild());
            player.closeInventory();
        }
        if (e.getSlot() == 4) {
            player.getInventory().clear();
            player.getInventory().addItem(archerBow());
            player.getInventory().addItem(archerArrow());
            player.getInventory().setBoots(archerFoot());
            player.getInventory().setHelmet(archerHead());
            player.closeInventory();
        }
        if (e.getSlot() == 5) {
            player.getInventory().clear();
            player.getInventory().addItem(pyroSword());
            player.getInventory().setBoots(pyroBoots());
            player.getInventory().setLeggings(pyroLegs());
            player.getInventory().setChestplate(pyroChest());
            player.getInventory().setHelmet(pyroHelm());
            player.closeInventory();
        }
        if (e.getSlot() == 6) {
            player.getInventory().clear();
            player.getInventory().addItem(invStick());
            player.closeInventory();
        }
        if (e.getSlot() == 10) {
            if (player.hasPermission("kits.vip")) {
                player.getInventory().clear();
                player.getInventory().setBoots(horseFeet());
                player.getInventory().setLeggings(horseLegs());
                player.getInventory().setChestplate(horseChest());
                player.getInventory().setHelmet(horseHead());
                player.getInventory().addItem(horseW());
                player.getInventory().addItem(horseSpawn());
                player.closeInventory();

            }
            else {
                player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                        + "" + ChatColor.GREEN + "VIP");
            }
        }
        if (e.getSlot() == 11) {
            if (player.hasPermission("kits.vip")) {
                player.getInventory().clear();
                player.getInventory().addItem(new ItemStack(Material.NETHERITE_SWORD));
                player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 64));
                player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 64));
                player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 64));
                player.getInventory().setHelmet(new ItemStack(Material.DRAGON_HEAD));
                player.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                player.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                player.closeInventory();
            } else {
                player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                        + "" + ChatColor.GREEN + "VIP");
            }
        }
        if (e.getSlot() == 7) {
            player.getInventory().clear();
            ItemStack LDHelmet = new ItemStack(Material.NETHERITE_SWORD);
            LDHelmet.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 20);
            player.getInventory().addItem(new ItemStack[]{new ItemStack(LDHelmet)});
            player.getInventory().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
            player.getInventory().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
            player.getInventory().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
            player.getInventory().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2147483647, 3));
            player.closeInventory();
        }
        if (e.getSlot() == 8) {
            player.getInventory().clear();
            player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
            player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            player.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            getServer().dispatchCommand(getServer().getConsoleSender(), "shot give "
                    + player.getName() + " python");
            getServer().dispatchCommand(getServer().getConsoleSender(), "shot give "
                    + player.getName() + " flashbang 3");
            player.closeInventory();
        }
        if (e.getSlot() == 12) {
            if (player.hasPermission("kits.vip")) {
                player.getInventory().clear();
                ItemStack helmet111 = new ItemStack(Material.IRON_HELMET);
                helmet111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
                helmet111.addEnchantment(Enchantment.THORNS, 3);
                player.getEquipment().setHelmet(helmet111);
                ItemStack capacete0 = new ItemStack(Material.IRON_CHESTPLATE);
                capacete0.addEnchantment(Enchantment.THORNS, 3);
                capacete0.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
                player.getEquipment().setChestplate(capacete0);
                ItemStack peitoral0 = new ItemStack(Material.LEATHER_LEGGINGS);
                peitoral0.addEnchantment(Enchantment.THORNS, 3);
                peitoral0.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
                player.getEquipment().setLeggings(peitoral0);
                ItemStack calca0 = new ItemStack(Material.LEATHER_BOOTS);
                calca0.addEnchantment(Enchantment.THORNS, 3);
                calca0.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
                player.getEquipment().setBoots(calca0);
                player.closeInventory();
            }
            else {
                player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                        + "" + ChatColor.GREEN + "VIP");
            }
        }
        if (e.getSlot() == 16) {
            if (player.hasPermission("kits.vip")) {
                player.getInventory().clear();
                ItemStack helmet111 = new ItemStack(Material.LEATHER_HELMET);
                helmet111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
                helmet111.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                player.getEquipment().setHelmet(helmet111);
                ItemStack capacete0 = new ItemStack(Material.LEATHER_CHESTPLATE);
                capacete0.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
                capacete0.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                player.getEquipment().setChestplate(capacete0);
                ItemStack peitoral0 = new ItemStack(Material.LEATHER_LEGGINGS);
                peitoral0.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
                peitoral0.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                player.getEquipment().setLeggings(peitoral0);
                ItemStack calca0 = new ItemStack(Material.LEATHER_BOOTS);
                calca0.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
                calca0.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                player.getEquipment().setBoots(calca0);
                getServer().dispatchCommand(getServer().getConsoleSender(), "shot give "
                        + player.getName() + " AK-47");
                getServer().dispatchCommand(getServer().getConsoleSender(), "shot give "
                        + player.getName() + " cocopops 5");
                getServer().dispatchCommand(getServer().getConsoleSender(), "shot give "
                        + player.getName() + " toaster");
                player.closeInventory();
            }
            else {
                player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                        + "" + ChatColor.GREEN + "VIP");
            }
        }
    }
    @EventHandler()
    public void compassClick(PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.COMPASS))
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta()
                    .getDisplayName().contains("Kit Selector")) {
                Player player = (Player) event.getPlayer();
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                    player.openInventory(inv);
                }
            }
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.setDroppedExp(0);
        event.getDrops().clear();
        Player player = event.getEntity().getPlayer();
        player.getInventory().clear();
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta)head.getItemMeta();
        meta.setOwner(player.getDisplayName());
        meta.setDisplayName(ChatColor.GREEN + player.getDisplayName() + "s" + ChatColor.AQUA + " head");
        head.setItemMeta(meta);
        event.getDrops().add(head);
    }
    @EventHandler
    public void eatHead(PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().contains(Material.PLAYER_HEAD)) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.PLAYER_HEAD)) {
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                    Player player = (Player) event.getPlayer();
                    ItemStack head = new ItemStack(player.getInventory().getItemInMainHand());
                    player.getInventory().removeItem(head);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 2));
                    player.sendMessage(ChatColor.GOLD + "You have been nourished by your victim");
                }
            }
        }
    }
    @EventHandler
    public void respawn(PlayerRespawnEvent event) {
        Player player = (Player) event.getPlayer();
        player.getInventory().addItem(compass());
    }
    @EventHandler
    public void onEDeath(EntityDeathEvent e) {
        if (!(e instanceof Player)) {
            e.setDroppedExp(0);
            e.getDrops().clear();
        }
    }
    @EventHandler
    public void onFall(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            player.setFoodLevel(20);
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL)
                event.setCancelled(true);
        }
    }
    @EventHandler
    public void noHunger(FoodLevelChangeEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            player.setFoodLevel(20);
        }
    }

    @EventHandler
    public void noHungerDmg(EntityRegainHealthEvent event){
        if (event.getEntity() instanceof  Player){
            Player player = (Player) event.getEntity();
            player.setFoodLevel(20);
        }
    }
    @EventHandler
    public void noBed(PlayerBedEnterEvent event){
        event.setCancelled(true);
    }
    @EventHandler
    public void nopvp(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Location loc = event.getEntity().getLocation().clone();
            if (loc.getY() >= 119){
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void horsepawn(PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.STICK))
            if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta()
                    .getDisplayName().contains("Right click the ground to spawn your horse!")) {
                Player player = (Player) event.getPlayer();
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Block b = player.getTargetBlock(null, 5);
                    Horse h = (Horse) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
                    h.setTamed(true);
                    h.setOwner(event.getPlayer());
                    h.getInventory().setSaddle(new ItemStack(Material.SADDLE, 1));
                    h.getInventory().setArmor(new ItemStack(Material.DIAMOND_HORSE_ARMOR));
                    player.getInventory().removeItem(horseSpawn());
                }
            }
    }
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event){
        if (event.getCause() == BlockIgniteEvent.IgniteCause.SPREAD){
            event.setCancelled(true);
        }
        Location loc = event.getBlock().getLocation().clone();
        loc.setY(loc.getY() + 1);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
        loc.setY(loc.getY() - 1);
        loc.setZ(loc.getZ() + 1);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
        loc.setZ(loc.getZ() - 2);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
        loc.setZ(loc.getZ() + 1);
        loc.setX(loc.getX() + 1);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
        loc.setX(loc.getX() - 2);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
    }
    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        event.setCancelled(true);
        Location loc = event.getBlock().getLocation().clone();
        loc.setY(loc.getY() + 1);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
        loc.setY(loc.getY() - 1);
        loc.setZ(loc.getZ() + 1);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
        loc.setZ(loc.getZ() - 2);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
        loc.setZ(loc.getZ() + 1);
        loc.setX(loc.getX() + 1);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
        loc.setX(loc.getX() - 2);
        if (loc.getBlock().getType() == Material.FIRE) {
            loc.getBlock().setType(Material.AIR);
        }
    }
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        Player p = event.getPlayer();

        if (event.getBlock().getType().equals(Material.SPAWNER)) {
            endermanSpawner(event.getBlockPlaced());

            p.sendMessage("You have just created a spawner!");
        }
    }
}