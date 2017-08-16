package ru.imaginarius.healingmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * A blue injector item
 */
public class BlueInjector extends UseableInjector
{
	public BlueInjector()
	{
		super("injector_blue", 3F);
		this.removedEffects = new int[]
		{
			Potion.weakness.getId(),
			Potion.moveSlowdown.getId(),
			Potion.digSlowdown.getId()
		};
	}

	protected void onUse(ItemStack stack, World in, EntityPlayer player)
	{
		super.onUse(stack, in, player);
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20 * 3));
		player.addPotionEffect(new PotionEffect(Potion.digSpeed.getId(), 20 * 8));
	}
}
