package com.pingpenne.testa.common.content.block;

import com.pingpenne.testa.TestA;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.BLOCKS;
import static net.minecraftforge.registries.ForgeRegistries.CONTAINERS;

public class AllContainers {

    private static final DeferredRegister<MenuType<?>> CONTAINERS_REG = DeferredRegister.create(CONTAINERS, TestA.MOD_ID);

}
