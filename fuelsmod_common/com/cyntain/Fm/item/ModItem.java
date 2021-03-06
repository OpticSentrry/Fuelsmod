
package com.cyntain.Fm.item;


import com.cyntain.Fm.lib.ItemIDs;

import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;




public class ModItem {

    /* Mod item instances */
    public static Item oreChunks;
    public static Item copperIngot;
    public static Item ClusterCopper;
    public static Item osmiumIngot;
    public static Item osmiumGrate;
    public static Item berylliumIngot;
    public static Item clusterBeryllium;
    public static Item zeoliteDust;
    public static Item zeoliteDustVial;
    public static Item zeoliteDustDyed;
    public static Item emptyVial;
    public static Item compounds;
    public static Item boiler;

    public static void init() {

        /* Initialise each mod item individually */

        // COPPER ITEMs
        copperIngot = new ItemCopperIngot(ItemIDs.COPPER_INGOT);
        ClusterCopper = new ItemClusterCopper(ItemIDs.COPPER_CLUSTER);

        // OSMIUM ITEMs
        osmiumIngot = new ItemOsmiumIngot(ItemIDs.OSMIUM_INGOT);
        osmiumGrate = new ItemOsmiumGrate(ItemIDs.OSMIUM_GRATE);

        // BERYLLIUM ITEMs
        berylliumIngot = new ItemBerylliumIngot(ItemIDs.BERYLLIUM_INGOT);
        clusterBeryllium = new ItemClusterBeryllium(ItemIDs.BERYLLIUM_CLUSTER);

        // ZEOLITE ITEMs
        zeoliteDust = new ItemZeoliteDust(ItemIDs.ZEOLITE_DUST);
        zeoliteDustVial = new ItemZeoliteVial(ItemIDs.ZEOLITE_DUST_VIAL);
        zeoliteDustDyed = new ItemZeoliteDyed(ItemIDs.ZEOLITE_DYED);

        // OTHER ITEMs
        emptyVial = new ItemEmptyVial(ItemIDs.EMPTY_VIAL);
        compounds = new ItemCompounds(ItemIDs.COMPOUND);
        boiler = new ItemBoiler(ItemIDs.BOILER_DEFAULT);
        oreChunks = new ItemOreChunks(ItemIDs.ORE_CHUNK);

        /* Register + Initialize Smelting Recipes */

        GameRegistry.addSmelting(ModItem.ClusterCopper.itemID, new ItemStack(
                copperIngot, 9), 10.0f);
        GameRegistry.addSmelting(ModItem.clusterBeryllium.itemID,
                new ItemStack(berylliumIngot, 9), 10.0f);

        /* Shaped Crafting Recipe */

        GameRegistry.addRecipe(new ItemStack(ModItem.osmiumGrate, 4), "WXW",
                "XXX", "WXW", Character.valueOf('W'), Item.ingotIron,
                Character.valueOf('X'), ModItem.osmiumIngot);
        GameRegistry.addRecipe(new ItemStack(ModItem.emptyVial, 1), "X X",
                "X X", " X ", Character.valueOf('X'), Block.glass);
        GameRegistry.addRecipe(new ItemStack(ModItem.zeoliteDustVial, 1),
                "XXX", "XYX", "XXX", Character.valueOf('X'),
                ModItem.zeoliteDust, Character.valueOf('Y'), ModItem.emptyVial);
        GameRegistry.addRecipe(new ItemStack(ModItem.zeoliteDust, 8), "X",
                Character.valueOf('X'), ModItem.zeoliteDustVial);

        ///////////////////////
       //  ALCHEMY RECIPES  //
      ///////////////////////
        
        /* Compound recipes */
        GameRegistry.addRecipe(new ItemStack(ModItem.compounds, 1, 0), "RRR",
                "RZR", "GGG", Character.valueOf('R'), Item.redstone,
                Character.valueOf('Z'), ModItem.zeoliteDust,
                Character.valueOf('G'), Item.lightStoneDust);
        GameRegistry.addRecipe(new ItemStack(ModItem.compounds, 1, 1), "XXX",
                "XZX", "GGG", Character.valueOf('X'), Item.emerald,
                Character.valueOf('Z'), ModItem.zeoliteDust,
                Character.valueOf('G'), Item.lightStoneDust);
        GameRegistry.addRecipe(new ItemStack(ModItem.compounds, 1, 2), "YYY",
                "YZY", "GGG", Character.valueOf('Y'), new ItemStack(
                        Item.dyePowder, 1, 11), Character.valueOf('Z'),
                ModItem.zeoliteDust, Character.valueOf('G'),
                Item.lightStoneDust);
        GameRegistry.addRecipe(new ItemStack(ModItem.compounds, 1, 3), "LLL",
                "LZL", "GGG", Character.valueOf('L'), new ItemStack(
                        Item.dyePowder, 1, 4), Character.valueOf('Z'),
                ModItem.zeoliteDust, Character.valueOf('G'),
                Item.lightStoneDust);

        /* Dyed Zeolite dust recipes, Shapeless recipes */
        GameRegistry.addShapelessRecipe(new ItemStack(ModItem.zeoliteDustDyed,
                1, 0), ModItem.zeoliteDust, new ItemStack(ModItem.compounds, 1,
                0));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItem.zeoliteDustDyed,
                1, 1), ModItem.zeoliteDust, new ItemStack(ModItem.compounds, 1,
                1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItem.zeoliteDustDyed,
                1, 2), ModItem.zeoliteDust, new ItemStack(ModItem.compounds, 1,
                2));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItem.zeoliteDustDyed,
                1, 3), ModItem.zeoliteDust, new ItemStack(ModItem.compounds, 1,
                3));
    }
}