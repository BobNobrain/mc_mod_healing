package ru.imaginarius.healingmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * A base class for all healing items
 */
public class HealingItem extends BaseItem
{
	protected float restoresHP;
	protected int[] removedEffects;

	HealingItem(String name, float restores)
	{
		super(name, CreativeTabs.tabFood);
		restoresHP = restores;
		removedEffects = null;
	}

	protected boolean used = false;
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (!player.worldObj.isRemote)
		{
			onUse(stack, world, player);
			if (used)
			{
				--stack.stackSize;
				used = false;
			}
		}
		return super.onItemRightClick(stack, world, player);
	}

	protected void onUse(ItemStack stack, World in, EntityPlayer player)
	{
		if (player.getHealth() < player.getMaxHealth())
		{
			player.heal(restoresHP);
			if (removedEffects != null)
			{
				for (int effect: removedEffects)
					player.removePotionEffect(effect);
			}
			used = true;
		}
	}
}
