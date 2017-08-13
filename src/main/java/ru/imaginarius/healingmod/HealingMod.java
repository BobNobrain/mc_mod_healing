package ru.imaginarius.healingmod;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = HealingMod.MODID, version = HealingMod.VERSION)
public class HealingMod
{
	public static final String MODID = "imaginariushealing";
	public static final String VERSION = "1.0";

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// some example code
		System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
		// blocks
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// recipes
	}
}
