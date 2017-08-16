package ru.imaginarius.healingmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;

/**
 * The green injector item
 */
public final class GreenInjector extends UseableInjector
{
	public GreenInjector()
	{
		super("injector_green", 3);
		this.removedEffects = new int[]
		{
			Potion.poison.getId(),
			Potion.blindness.getId()
		};
	}

	@Override
	protected void onUse(ItemStack stack, World in, EntityPlayer player)
	{
		super.onUse(stack, in, player);
		player.addPotionEffect(new PotionEffect(Potion.hunger.getId(), 20 * 3));
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 20 * 8));
		player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 20 * 8));

		// why not?
		player.jump();

		FoodStats food = player.getFoodStats();
		food.setFoodLevel(food.getFoodLevel());
	}
}
