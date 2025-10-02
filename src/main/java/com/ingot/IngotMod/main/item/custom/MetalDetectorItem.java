package com.ingot.IngotMod.main.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i =0; i<=positionClicked.getY()+64;i++){
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.below(i),player,state.getBlock(),pContext);
                    foundBlock = true;
                }
            }
            if (!foundBlock) {
                player.sendSystemMessage(Component.translatable("item.ingotmod.metaldetectoritem.blocknotfound"));
            }
        }
        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block, UseOnContext pContext) {
        player.sendSystemMessage(Component.literal("Found"+ I18n.get(block.getDescriptionId())+ " at("+
                blockPos.getX()+", "+blockPos.getY()+", "+blockPos.getZ()+")"));
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),player1 -> player.broadcastBreakEvent(player.getUsedItemHand()));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE);
    }
}
