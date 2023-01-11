package ragekitpvp.ragekitpvp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import java.util.*;

public class RageKitPvP extends JavaPlugin implements Listener {
    Map<String, Long> doomCooldowns = new HashMap<String, Long>();
    Map<String, Long> aquaCooldowns = new HashMap<String, Long>();
    kitInv inventory = new kitInv();
    RageScoreboard scoreboard = new RageScoreboard();
    Items items = new Items();

    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(this, this);
        inventory.createInv();
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

        if (label.equalsIgnoreCase("flex")) {
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

        }

        if (label.equalsIgnoreCase("ping") && sender instanceof Player){
            Player player = (Player) sender;
            player.sendMessage(("Your ping is " + player.getPing()));
        }

        if (label.equalsIgnoreCase("die") && sender instanceof  Player) {
            Player player = (Player) sender;
            player.setHealth(0.0);
            player.sendMessage("ya done now");
        }

        if (label.equalsIgnoreCase("ip") && sender instanceof Player && sender.hasPermission("kits.ip")) {
            if (args[0] != null) {
                sender.sendMessage("Provide the players name");
            }
            try {
                Player player = Bukkit.getServer().getPlayer(args[0]);
                sender.sendMessage(player.getName() + "'s ping is : " + player.getAddress());
            }
            catch(Exception e) {
                sender.sendMessage("not a player. I got : "  + args[0]);
            }
        }

        return true;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack mainItem = player.getInventory().getItemInMainHand();

        if (mainItem.getType().equals(Material.STICK)) {
            if (player.getInventory().getItemInMainHand().getItemMeta()
                    .getDisplayName().contains("Stick O' Doom")) {
                if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                    if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        if (doomCooldowns.containsKey(player.getName())) {
                            if (doomCooldowns.get(player.getName()) > System.currentTimeMillis()) {
                                return;
                            }
                        }
                        doomCooldowns.put(player.getName(), System.currentTimeMillis() + 25 * 1000);

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

        if (mainItem.getType().equals(Material.TRIDENT) &&
                mainItem.getItemMeta().getDisplayName().contains("are eye pee") &&
                event.getAction() == Action.LEFT_CLICK_AIR && player.isInWater()) {

                    if (aquaCooldowns.containsKey(player.getName())
                            && aquaCooldowns.get(player.getName()) > System.currentTimeMillis()) {
                        player.sendMessage(ChatColor.YELLOW + "On cool down");
                        return;
                    }

                    aquaCooldowns.put(player.getName(), System.currentTimeMillis() + 5 * 1000);
                    Block eyeBlock = player.getTargetBlock(null, 100);
                    Location eyeLoc = eyeBlock.getLocation();
                    player.getWorld().strikeLightning(eyeLoc);

        }

        if (mainItem.getType().equals(Material.COMPASS)) {
            if (player.getInventory().getItemInMainHand().getItemMeta()
                    .getDisplayName().contains("Kit Selector")) {
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){
                    player.openInventory(inventory.inv);
                }
            }
        }

        if (player.getInventory().contains(Material.PLAYER_HEAD)) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.PLAYER_HEAD)) {
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                    ItemStack head = new ItemStack(player.getInventory().getItemInMainHand());
                    player.getInventory().removeItem(head);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 2));
                    player.sendMessage(ChatColor.GOLD + "You have been nourished by your victim");
                }
            }
        }

        if ((event.getAction() == Action.PHYSICAL)) {
            Block soilBlock = event.getClickedBlock();
            if (soilBlock.getType() == Material.FARMLAND) {
                event.setCancelled(true);
            }
        }

        if (mainItem.getType().equals(Material.STICK)) {
            if (player.getInventory().getItemInMainHand().getItemMeta()
                    .getDisplayName().contains("Right click the ground to spawn your horse!")) {
                if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Horse h = (Horse) player.getWorld().spawnEntity(player.getLocation(), EntityType.HORSE);
                    h.setTamed(true);
                    h.setCustomName("Steed O' " + player.getName());
                    h.setCustomNameVisible(true);
                    h.setOwner(event.getPlayer());
                    h.getInventory().setSaddle(new ItemStack(Material.SADDLE, 1));
                    h.getInventory().setArmor(new ItemStack(Material.DIAMOND_HORSE_ARMOR));
                    player.getInventory().removeItem(items.horseSpawn());
                }
            }
        }

        if (mainItem.getType().equals(Material.HEART_OF_THE_SEA) && event.getAction() == Action.RIGHT_CLICK_BLOCK &&
                mainItem.getItemMeta().getDisplayName().contains("Axe or Ottle ?")) {

            Block b = player.getTargetBlock(null, 5);
            Location loc = b.getLocation();
            int axeAmount = 0;
            while (8 != axeAmount) {
                Drowned drown = (Drowned) loc.getWorld().spawnEntity(loc, EntityType.DROWNED);
                drown.setCustomName(player.getName());
                drown.setCustomNameVisible(true);
                drown.setGlowing(true);
                axeAmount += 1;
            }
            player.getInventory().removeItem(items.aquaHeart());
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

        if (player.getInventory().getBoots() != null) {
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Feet of the Knight")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 1));
            }
        }

        if (player.getInventory().getItemInMainHand().getType() == Material.STICK) {
            if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
                    .contains("Ninja death STICK")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 220, 1));
            }
        }

        if (player.getInventory().getBoots() != null) {
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots of FLAMES")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 2));
                Location loc = event.getPlayer().getLocation().clone();
                if (loc.getBlock().getType() == Material.AIR) {
                    loc.getBlock().setType(Material.FIRE);
                    getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
                        @Override
                        public void run() {
                            if (loc.getBlock().getType() == Material.FIRE){
                                loc.getBlock().setType(Material.AIR);
                            }
                        }
                    }, 75);
                }
            }
        }

        Location loc = event.getPlayer().getLocation().clone();
        if (loc.getBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {
            player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.GOLD + player.getName() + ChatColor.AQUA + " out");

        Collection<Entity> entities = player.getWorld().getEntities();
        for (Entity ent : entities){
            if (ent.getName().equalsIgnoreCase("Charles => " + player.getName())){
                Warden charles = (Warden) ent;
                charles.remove();
                return;
            }
            if (ent.getName().equalsIgnoreCase("Steed O' " + player.getName())) {
                Horse horse = (Horse) ent;
                horse.remove();
                return;
            }
            if (ent.getName().contains(player.getName()) && ent.getType() == EntityType.DROWNED) {
                Drowned drown = (Drowned) ent;
                drown.remove();
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        scoreboard.createBoard(e.getPlayer());
        player.getInventory().clear();
        player.getInventory().addItem(items.compass());

        player.getActivePotionEffects().stream()
                .map(PotionEffect::getType)
                .forEach(player::removePotionEffect);

        e.setJoinMessage(ChatColor.GOLD + player.getName() + ChatColor.AQUA + " in");
        player.teleport(player.getWorld().getSpawnLocation());
        player.setHealth(20);
        player.setFoodLevel(20);
        if (player.getGameMode() != GameMode.ADVENTURE && player.getName() != "Spiigot"){
            player.setGameMode(GameMode.ADVENTURE);
        }
    }

    @EventHandler
    public void motd(ServerListPingEvent event) {
        event.setMotd(ChatColor.GOLD + "" + ChatColor.BOLD + "The Battle Grounds of "
                + ChatColor.RESET + "" + ChatColor.BOLD + "" + ChatColor.BLUE + "Eldaria");
    }

    @EventHandler()
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getSlotType().equals(InventoryType.SlotType.ARMOR) && player.getInventory().getLeggings() != null) {
            if (player.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS)
                if (player.getInventory().getLeggings().getItemMeta().getDisplayName().contains("PissPants"))
                    if (player.getInventory().getLeggings().getItemMeta().hasLore()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 600, 2));
                        player.sendMessage(ChatColor.AQUA + player.getName()
                                + ChatColor.GOLD + " " + ChatColor.BOLD + "PISSED PANTS");
                    }
        }

        if (!e.getInventory().equals(inventory.inv)) return;
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        e.setCancelled(true);
        if (e.getSlot() == 0 || e.getSlot() == 9) {
            player.sendMessage(ChatColor.GOLD + "Not a kit");
        }
        if (e.getSlot() == 1) {
            player.getInventory().clear();
            player.getInventory().addItem(items.chemW());
            player.getInventory().addItem(items.pot1());
            player.getInventory().addItem(items.pot2());
            player.getInventory().addItem(items.pot6());
            player.getInventory().addItem(items.pot3());
            player.getInventory().addItem(items.pot4());
            player.getInventory().addItem(items.pot5());
            player.getInventory().setHelmet(items.chemHead());
            player.getInventory().setChestplate(items.chemChest());
            player.getInventory().setLeggings(items.chemLegs());
            player.getInventory().setBoots(items.chemFeed());
            player.closeInventory();
        }
        if (e.getSlot() == 2) {
            player.getInventory().clear();
            player.getInventory().addItem(items.getDoom());
            player.getInventory().addItem(items.doomStick());
            player.getInventory().setBoots(items.doomBoots());
            player.closeInventory();
        }
        if (e.getSlot() == 3) {
            player.getInventory().clear();
            player.getInventory().setBoots(items.knightBoots());
            player.getInventory().setLeggings(items.knightLegs());
            player.getInventory().setChestplate(items.knightChest());
            player.getInventory().setHelmet(items.knightHead());
            player.getInventory().setItemInMainHand(items.knightSword());
            player.getInventory().setItemInOffHand(items.knightSheild());
            player.closeInventory();
        }
        if (e.getSlot() == 4) {
            player.getInventory().clear();
            player.getInventory().addItem(items.archerBow());
            player.getInventory().addItem(items.archerArrow());
            player.getInventory().setBoots(items.archerFoot());
            player.getInventory().setHelmet(items.archerHead());
            player.closeInventory();
        }
        if (e.getSlot() == 5) {
            player.getInventory().clear();
            player.getInventory().addItem(items.pyroSword());
            player.getInventory().setBoots(items.pyroBoots());
            player.getInventory().setLeggings(items.pyroLegs());
            player.getInventory().setChestplate(items.pyroChest());
            player.getInventory().setHelmet(items.pyroHelm());
            player.closeInventory();
        }
        if (e.getSlot() == 6) {
            player.getInventory().clear();
            player.getInventory().addItem(items.invStick());
            player.closeInventory();
        }
        if (e.getSlot() == 10) {
            if (2 > 1) {
                player.getInventory().clear();
                player.getInventory().setBoots(items.horseFeet());
                player.getInventory().setLeggings(items.horseLegs());
                player.getInventory().setChestplate(items.horseChest());
                player.getInventory().setHelmet(items.horseHead());
                player.getInventory().addItem(items.horseW());
                player.getInventory().addItem(items.horseSpawn());
                player.closeInventory();

            }
            else {
                player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                        + "" + ChatColor.GREEN + "VIP");
            }
        }
        if (e.getSlot() == 11) {
            if (2 > 1) {
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
            if (2 > 1) {
                player.getInventory().clear();
                player.getEquipment().setHelmet(items.cactusHead());
                player.getEquipment().setChestplate(items.cactusChest());
                player.getEquipment().setLeggings(items.cactusLeg());
                player.getEquipment().setBoots(items.cactusFoot());
                player.closeInventory();
            }
            else {
                player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                        + "" + ChatColor.GREEN + "VIP");
            }
        }
        if (e.getSlot() == 13) {
            if (2 > 1) {
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

        if (e.getSlot() == 14) {
            if (2 > 1){
                player.getInventory().clear();
                player.getInventory().addItem(items.wardenFlint());
                player.getInventory().setChestplate(items.wardenElytra());
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 12000, 3));
                player.closeInventory();

            } else {
                player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                        + "" + ChatColor.GREEN + "VIP");
            }
        }

        if (e.getSlot() == 15) {
            if (2 > 1){
                player.getInventory().clear();
                player.getInventory().addItem(items.aquaTrident());
                player.getInventory().addItem(items.aquaHeart());
                player.getInventory().setHelmet(items.aquaHead());
                player.getInventory().setBoots(items.aquaFoot());
                player.closeInventory();

            } else {
                player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                        + "" + ChatColor.GREEN + "VIP");
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
        player.teleport(player.getWorld().getSpawnLocation());
    }

    @EventHandler
    public void respawn(PlayerRespawnEvent event) {
        Player player = (Player) event.getPlayer();
        player.getInventory().addItem(items.compass());

        Collection<Entity> entities = player.getWorld().getEntities();
        for (Entity ent : entities){
            if (ent.getName().equalsIgnoreCase("Charles => " + player.getName())){
                Location loc = player.getLocation().clone();
                loc.getWorld().playEffect(loc,  Effect.SMOKE, 10);
                Warden charles = (Warden) ent;
                charles.remove();
                player.sendMessage(ChatColor.YELLOW + "you let charles die alone");
                return;
            }
            if (ent.getName().equalsIgnoreCase("Steed O' " + player.getName())) {
                Horse horse = (Horse) ent;
                horse.remove();
                player.sendMessage(ChatColor.YELLOW + "horse gone king");
                return;
            }
            if (ent.getName().contains(player.getName()) && ent.getType() == EntityType.DROWNED) {
                Drowned drown = (Drowned) ent;
                drown.remove();
            }
        }

    }
    @EventHandler
    public void onEDeath(EntityDeathEvent entity) {
        if (!(entity instanceof Player)) {
            entity.setDroppedExp(0);
            entity.getDrops().clear();
        }

        if (entity.getEntityType() == EntityType.WARDEN && entity.getEntity().getName().startsWith("Charles")){
            Location oldloc = entity.getEntity().getKiller().getLocation().clone();
            Location loc = oldloc;

            for (Integer i = 1; i < 1000; i++){
                loc.setY(loc.getY() + .175);
                loc.getWorld().playEffect(loc,  Effect.SMOKE, 5);
                entity.getEntity().teleport(loc);
            }

            entity.getEntity().remove();
            oldloc.getWorld().dropItem(oldloc, items.pissPants());
        }
    }

    @EventHandler
    public void EdmgE(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            Collection<Entity> entities = player.getWorld().getEntities();
            if (player.getInventory().getItemInMainHand().getType().equals(Material.FLINT) &&
                    player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Guide O' Charles")) {
                    for (Entity ent : entities){
                        if (ent.getName().equalsIgnoreCase("Charles => " + player.getName())){
                            Location loc = player.getLocation().clone();
                            loc.getWorld().playEffect(loc,  Effect.SMOKE, 5);
                            Warden charles = (Warden) ent;
                            charles.teleport(loc);
                            charles.setAnger(event.getEntity(), 150);
                            player.sendMessage(ChatColor.BOLD + "" + ChatColor.MAGIC + "12345abcde");
                            player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Charles ATTACK!");
                            player.sendMessage(ChatColor.BOLD + "" + ChatColor.MAGIC + "12345abcde");
                            return;
                        }
                    }


                Warden warden = (Warden) player.getWorld().spawnEntity(player.getLocation(), EntityType.WARDEN);

                warden.setCustomName("Charles => " + player.getName());
                warden.setCustomNameVisible(true);
                warden.setGlowing(true);
                warden.clearAnger(player);
                warden.setAnger(event.getEntity(), 150);
                warden.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1));

            }

            Location loc = player.getLocation().clone();
            if (loc.getY() >= 119){
                event.setCancelled(true);
            }
        }
        Entity entity = event.getDamager();
        Entity target = event.getEntity();
        Player player = (Player) target;
        if (entity.getName().equalsIgnoreCase("Charles => " + target.getName())){
            Warden warden = (Warden) entity;
            warden.clearAnger(player);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFall(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {

            Player player = (Player) event.getEntity();
            player.setFoodLevel(20);
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                event.setCancelled(true);
            }

            Location loc = event.getEntity().getLocation().clone();
            if (loc.getY() >= 119){
                event.setCancelled(true);
            }
        }
        Player player = (Player) event.getEntity();
        if (event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING &&
                player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("are eye pee") &&
                player.getInventory().getItemInMainHand().getType() == Material.TRIDENT){
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

        Player player = event.getPlayer();
        Location loc = player.getLocation().clone();
        player.setBedSpawnLocation(player.getWorld().getSpawnLocation());
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
    public void onTarget(EntityTargetEvent event) {
        Entity entity = event.getEntity();
        Entity target = event.getTarget();
        if (entity.getName().equalsIgnoreCase("Charles => " + target.getName())){
            Player player = (Player) target;
            Warden warden = (Warden) entity;
            warden.clearAnger(player);
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void dropItem(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }
}