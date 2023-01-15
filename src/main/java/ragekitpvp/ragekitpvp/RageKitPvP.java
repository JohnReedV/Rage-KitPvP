package ragekitpvp.ragekitpvp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;


public class RageKitPvP extends JavaPlugin implements Listener {
    CommandHandler commands = new CommandHandler();
    EventHandlerInternal events = new EventHandlerInternal();
    KitInventory kitInv = new KitInventory();
    BroadCaster broadCaster = new BroadCaster();
    StatisticsInventory statsInv = new StatisticsInventory();

    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(this, this);
        kitInv.createInv();
        statsInv.getInv();

        double hours = .5;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                broadCaster.broadCast();
            }
        }, 0, (long) (20*60*60*hours));

        System.out.println("RagePvP in");
    }
    @Override
    public void onDisable(){
        System.out.println("RagePvP out");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("head")) { commands.handleHead(sender, args); }
        if (label.equalsIgnoreCase("kits")) { commands.handleKits(sender, kitInv.inv); }
        if (label.equalsIgnoreCase("setspawn")) { commands.handleSetspawn(sender); }
        if (label.equalsIgnoreCase("flex")) { commands.handleFlex(sender); }
        if (label.equalsIgnoreCase("ping")){ commands.handlePing(sender); }
        if (label.equalsIgnoreCase("die")) { commands.handleDie(sender); }
        if (label.equalsIgnoreCase("ip")) { commands.handleIp(sender, args); }
        if (label.equalsIgnoreCase("randomkit")) { commands.handleRandomKit(sender); }
        return true;
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) { events.handleInteract(event, kitInv.inv, statsInv.inv); }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) { events.handlePlayerQuit(event); }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) { events.handlePlayerJoin(event); }

    @EventHandler
    public void motd(ServerListPingEvent event) { events.handleMOTD(event); }

    @EventHandler
    public void onClick(InventoryClickEvent e) { events.handleInvClick(e, kitInv.inv, statsInv.inv); }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) { events.handlePlayerDeath(event); }

    @EventHandler
    public void respawn(PlayerRespawnEvent event) { events.handleRespawn(event); }
    @EventHandler
    public void onEDeath(EntityDeathEvent entity) { events.handleEntityDeath(entity); }

    @EventHandler
    public void EdmgE(EntityDamageByEntityEvent event) { events.handleEntitydmgbyEntity(event); }

    @EventHandler
    public void onFall(EntityDamageEvent event) { events.handleEntityDMG(event); }

    @EventHandler
    public void noBed(PlayerBedEnterEvent event){ events.handlePlayerEnterBed(event); }

    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event){ events.handleBlockIgnite(event); }
    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) { events.handleBlockBurn(event); }

    @EventHandler
    public void onTarget(EntityTargetEvent event) {events.handleEntityTarget(event); }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event){ events.handlePlayerInteractEntityEvent(event); }

    @EventHandler
    public void onSpell(EntityPotionEffectEvent event) { events.handleSpellCast(event); }
    @EventHandler
    public void noHunger(FoodLevelChangeEvent event) { event.setCancelled(true); }
    @EventHandler
    public void dropItem(PlayerDropItemEvent event) {
        if (!event.getPlayer().hasPermission("kits.drop")) { event.setCancelled(true); }
    }
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        events.handleMoveEvent(event);

        Player player = event.getPlayer();
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
    }

}