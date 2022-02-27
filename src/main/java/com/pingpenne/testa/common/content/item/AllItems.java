package com.pingpenne.testa.common.content.item;

import com.pingpenne.testa.TestA;
import com.pingpenne.testa.common.content.item.armor.Strap;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


import static com.pingpenne.testa.common.content.block.AllBlocks.*;
import static net.minecraftforge.registries.ForgeRegistries.ITEMS;

public class AllItems {

    //registry
    private static final DeferredRegister<Item> ITEMS_REG = DeferredRegister.create(ITEMS, TestA.MOD_ID);
    //item registration
    public static final RegistryObject<Item> METRONOME_ITEM = ITEMS_REG.register("metronome", () -> new BlockItem(METRONOME.get(), new Item.Properties().tab(TestA.TEST_TAB)));
    public static final RegistryObject<Item> SUPER_FUCK_BLOCK_ITEM = ITEMS_REG.register("fuck_block",() -> new BlockItem(SUPER_FUCK_BLOCK.get(), new Item.Properties().tab(TestA.TEST_TAB)));
    public static final RegistryObject<Item> STRAP = ITEMS_REG.register("strap", () -> new Strap(new Item.Properties().tab(TestA.TEST_TAB)));
    public static void register(IEventBus eventBus){
        ITEMS_REG.register(eventBus);
    }
}
