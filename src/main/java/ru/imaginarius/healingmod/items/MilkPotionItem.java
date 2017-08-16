package ru.imaginarius.healingmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import ru.imaginarius.healingmod.HealingMod;

/**
 * A bottle of milk
 */
public final class MilkPotionItem extends BaseFoodItem
{
	public MilkPotionItem()
	{
		super(
			"potion_milk",
			2,
			0.2F,
			false
		);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		if (!player.worldObj.isRemote)
		{
			player.removePotionEffect(Potion.confusion.id);
			player.removePotionEffect(Potion.poison.id);
			player.removePotionEffect(Potion.hunger.id);
			player.removePotionEffect(Potion.digSlowdown.id);
			player.removePotionEffect(Potion.digSpeed.id);
			player.removePotionEffect(Potion.moveSlowdown.id);
			player.removePotionEffect(Potion.moveSpeed.id);
			player.removePotionEffect(Potion.weakness.id);
			player.removePotionEffect(Potion.blindness.id);
			player.removePotionEffect(Potion.nightVision.id);
			player.removePotionEffect(Potion.regeneration.id);
			player.removePotionEffect(Potion.damageBoost.id);
		}
	}

	public void register()
	{
		GameRegistry.registerItem(this, getUnlocalizedName(), HealingMod.MODID);
	}
}
