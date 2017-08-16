package ru.imaginarius.healingmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.imaginarius.healingmod.HealingMod;

/**
 * Base class for non-empty injectors
 */
public class UseableInjector extends HealingItem
{
	public UseableInjector(String name, float restores)
	{
		super(name, restores);
	}

	@Override
	protected void onUse(ItemStack stack, World in, EntityPlayer player)
	{
		super.onUse(stack, in, player);
		if (!player.inventory.addItemStackToInventory(new ItemStack(HealingMod.EMPTY_INJECTOR, 1)))
			player.dropItem(HealingMod.EMPTY_INJECTOR, 1);

		player.inventory.markDirty();
		used = true;
	}
}
