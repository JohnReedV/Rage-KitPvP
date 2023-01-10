package ragekitpvp.ragekitpvp;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.*;
import java.util.List;

public class kitInv {
    public Inventory inv;

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
        inv.setItem(13, ak);

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

        ItemStack warden = new ItemStack(Material.SCULK_SENSOR);
        ItemMeta meta15 = warden.getItemMeta();
        meta15.setDisplayName(ChatColor.DARK_BLUE + "Charles");
        List<String> lore15 = new ArrayList<String>();
        lore15.add("");
        lore15.add(ChatColor.ITALIC + "Do you have the Charles?");
        lore15.add(ChatColor.ITALIC + "Or does Charles have you?!?");
        meta15.setLore(lore15);
        meta15.addEnchant(Enchantment.LURE,1,true);
        meta15.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta15.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        warden.setItemMeta(meta15);
        inv.setItem(14, warden);

        ItemStack trident = new ItemStack(Material.TRIDENT);
        ItemMeta meta16 = trident.getItemMeta();
        meta16.setDisplayName(ChatColor.AQUA + "Aqua Man");
        List<String> lore16 = new ArrayList<String>();
        lore16.add("");
        lore16.add(ChatColor.ITALIC + "swim");
        lore16.add(ChatColor.ITALIC + "strike");
        lore16.add(ChatColor.ITALIC + "sleep");
        lore16.add(ChatColor.ITALIC + "repeat >:)");
        meta16.setLore(lore16);
        meta16.addEnchant(Enchantment.LURE,1,true);
        meta16.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta16.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        trident.setItemMeta(meta16);
        inv.setItem(15, trident);
    }
    
}
