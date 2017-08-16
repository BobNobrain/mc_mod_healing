package ru.imaginarius.healingmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import ru.imaginarius.healingmod.HealingMod;

/**
 * A base class for mod's food
 */
public abstract class BaseFoodItem extends ItemFood
{
	private PotionEffect[] effects;

	public BaseFoodItem(String name, int healAmount,
						float saturationModifier, boolean wolvesFavourite,
						PotionEffect... effects)
	{
		super(healAmount, saturationModifier, wolvesFavourite);
		this.setUnlocalizedName(name);
		this.setTextureName(HealingMod.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.tabFood);
		this.effects = effects;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);

		for (PotionEffect effect : effects)
		{
			if (!world.isRemote && effect != null && effect.getPotionID() > 0)
				player.addPotionEffect(
					new PotionEffect(effect.getPotionID(),
					effect.getDuration(),
					effect.getAmplifier(),
					effect.getIsAmbient())
				);
		}
	}
}
