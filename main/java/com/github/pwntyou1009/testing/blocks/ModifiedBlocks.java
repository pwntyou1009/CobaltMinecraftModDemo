package com.github.pwntyou1009.testing.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ModifiedBlocks {
		
	public static Block blockDangerStone, blockLamp;
	
	public static void initialize()
	{
		blockDangerStone = new BlockDanger();
		blockLamp = new BlockLamp();
	}

}
