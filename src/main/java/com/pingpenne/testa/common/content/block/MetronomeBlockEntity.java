package com.pingpenne.testa.common.content.block;

import com.pingpenne.testa.common.content.sound.AllSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.apache.logging.log4j.LogManager;

public class MetronomeBlockEntity extends BlockEntity{

    public MetronomeBlockEntity(BlockPos pos, BlockState state){
        super(AllBlockEntities.METRONOME_BLOCK_ENTITY.get(),pos,state);
    }




    private ItemStackHandler createHandler(){
        return new ItemStackHandler(1);
    }

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(()-> itemHandler);

    private int age = 0;

    public static void tick(Level world, BlockPos pos, BlockState state, MetronomeBlockEntity metronome) {
            metronome.age++;
            if(!world.isClientSide && state.getValue(MetronomeBlock.POWERED)){
                if(metronome.age%20 == 0 && metronome.age!=40){
                    //LogManager.getLogger().info("Shit");
                    world.playSound(null, pos,AllSounds.TICK.get(), SoundSource.BLOCKS, 0.1f, 1f); }
                else if (metronome.age == 40){
                    //LogManager.getLogger().info("Shit");
                    world.playSound(null, pos,AllSounds.TICK.get(), SoundSource.BLOCKS, 0.1f, 1.2f);
                    metronome.age = 0;}

            }
            //world.playSound(PlayerEntity player, BlockPos pos, SoundEvent sound, SoundCategory category, float volume, float pitch);
        }
    }
