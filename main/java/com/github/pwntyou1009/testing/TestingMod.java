package com.github.pwntyou1009.testing;

import com.github.pwntyou1009.testing.blocks.ModifiedBlocks;
import com.github.pwntyou1009.testing.items.ModifiedItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "testingmod", name = "Cobalt Shade Corporation Mod 0001 - Notch's Smiter", version = "0.5")

public class TestingMod {
	
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {    	 
    	    ModifiedItems.initialize();
    	    ModifiedBlocks.initialize();
    }
 
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
 
    }
 
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
 
    }
}
