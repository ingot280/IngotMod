package com.ingot.IngotMod.main;

import com.ingot.IngotMod.main.block.ModBlocks;
import com.ingot.IngotMod.main.item.ModCreativeModeTabs;
import com.ingot.IngotMod.main.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ingotmod")
public class IngotMod {
    public static final String MOD_ID = "ingotmod";

    public IngotMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        
    }
}
