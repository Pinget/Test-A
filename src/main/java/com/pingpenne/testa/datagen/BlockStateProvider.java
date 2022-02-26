package com.pingpenne.testa.datagen;

import com.pingpenne.testa.TestA;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public abstract class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {

    public BlockStateProvider(net.minecraft.data.DataGenerator gen, ExistingFileHelper exFileHelper){
        super(gen,TestA.MOD_ID,exFileHelper);
    }

    //@Override
    //protected void registerStatesAndModels() {
    //}

    protected void simpleBlockAndItem(Block block){
        var model = cubeAll(block);
        simpleBlock(block, model);
        simpleBlockItem(block, model);
    }
}
