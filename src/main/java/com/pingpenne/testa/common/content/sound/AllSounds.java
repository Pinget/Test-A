package com.pingpenne.testa.common.content.sound;

import com.pingpenne.testa.TestA;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraftforge.registries.ForgeRegistries.SOUND_EVENTS;

public class AllSounds {

    private static final DeferredRegister<SoundEvent> SOUND_REG = DeferredRegister.create(SOUND_EVENTS, TestA.MOD_ID);
    public static final RegistryObject<SoundEvent> TICK = SOUND_REG.register("tick",() -> new SoundEvent(new ResourceLocation(TestA.MOD_ID,"tick")));

    public static void register(IEventBus bus){
        SOUND_REG.register(bus);
    }

}
