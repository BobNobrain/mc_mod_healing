package ru.imaginarius.healingmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.imaginarius.healingmod.HealingMod;

/**
 * This class acts as a base for all mod items
 */
public abstract class BaseItem extends Item
{
	public BaseItem(String name, CreativeTabs tab, String textureName)
	{
		setUnlocalizedName(name);
		setCreativeTab(tab);
		setTextureName(HealingMod.MODID + ":" + textureName);
	}
	public BaseItem(String name, CreativeTabs tab) { this(name, tab, name); }

	public void register()
	{
		GameRegistry.registerItem(this, getUnlocalizedName(), HealingMod.MODID);
	}
}
