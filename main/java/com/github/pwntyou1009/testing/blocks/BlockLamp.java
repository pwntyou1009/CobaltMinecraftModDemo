package com.github.pwntyou1009.testing.blocks;

import com.github.pwntyou1009.testing.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BlockLamp extends BlockGlowstone {
	
	String name = "glowstoneLamp";
	
	BlockLamp()
	{
		super(Material.glass);
		this.setBlockTextureName(Constants.MODID + ":" + this.name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(this, this.name);
		this.setLightLevel(1.0f);
		GameRegistry.addRecipe(new ItemStack(this,16), "R", "P", "C", 'R', new ItemStack(Blocks.redstone_lamp), 'P', new ItemStack(Blocks.glass), 'C', new ItemStack(Blocks.redstone_block));
		this.setBlockName(Constants.MODID + "_" + this.name);
	}

}
