package ru.imaginarius.healingmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * A big medkit
 */
public class MedkitItem extends HealingItem
{
	public MedkitItem()
	{
		super("medkit_big", 10F);
		this.removedEffects = new int[]
		{
			Potion.poison.getId(),
			Potion.blindness.getId(),
			Potion.wither.getId(),
			Potion.weakness.getId(),
			Potion.moveSlowdown.getId(),
			Potion.digSlowdown.getId()
		};
	}

	@Override
	protected void onUse(ItemStack stack, World in, EntityPlayer player)
	{
		super.onUse(stack, in, player);
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3 * 20));
		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 1 * 20));
	}
}
