package com.github.pwntyou1009.testing.items;

import org.lwjgl.input.Keyboard;

import com.github.pwntyou1009.testing.entities.EntityLassaArrow;
import com.github.pwntyou1009.testing.entities.EntityNotchArrow;
import com.github.pwntyou1009.testing.entities.EntityNotchLassaArrow;
import com.github.pwntyou1009.testing.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemNotchSmiter extends ItemBow {
	
    public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;	
	String name = "notchsmiter";
	
	@SideOnly(Side.CLIENT)
	private IIcon[] Texture = new IIcon[4];
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)

	{

	             itemIcon = iconRegister.registerIcon(Constants.MODID + ":" + this.name + "_standby");
	             for (int N = 0; N < 3; N++)
	             {
	                     this.Texture[N] = iconRegister.registerIcon(Constants.MODID + ":" + this.name + "_pulling_" + N);

	             }
	}
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
	             if(player.getItemInUse() == null) return this.itemIcon;
	             int Pulling = stack.getMaxItemUseDuration() - useRemaining;
	             if (Pulling >= 18)
	             {
	                     return Texture[2];
	             }
	             else if (Pulling > 13)
	             {
	                     return Texture[1];
	             }
	             else if (Pulling > 0)
	             {
	                     return Texture[0];
	             }        
	             return itemIcon;
	}

	public ItemNotchSmiter() {
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName(Constants.MODID + "_" + name);
		this.setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
	}
	
    public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
    {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;

        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = p_77615_3_.capabilities.isCreativeMode;

        if (flag || p_77615_3_.inventory.hasItem(Items.arrow))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityNotchArrow(p_77615_2_, p_77615_3_, f * 2.0F);
            if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)&&!Keyboard.isKeyDown(Keyboard.KEY_LMETA))
            {
            entityarrow = new EntityLassaArrow(p_77615_2_, p_77615_3_, f * 2.0F);
            }
            if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL))
            {
            entityarrow = new EntityNotchLassaArrow(p_77615_2_, p_77615_3_, f * 2.0F);
            }
            
            
            
            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            p_77615_1_.damageItem(1, p_77615_3_);
            p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (!p_77615_2_.isRemote)
            {
                p_77615_2_.spawnEntityInWorld(entityarrow);
            }
        }
    }

    /**
     * used to cycle through icons based on their used duration, i.e. for the bow
     */
    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int p_94599_1_)
    {
        return this.iconArray[p_94599_1_];
    }
}
