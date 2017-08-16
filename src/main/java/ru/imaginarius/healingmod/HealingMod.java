package ru.imaginarius.healingmod;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import ru.imaginarius.healingmod.items.*;

@Mod(modid = HealingMod.MODID, version = HealingMod.VERSION)
public class HealingMod
{
	public static final String MODID = "imaginariushealing";
	public static final String VERSION = "1.0";

	// items
	public static final EmptyInjector EMPTY_INJECTOR = new EmptyInjector();
	public static final RedInjector RED_INJECTOR = new RedInjector();
	public static final GreenInjector GREEN_INJECTOR = new GreenInjector();
	public static final BlueInjector BLUE_INJECTOR = new BlueInjector();

	public static final MedkitItem MEDKIT = new MedkitItem();
	public static final BondageItem BONDAGE = new BondageItem();

	public static final MilkPotionItem MILK_POTION = new MilkPotionItem();

	private void addItems()
	{
		EMPTY_INJECTOR.register();
		RED_INJECTOR.register();
		GREEN_INJECTOR.register();
		BLUE_INJECTOR.register();
		MEDKIT.register();
		BONDAGE.register();
		MILK_POTION.register();
	}

	private void addRecipes()
	{
		GameRegistry.addRecipe(
			new ItemStack(BONDAGE, 4),
			"12",
			"21",
			'1', Items.string,
			'2', new ItemStack(Blocks.wool)
		);

		GameRegistry.addShapelessRecipe(
			new ItemStack(EMPTY_INJECTOR, 1),
			Items.iron_ingot, new ItemStack(Blocks.glass)
		);

		GameRegistry.addRecipe(
			new ItemStack(MEDKIT),
			"bbb",
			"123",
			"mmm",
			'b', BONDAGE,
			'1', RED_INJECTOR,
			'2', GREEN_INJECTOR,
			'3', BLUE_INJECTOR,
			'm', Items.iron_ingot
		);

		GameRegistry.addShapelessRecipe(
			new ItemStack(RED_INJECTOR),
			EMPTY_INJECTOR, Items.redstone, new ItemStack(Items.dye, 1, 1), Items.sugar
		);

		GameRegistry.addShapelessRecipe(
			new ItemStack(GREEN_INJECTOR),
			EMPTY_INJECTOR, Items.rotten_flesh, new ItemStack(Items.dye, 1, 15),
			new ItemStack(Blocks.brown_mushroom)
		);

		GameRegistry.addShapelessRecipe(
			new ItemStack(BLUE_INJECTOR),
			EMPTY_INJECTOR, Items.glowstone_dust, new ItemStack(Items.dye, 1, 4), Items.redstone
		);


		GameRegistry.addSmelting(Items.golden_pickaxe, new ItemStack(Items.gold_ingot, 2), 0);
		GameRegistry.addSmelting(Items.golden_sword, new ItemStack(Items.gold_ingot, 1), 0);
	}

	private void addBlocks()
	{

	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// some example code
//		System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
		addBlocks();
		addItems();
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		addRecipes();
	}
}
