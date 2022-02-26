package com.pingpenne.testa.datagen;
import com.pingpenne.testa.common.content.block.AllBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockModelProvider extends BlockStateProvider {
        public BlockModelProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
            super(gen, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
            simpleBlockAndItem(AllBlocks.METRONOME.get());
    }
}
