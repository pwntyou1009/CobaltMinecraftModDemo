package com.github.pwntyou1009.testing.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ModifiedItems {
		
	public static Item testNotchSmiter;
	
	public static void initialize()
	{
		testNotchSmiter = new ItemNotchSmiter();
	}

}
