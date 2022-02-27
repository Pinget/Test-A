package com.pingpenne.testa.datagen;

import com.pingpenne.testa.TestA;
import com.pingpenne.testa.common.content.item.AllItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider implements DataProvider {
    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, TestA.MOD_ID,existingFileHelper);

    }
    @Override
    protected void registerModels(){
    flatSingleLayer(AllItems.STRAP, "testa:item/strap");
    }

    private ItemModelBuilder flatSingleLayer(RegistryObject<Item> item, String texture) {
        String id = item.getId().getPath();
        return singleTexture(
                id,
                mcLoc("item/generated"),
                "layer0",
                new ResourceLocation(texture));
    }
}
