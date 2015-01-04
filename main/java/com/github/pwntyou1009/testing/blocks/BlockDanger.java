package com.github.pwntyou1009.testing.blocks;

import com.github.pwntyou1009.testing.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockStone;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class BlockDanger extends BlockStone {
	
	String name = "dangerBlock";
	
	BlockDanger()
	{
		super();
		this.setBlockTextureName(Constants.MODID + ":" + this.name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, this.name);
		GameRegistry.addRecipe(new ItemStack(this,2), "YB", "BY"
				  ,'Y', new ItemStack(Blocks.stained_hardened_clay,1,4), 'B', new ItemStack(Blocks.stained_hardened_clay,1,15));
		this.setBlockName(Constants.MODID + "_" + this.name);
	}

}
