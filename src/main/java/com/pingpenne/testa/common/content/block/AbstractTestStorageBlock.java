package com.pingpenne.testa.common.content.block;

import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import java.util.function.Supplier;

public abstract class AbstractTestStorageBlock <E extends BlockEntity> extends BaseEntityBlock {
    protected final Supplier<BlockEntityType<? extends E>> blockEntityType;
    protected AbstractTestStorageBlock(Properties p_48677_, Supplier<BlockEntityType<? extends E>> supplier) {
        super(p_48677_);
        this.blockEntityType = supplier;
    }
}
