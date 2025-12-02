package com.ingot.IngotMod.main.block;

import com.ingot.IngotMod.main.IngotMod;
import com.ingot.IngotMod.main.block.custom.LapisBlock;
import com.ingot.IngotMod.main.block.custom.PoisonBlock;
import com.ingot.IngotMod.main.block.custom.SoundBlock;
import com.ingot.IngotMod.main.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block>BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, IngotMod.MOD_ID);

    public static final RegistryObject<Block> CHERRYIRON_BLOCK = registerBlock("cherryiron_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.CHERRY_WOOD).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MELON_BLOCK = registerBlock("melon_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOD).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AMETHYST_INGOT_BLOCK = registerBlock("amethyst_ingot_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DIAMOND_INGOT_BLOCK = registerBlock("diamond_ingot_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HONEYCOMB_INGOT_BLOCK = registerBlock("honeycomb_ingot_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.HONEYCOMB_BLOCK)));
    public static final RegistryObject<Block> POISON_POTION_BLOCK = registerBlock("poison_potion_block",
            ()-> new PoisonBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> LAPIS_INGOT_BLOCK = registerBlock("lapis_ingot_block",
            ()-> new LapisBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            ()-> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.LAPIS_BLOCK).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EXAMPLE_ORE = registerBlock("example_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;

    }


    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
            return ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
