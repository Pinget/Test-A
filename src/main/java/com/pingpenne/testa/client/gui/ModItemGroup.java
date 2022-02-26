package com.pingpenne.testa.client.gui;

import com.pingpenne.testa.TestA;
import com.pingpenne.testa.common.content.block.AllBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroup extends CreativeModeTab {
    public ModItemGroup(String name){
        super(TestA.MOD_ID +"."+ name);
    }
    @Override
    public ItemStack makeIcon(){
        return new ItemStack(AllBlocks.SUPER_FUCK_BLOCK.get());
    }
}
