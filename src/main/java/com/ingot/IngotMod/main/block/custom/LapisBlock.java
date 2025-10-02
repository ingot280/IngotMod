package com.ingot.IngotMod.main.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class LapisBlock extends Block {
    public LapisBlock(Properties pProperties) {
        super(pProperties);
    }
//        float enchatPowerBonus = 6f;

    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader level, BlockPos pos) {
//        return super.getEnchantPowerBonus(state, level, pos);
//        return super.getEnchantPowerBonus(state, level, pos);
        return 3f;
    }
}
