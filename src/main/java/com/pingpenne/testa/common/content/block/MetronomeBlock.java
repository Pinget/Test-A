package com.pingpenne.testa.common.content.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;

public class MetronomeBlock extends BaseEntityBlock {
    public MetronomeBlock(Properties p) {
        super(p);
        registerDefaultState(defaultBlockState().setValue(POWERED, false));
    }

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MetronomeBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(POWERED));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == AllBlockEntities.METRONOME_BLOCK_ENTITY.get() ? (world, pos, state1, t) -> MetronomeBlockEntity.tick(world, pos, state1, (MetronomeBlockEntity) t) : null;
    }

    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos pos2, boolean p_55671_) {
        if (!level.isClientSide) {
            boolean flagl = state.getValue(MetronomeBlock.POWERED);
            boolean flag = level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above());
            if (flag && !flagl) {
                level.scheduleTick(pos, this, 4);
                level.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(Boolean.TRUE)), 4);
            } else if (!flag && flagl) {
                level.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(Boolean.FALSE)),4);
            }
        }

    }
}




