package com.ingot.IngotMod.main.item;

import com.ingot.IngotMod.main.IngotMod;
import com.ingot.IngotMod.main.item.custom.FuelItem;
import com.ingot.IngotMod.main.item.custom.MetalDetectorItem;
import com.ingot.IngotMod.main.item.custom.SakuramochiItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, IngotMod.MOD_ID);
    public static final RegistryObject<Item> CHERRYIRON_INGOT = ITEMS.register("cherryiron_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MELON_INGOT = ITEMS.register("melon_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HONEYCOMB_INGOT = ITEMS.register("honeycomb_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POISON_POTION_INGOT = ITEMS.register("poison_potion_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_INGOT = ITEMS.register("lapis_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_INGOT = ITEMS.register("amethyst_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(64)));
    public static final RegistryObject<Item> SAKURAMOCHI_INGOT = ITEMS.register("sakuramochi_ingot",
            () -> new SakuramochiItem(new Item.Properties().food(ModFoods.SAKURAMOCHI)));
    public static final RegistryObject<Item> FUEL_SAMPLE = ITEMS.register("fuel_sample",
            () -> new FuelItem(new Item.Properties(),400));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}