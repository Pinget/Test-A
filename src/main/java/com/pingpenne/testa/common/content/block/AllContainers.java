package com.pingpenne.testa.common.content.block;

import com.pingpenne.testa.TestA;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.BLOCKS;
import static net.minecraftforge.registries.ForgeRegistries.CONTAINERS;

public class AllContainers {

    private static final DeferredRegister<MenuType<?>> CONTAINERS_REG = DeferredRegister.create(CONTAINERS, TestA.MOD_ID);

    public static final RegistryObject<MenuType<>> TEST_STORAGE_CONTAINER = CONTAINERS_REG.register()
    public static void register(IEventBus eventBus){
        CONTAINERS_REG.register(eventBus);
    }

}
