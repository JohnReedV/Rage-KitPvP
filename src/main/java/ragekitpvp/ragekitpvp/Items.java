package ragekitpvp.ragekitpvp;

import org.bukkit.Color;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;
import java.util.List;

public class Items {
    
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
        meta.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
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
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        compass.setItemMeta(meta);

        return compass;
    }

    public ItemStack pissPants() {
        ItemStack pant = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta meta = pant.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "PissPants");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "" + ChatColor.GREEN + "These pants have been PISSED");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        pant.setItemMeta(meta);

        return pant;
    }

    public ItemStack wardenFlint() {
        ItemStack flint = new ItemStack(Material.FLINT);
        ItemMeta meta = flint.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_BLUE + "Guide O' Charles");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_BLUE + "Poor Charles is blind :(");
        lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_BLUE + "Please guide Charles with this tool");
        lore.add(ChatColor.ITALIC + "" + ChatColor.DARK_BLUE + "Charles behaves " + ChatColor.RESET + ChatColor.MAGIC +
                "jdng4e" + ChatColor.RESET + ChatColor.ITALIC + ChatColor.DARK_BLUE +
                " twords the one who holds this guide");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        flint.setItemMeta(meta);

        return flint;
    }

    public  ItemStack wardenElytra() {
        ItemStack eye = new ItemStack(Material.ELYTRA);
        ItemMeta meta = eye.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_BLUE + "GO CRAZY HUNNY," +
                " GO CRAY CRAY LIKE IT YO LASt EASTER SUNDAY!!!");
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        eye.setItemMeta(meta);

        return eye;
    }

    public ItemStack cactusHead(){
        ItemStack head =  new ItemStack((Material.LEATHER_HELMET));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(0, 255, 0));
        meta.setDisplayName(ChatColor.DARK_GREEN + "cumsock");
        meta.addEnchant(Enchantment.THORNS, 51, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack cactusLeg(){
        ItemStack head =  new ItemStack((Material.LEATHER_LEGGINGS));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(0, 255, 0));
        meta.setDisplayName(ChatColor.DARK_GREEN + "cumsock");
        meta.addEnchant(Enchantment.THORNS, 51, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack cactusChest(){
        ItemStack head =  new ItemStack((Material.LEATHER_CHESTPLATE));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(0, 255, 0));
        meta.setDisplayName(ChatColor.DARK_GREEN + "cumsock");
        meta.addEnchant(Enchantment.THORNS, 51, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack cactusFoot(){
        ItemStack head =  new ItemStack((Material.LEATHER_BOOTS));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(0, 255, 0));
        meta.setDisplayName(ChatColor.DARK_GREEN + "cumsock");
        meta.addEnchant(Enchantment.THORNS, 51, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack aquaTrident() {
        ItemStack trid = new ItemStack(Material.TRIDENT);
        ItemMeta meta = trid.getItemMeta();
        meta.setDisplayName(ChatColor.BOLD + "" + ChatColor.AQUA + "are eye pee");
        meta.addEnchant(Enchantment.RIPTIDE, 4, true);
        meta.addEnchant(Enchantment.CHANNELING, 1, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.ITALIC + "" + ChatColor.AQUA + "");
        lore.add(ChatColor.ITALIC + "" + ChatColor.AQUA + "Left click for lightning");
        lore.add(ChatColor.ITALIC + "" + ChatColor.AQUA + "only in water");
        lore.add(ChatColor.ITALIC + "" + ChatColor.AQUA + "5 second cool down");
        meta.setLore(lore);
        trid.setItemMeta(meta);

        return trid;
    }

    public ItemStack aquaFoot(){
        ItemStack head =  new ItemStack((Material.LEATHER_BOOTS));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(0, 0, 255));
        meta.setDisplayName(ChatColor.AQUA + "Boot O' Pissbiden");
        meta.addEnchant(Enchantment.DEPTH_STRIDER, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack aquaHead(){
        ItemStack head =  new ItemStack((Material.LEATHER_HELMET));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(0, 0, 255));
        meta.setDisplayName(ChatColor.AQUA + "Head O' Pissbiden");
        meta.addEnchant(Enchantment.OXYGEN, 10, true);
        meta.addEnchant(Enchantment.WATER_WORKER, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack aquaHeart() {
        ItemStack stick = new ItemStack(Material.HEART_OF_THE_SEA);
        ItemMeta meta = stick.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Axe or Ottle ?");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.DARK_PURPLE + "right click release the manders");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        stick.setItemMeta(meta);

        return stick;
    }

    public ItemStack playerHead(Player player) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta)head.getItemMeta();
        meta.setOwner(player.getDisplayName());
        meta.setDisplayName(ChatColor.GREEN + player.getDisplayName() + "s" + ChatColor.AQUA + " head");
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack sniperHead(){
        ItemStack head =  new ItemStack((Material.LEATHER_HELMET));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(255, 255, 255));
        meta.setDisplayName(ChatColor.DARK_GREEN + "Sniper Head");
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack sniperChest(){
        ItemStack head =  new ItemStack((Material.LEATHER_CHESTPLATE));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(255, 255, 255));
        meta.setDisplayName(ChatColor.DARK_GREEN + "Sniper Chest");
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack sniperLegs(){
        ItemStack head =  new ItemStack((Material.LEATHER_LEGGINGS));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(255, 255, 255));
        meta.setDisplayName(ChatColor.DARK_GREEN + "Sniper Legs");
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }

    public ItemStack sniperFoots(){
        ItemStack head =  new ItemStack((Material.LEATHER_BOOTS));
        LeatherArmorMeta meta = (LeatherArmorMeta) head.getItemMeta();
        meta.setColor(Color.fromRGB(255, 255, 255));
        meta.setDisplayName(ChatColor.DARK_GREEN + "Sniper Foots");
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);
        head.setItemMeta(meta);

        return head;
    }
}
