package ru.imaginarius.healingmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Red injector
 */
public final class RedInjector extends UseableInjector
{
	public RedInjector()
	{
		super("injector_red", 4);
		this.removedEffects = new int[]
		{
			Potion.poison.getId(),
			Potion.blindness.getId(),
			Potion.wither.getId()
		};
	}

	@Override
	protected void onUse(ItemStack stack, World in, EntityPlayer player)
	{
		super.onUse(stack, in, player);
		player.addPotionEffect(new PotionEffect(Potion.heal.getId(), 20 * 2));
	}
}
