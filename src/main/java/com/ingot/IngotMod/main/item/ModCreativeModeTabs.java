package com.ingot.IngotMod.main.item;

import com.ingot.IngotMod.main.IngotMod;
import com.ingot.IngotMod.main.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IngotMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INGOT_TAB = CREATIVE_MODE_TABS.register("ingot_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.MELON_INGOT.get()))
                    .title(Component.translatable("creativetab.ingot_tab"))
                    .displayItems((pParameters,pOutput) -> {
//                        Ingots
                        pOutput.accept(ModItems.CHERRYIRON_INGOT.get());
                        pOutput.accept(ModItems.MELON_INGOT.get());
                        pOutput.accept(ModItems.HONEYCOMB_INGOT.get());
                        pOutput.accept(ModItems.POISON_POTION_INGOT.get());
                        pOutput.accept(ModItems.LAPIS_INGOT.get());
//                        Vanilla Items
                        pOutput.accept(Items.GOLD_INGOT);
                        pOutput.accept(Items.IRON_INGOT);
                        pOutput.accept(Items.COPPER_INGOT);
                        pOutput.accept(Items.NETHERITE_INGOT);
//                        Blocks
                        pOutput.accept(ModBlocks.CHERRYIRON_BLOCK.get());
                        pOutput.accept(ModBlocks.MELON_BLOCK.get());
                        pOutput.accept(ModBlocks.HONEYCOMB_INGOT_BLOCK.get());
                        pOutput.accept(ModBlocks.POISON_POTION_BLOCK.get());
                        pOutput.accept(ModBlocks.LAPIS_INGOT_BLOCK.get());
//                        Other
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
