package ragekitpvp.ragekitpvp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import static org.bukkit.Bukkit.getServer;

public class Kits {
    Items items = new Items();

    public void getChemist(Player player) {
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

    public void getDoom(Player player) {
        player.getInventory().clear();
        player.getInventory().addItem(items.getDoom());
        player.getInventory().addItem(items.doomStick());
        player.getInventory().setBoots(items.doomBoots());
        player.closeInventory();
    }

    public void getKnight (Player player) {
        player.getInventory().clear();
        player.getInventory().setBoots(items.knightBoots());
        player.getInventory().setLeggings(items.knightLegs());
        player.getInventory().setChestplate(items.knightChest());
        player.getInventory().setHelmet(items.knightHead());
        player.getInventory().setItemInMainHand(items.knightSword());
        player.getInventory().setItemInOffHand(items.knightSheild());
        player.closeInventory();
    }

    public void getArcher(Player player) {
        player.getInventory().clear();
        player.getInventory().addItem(items.archerBow());
        player.getInventory().addItem(items.archerArrow());
        player.getInventory().setBoots(items.archerFoot());
        player.getInventory().setHelmet(items.archerHead());
        player.closeInventory();
    }

    public void getPyro(Player player) {
        player.getInventory().clear();
        player.getInventory().addItem(items.pyroSword());
        player.getInventory().addItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
        player.getInventory().setBoots(items.pyroBoots());
        player.getInventory().setLeggings(items.pyroLegs());
        player.getInventory().setChestplate(items.pyroChest());
        player.getInventory().setHelmet(items.pyroHelm());
        player.closeInventory();
    }

    public void getNinja(Player player) {
        player.getInventory().clear();
        player.getInventory().addItem(items.invStick());
        player.closeInventory();
    }

    public void getTank(Player player) {
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

    public void getOutcast(Player player) {
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

    public void getJockey(Player player) {
        if (2 > 1) {
            player.getInventory().clear();
            player.getInventory().setBoots(items.horseFeet());
            player.getInventory().setLeggings(items.horseLegs());
            player.getInventory().setChestplate(items.horseChest());
            player.getInventory().setHelmet(items.horseHead());
            player.getInventory().addItem(items.horseW());
            player.getInventory().addItem(items.horseSpawn());
            player.closeInventory();
        } else {
            player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                    + "" + ChatColor.GREEN + "VIP");
        }
    }

    public void getEnderman(Player player) {
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

    public void getCactus(Player player) {
        if (2 > 1) {
            player.getInventory().clear();
            player.getEquipment().setHelmet(items.cactusHead());
            player.getEquipment().setChestplate(items.cactusChest());
            player.getEquipment().setLeggings(items.cactusLeg());
            player.getEquipment().setBoots(items.cactusFoot());
            player.closeInventory();
        } else {
            player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                    + "" + ChatColor.GREEN + "VIP");
        }
    }

    public void getTerrorist(Player player) {
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
        } else {
            player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                    + "" + ChatColor.GREEN + "VIP");
        }
    }

    public void getWarton(Player player) {
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

    public void getAquaman(Player player) {
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

    public void getSniper(Player player) {
        if (2 > 1) {
            player.getInventory().clear();
            player.getInventory().setHelmet(items.sniperHead());
            player.getInventory().setBoots(items.sniperFoots());
            player.getInventory().setLeggings(items.sniperLegs());
            player.getInventory().setChestplate(items.sniperChest());
            getServer().dispatchCommand(getServer().getConsoleSender(),
                    "shot give " + player.getName() + " hunting");
            getServer().dispatchCommand(getServer().getConsoleSender(),
                    "shot give " + player.getName() + " airstrike");
            player.closeInventory();

        } else {
            player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                    + "" + ChatColor.GREEN + "VIP");
        }
    }

    public void getRavager(Player player) {
        if (2 > 1) {
            player.getInventory().clear();
            player.getInventory().addItem(items.ravagerCrossbow());
            player.getInventory().addItem(items.spawnRavager());
            for (int i = 0; i < 128; i++){ player.getInventory().addItem(items.ravagerArrow()); }
            player.closeInventory();

        } else {
            player.sendMessage(ChatColor.GOLD + "You are not " + ChatColor.UNDERLINE + "" + ChatColor.BOLD
                    + "" + ChatColor.GREEN + "VIP");
        }
    }

    public String getRandomKit(Player player) {
        String[] Possibilites = {"Chemist", "Doom", "Knight", "Archer", "Pyro", "Ninja", "Tank", "Outcast",
                 "Jockey", "Enderman", "Cactus", "Terrorist", "Warton", "Aquaman", "Sniper", "Ravager"};
        String selection = Possibilites[(int) Math.round(((Math.random() * (Possibilites.length)) + 0))];

        if (selection.equalsIgnoreCase("chemist")) { this.getChemist(player); }
        if (selection.equalsIgnoreCase("doom")) { this.getDoom(player); }
        if (selection.equalsIgnoreCase("knight")) { this.getKnight(player); }
        if (selection.equalsIgnoreCase("archer")) { this.getArcher(player); }
        if (selection.equalsIgnoreCase("pyro")) { this.getPyro(player); }
        if (selection.equalsIgnoreCase("ninja")) { this.getNinja(player); }
        if (selection.equalsIgnoreCase("tank")) { this.getTank(player); }
        if (selection.equalsIgnoreCase("outcast")) { this.getOutcast(player); }
        if (selection.equalsIgnoreCase("jockey")) { this.getJockey(player); }
        if (selection.equalsIgnoreCase("enderman")) { this.getEnderman(player); }
        if (selection.equalsIgnoreCase("cactus")) { this.getCactus(player); }
        if (selection.equalsIgnoreCase("terrorist")) { this.getTerrorist(player); }
        if (selection.equalsIgnoreCase("warton")) { this.getWarton(player); }
        if (selection.equalsIgnoreCase("aquaman")) { this.getAquaman(player); }
        if (selection.equalsIgnoreCase("sniper")) { this.getSniper(player); }
        if (selection.equalsIgnoreCase("Ravager")) { this.getRavager(player); }

        return selection;
    }
}
