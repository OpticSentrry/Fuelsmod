package com.cyntain.Fm;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.item.crafting.*;

import com.cyntain.Fm.Achivement.FmAchivement;
import com.cyntain.Fm.Block.BlockBeryllium;
import com.cyntain.Fm.Block.BlockBerylliumOre;
import com.cyntain.Fm.Block.BlockCopper;
import com.cyntain.Fm.Block.BlockCopperOre;
import com.cyntain.Fm.Block.BlockOsmium;
import com.cyntain.Fm.Block.BlockOsmiumOre;
import com.cyntain.Fm.Block.BlockZeoliteOre;
import com.cyntain.Fm.Block.ModBlock;
import com.cyntain.Fm.Block.WorldGenerator;
//import com.cyntain.Fm.Block.ModBlock;
import com.cyntain.Fm.Item.ModItem;
import com.cyntain.Fm.core.proxy.CommonProxy;
import com.cyntain.Fm.lib.BlockIDs;
import com.cyntain.Fm.lib.ModLoaded;
import com.cyntain.Fm.lib.Reference;
import com.cyntain.Fm.lib.Strings;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

/*            FuelsMod     
 * 
 * @Authors: Cyntain and Paronamixxe
 * 
 * FuelsMod
 * 
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 * @credit: Visual_Argonian, Pahimar and Plenty_of_Fish
 * */

@Mod(  modid = Reference.MOD_ID,
       name = Reference.MOD_NAME,
       version = Reference.VERSION_NUMBER)

@NetworkMod( clientSideRequired = true,
              serverSideRequired = false)



    public class FuelsMod {
    
        /* Block statements */         
            public static Block copperOre;
            public static Block osmiumOre;
            public static Block berylliumOre;
            public static Block zeoliteOre;
            public static Block copperBlock;
            public static Block osmiumBlock;
            public static Block berylliumBlock;
             
@Instance(Reference.MOD_ID)
                public static FuelsMod instance;
  
@SidedProxy(
            clientSide = Reference.CLIENT_PROXY_CLASS,
             serverSide = Reference.SERVER_PROXY_CLASS)
                public static CommonProxy proxy;
 
@PreInit
        public void preInit(FMLPreInitializationEvent event) {
        proxy.registerRenders();
            
            ModItem.init();
           ModLoaded.Mod_Loaded();                       
    }
@Init
    public void load(FMLInitializationEvent event) {
    ModLoaded.Mod_Loaded();
    FmAchivement.addAchievementLocalizations();
    GameRegistry.registerWorldGenerator(new WorldGenerator());
    
    /* Block statements: Copper Blocks */  
    copperOre = new BlockCopperOre(BlockIDs.COPPER_ORE_DEFAULT, Material.rock).setUnlocalizedName(Strings.COPPER_ORE);
    GameRegistry.registerBlock(copperOre, Reference.MOD_ID + copperOre.getUnlocalizedName2());
    LanguageRegistry.addName(copperOre, "Copper Ore");
    copperBlock = new BlockCopper(BlockIDs.COPPER_BLOCK_DEFAULT, Material.rock).setUnlocalizedName(Strings.COPPER_BLOCK);
    GameRegistry.registerBlock(copperBlock, Reference.MOD_ID + copperBlock.getUnlocalizedName2());
    LanguageRegistry.addName(copperBlock, "Block of Copper");
    
    /* Block statements: Osmium Blocks */
    osmiumOre = new BlockOsmiumOre(BlockIDs.OSMIUM_ORE_DEFAULT, Material.rock).setUnlocalizedName(Strings.OSMIUM_ORE);
    GameRegistry.registerBlock(osmiumOre, Reference.MOD_ID + osmiumOre.getUnlocalizedName2());
    LanguageRegistry.addName(osmiumOre, "Osmium Ore");
    osmiumBlock = new BlockOsmium(BlockIDs.OSMIUM_BLOCK_DEFAULT, Material.rock).setUnlocalizedName(Strings.OSMIUM_BLOCK);
    GameRegistry.registerBlock(osmiumBlock, Reference.MOD_ID + osmiumBlock.getUnlocalizedName2());
    LanguageRegistry.addName(osmiumBlock, "Block of Osmium");
    
    /* Block statements: Beryllium Blocks */
    berylliumOre = new BlockBerylliumOre(BlockIDs.BERYLLIUM_ORE_DEFAULT, Material.rock).setUnlocalizedName(Strings.BERYLLIUM_ORE);
    GameRegistry.registerBlock(berylliumOre, Reference.MOD_ID + berylliumOre.getUnlocalizedName2());
    LanguageRegistry.addName(berylliumOre, "Beryllium Ore");
    berylliumBlock = new BlockBeryllium(BlockIDs.BERYLLIUM_BLOCK_DEFAULT, Material.rock).setUnlocalizedName(Strings.BERYLLIUM_BLOCK);
    GameRegistry.registerBlock(berylliumBlock, Reference.MOD_ID + berylliumBlock.getUnlocalizedName2());
    LanguageRegistry.addName(berylliumBlock, "Block of Beryllium");
    
    /* Block statements: Zeolite Blocks */
    zeoliteOre = new BlockZeoliteOre(BlockIDs.ZEOLITE_ORE_DEFAULT, Material.rock).setUnlocalizedName(Strings.ZEOLITE_ORE);
    GameRegistry.registerBlock(zeoliteOre, Reference.MOD_ID + zeoliteOre.getUnlocalizedName2());
    LanguageRegistry.addName(zeoliteOre, "Zeolite Ore");
    
    //Recipes
    GameRegistry.addRecipe(new ItemStack(copperBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), ModItem.copperIngot);
    GameRegistry.addRecipe(new ItemStack(osmiumBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), ModItem.osmiumIngot);
    GameRegistry.addRecipe(new ItemStack(berylliumBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), ModItem.berylliumIngot);
    
    ModLoaded.Mod_Loaded();          //keep at the end of the load method shows if all blocks have been initialised 
    
    }

    }
