package com.pingpenne.testa.common.content.block;

import com.pingpenne.testa.TestA;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.pingpenne.testa.common.content.block.AllBlocks.METRONOME;
import static com.pingpenne.testa.common.content.block.AllBlocks.TEST_STORAGE;

public class AllBlockEntities {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TestA.MOD_ID);
    public static final RegistryObject<BlockEntityType<MetronomeBlockEntity>> METRONOME_BLOCK_ENTITY = BLOCK_ENTITIES.register("metronome",() -> BlockEntityType.Builder.of(MetronomeBlockEntity::new,METRONOME.get()).build(null));
    public static final RegistryObject<BlockEntityType<? extends TestStorageBlockEntity>> TEST_STORAGE_BLOCK_ENTITY = BLOCK_ENTITIES.register("test_storage", () -> BlockEntityType.Builder.of(TestStorageBlockEntity::new, TEST_STORAGE.get()).build(null));
    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }
}
