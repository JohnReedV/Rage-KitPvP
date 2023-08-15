# Rage KitPvP

## Installation:
1. Download the `RageKitPvP.jar` file.
2. Place the jar file in your server's `plugins` directory.
3. Restart your server.

## Commands:

| Command        | Description                                 | Usage                    | Permission         |
| -------------- | ------------------------------------------- | ------------------------ | ------------------ |
| `/head`        | Gives the player their head or another's    | `/head [playerName]`     | `kits.head`        |
| `/resetstats`  | Reset certain stats for specified player    | `/resetstats playerName` | `kits.resetstats`  |
| `/spawn`       | Teleport sender/specified to world spawn    | `/spawn [playerName]`    | `kits.spawn`       |
| `/kits`        | Open specific inventory (with permission)   | N/A                      | `kits.open`        |
| `/setspawn`    | Set world spawn to current position         | N/A                      | `kits.setspawn`    |
| `/randomkit`   | Provide player with a random kit            | N/A                      | `kits.random`      |
| `/reloadstats` | Reload the statistics inventory             | N/A                      | `kits.reloadstats` |
| `/flex`        | Display player stats (kills, deaths, etc.)  | N/A                      | N/A                |
| `/ping`        | Display player's server ping                | N/A                      | N/A                |
| `/die`         | Kill player unless they're above 175 blocks | N/A                      | N/A                |

## Kits:

| Name      | Armor Items                                         | Additional Items                              |
| --------- | ---------------------------------------------------- | --------------------------------------------- |
| Chemist   | Chemist Head, Chest, Legs, Feed                     | chemW, pot1, pot2, pot6, pot3, pot4, pot5     |
| Doom      | Boots O' Doom                                       | Sword O' Doom, Stick O' Doom                  |
| Archer    | Archer Head, Frog Feet                              | Archer Bow, Archer Arrow                      |
| Pyro      | Helm of FLAMES, Chest of FLAMES, Legs of FLAMES, Boots of FLAMES | pyroSword, Enchanted Golden Apple |
| Ninja     | None                                                | invStick                                      |
| Tank      | Netherite Helmet, Chestplate, Leggings, Boots       | Netherite Sword                               |
| Outcast   | Iron Helmet, Chestplate, Leggings, Diamond Boots    | Python, Flashbang 3                           |
| Jockey    | Jockey Helmet, Chest, Leggings, Boots               | horseW, horseSpawn                            |
| Enderman  | Dragon Head, Diamond Chestplate, Leggings, Boots    | Netherite Sword, 192x Ender Pearls            |
| Cactus    | Cactus Head, Chest, Leg, Foot                       |                                               |
| Butcher   | Pig Head, Chest, Legs, Feet                         | PigAxe                                        |
| Crystal   | Crystal Hat, Crystal Chest                          | 64x End Crystals, 6x Chorus Fruit             |
| Terrorist | Leather Helmet, Chestplate, Leggings, Boots         | AK-47, Cocopops 5, Toaster                    |
| Warton    | Warden Elytra                                       | Warden Flint                                  |
| Aquaman   | Aqua Head, Aqua Foot                                | Aqua Trident, Aqua Heart                      |
| Sniper    | Sniper Head, Chest, Legs, Foots                     | Hunting, Airstrike                            |
| Ravager   | None                                                | Ravager Crossbow, Spawn Ravager, 128x Ravager Arrow |
| Bird      | Bird Wings                                          | Olympia, Airstrike, 64x Bird Fireworks        |

## Special Behaviors

### Ravager Spawn

- **Item Type**: Totem of Undying
- **Behavior**: When a player right-clicks with this item, a Ravager is spawned at the player's location, named after the player. This item is consumed upon use.

### Stick O' Doom

- **Item Type**: Stick
- **Behavior**: 
  - **Right Click Block**: Spawns three Wither Skeletons named "Skelly O' Doom!" near the player's target block. These skeletons have a glowing effect. This action has a 25-second cooldown.
  - **Left Click Air**: The player launches a fireball projectile.

### are eye pee (Trident)

- **Item Type**: Trident
- **Behavior**: When a player left-clicks while in water and this item is in hand, a lightning strike is called at the player's targeted block location. This action has a 5-second cooldown.

### Player Head Consumption

- **Item Type**: Player Head
- **Behavior**: When a player right-clicks with this item, it is consumed, and the player is given a Regeneration potion effect for 120 ticks (6 seconds) at level 2.

### Horse Summoning Stick

- **Item Type**: Stick
- **Behavior**: When a player right-clicks on a block with this item, a tamed horse named "Steed O' [player name]" is spawned with Diamond Horse Armor and a Saddle. This horse is invulnerable and has a Speed potion effect.

### Axe or Ottle ?

- **Item Type**: Heart of the Sea
- **Behavior**: Right-clicking on a block with this item spawns eight Drowned entities named after the player with a glowing effect. This item is consumed upon use.

### Compass Behavior

- **Item Type**: Compass
- **Behavior**: If the player's Y-coordinate is less than 175, the player is awarded a random kit.

### Special Boots

- **Boots O' Doom**: Grants the player a Jump Boost potion effect (level 14 for 200 ticks or 10 seconds).
- **Feet of the Knight**: Grants the player a Speed potion effect (level 2 for 1000 ticks or 50 seconds).

### Ninja Death Stick

- **Item Type**: Stick
- **Behavior**: Grants the player Invisibility (level 2 for 220 ticks or 11 seconds).

### Warden Summoning

- **Item Type**: Flint named "Guide O' Charles"
- **Behavior**: When a player with this item in hand attacks an entity, a Warden named "Charles => [player name]" is spawned. The Warden is initially not hostile to the player and becomes angry at the attacked entity.

### Entity Defense Mechanisms

- **cumsock**: If a player wears this chestplate, nearby players (within 1.5 blocks) are dealt 1.5 damage.
- **PissPants**: If a player wears these leggings, they receive a Hunger potion effect (level 3 for 600 ticks or 30 seconds) and a special chat message.

### Ravager Riding

- **Entity Type**: Ravager
- **Behavior**: Players can right-click on a Ravager entity named after themselves to mount and ride it.

### Entity Targeting and Damage Modifications

- Some spawned entities, based on their names and types, are prevented from targeting entities with matching names. 
- **Crystal Chest**: Damage modifications are in place for explosions if the player is wearing this chestplate, significantly reducing the damage dealt to 1.


## Rage PvP Features

### RageScoreboard

The RageScoreboard is your personal combat summary. It appears on the side of your screen and provides a live update of your combat stats:
- **KD Ratio:** Shows how many players you typically defeat before falling in battle yourself.
- **Kills:** Keeps track of how many players you have defeated.
- **Deaths:** Displays how many times you have been defeated.
- **Damage Dealt and Taken:** Provides insights into how much damage you are dishing out and how much you are enduring.

### StatisticsInventory

The StatisticsInventory is a special in-game menu where you can view the champions of the server:
- **KD Kings:** The players with the best kill-to-death ratios.
- **Top Killers:** The warriors who have defeated the most opponents.
- **Damage Dealers:** The players who have dealt the most damage to others.
- **Survivalists:** The players who have endured the most damage in battles.
These rankings are accessible through an in-game command and add a competitive edge to the game. Will you become the next PvP King?

### BroadCaster

The BroadCaster is our way of keeping you in the loop. It sends out server-wide messages to make sure you don’t miss out on important information:
- **Discord Invites:** Get invited to our community Discord server where you can chat with other players, get help, and stay informed.
- **Server IP Updates:** Be the first to know if our server address changes.
- **Special Promotions:** Don’t miss out when VIP kits are free or when special events are happening on the server.

---
