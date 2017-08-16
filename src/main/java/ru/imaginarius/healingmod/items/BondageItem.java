package ru.imaginarius.healingmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Bondage item
 */
public class BondageItem extends HealingItem
{
	public BondageItem()
	{
		super("bondage", 2);
	}

	@Override
	protected void onUse(ItemStack stack, World in, EntityPlayer player)
	{
		super.onUse(stack, in, player);
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 1));
	}
}
