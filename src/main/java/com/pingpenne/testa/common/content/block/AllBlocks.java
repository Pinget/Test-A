package com.pingpenne.testa.common.content.block;
import com.pingpenne.testa.TestA;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.BLOCKS;

public class AllBlocks {

    //registry
    private static final DeferredRegister<Block> BLOCKS_REG = DeferredRegister.create(BLOCKS, TestA.MOD_ID);
    //block registration
    public static final RegistryObject<Block> METRONOME = BLOCKS_REG.register("metronome", () -> new MetronomeBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(1f)));
    public static final RegistryObject<Block> SUPER_FUCK_BLOCK = BLOCKS_REG.register("fuck_block",() -> new FuckBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.WOOD)));
    public static void register(IEventBus eventBus){
            BLOCKS_REG.register(eventBus);
    }



}
