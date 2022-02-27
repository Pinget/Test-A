package com.pingpenne.testa.common.event;

import com.pingpenne.testa.common.content.item.AllItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EventHandler {

    private static final Logger LOGGER = LogManager.getLogger();

    private static DamageSource lastActiveDamageSource;

    @SubscribeEvent
    public static void getLastActiveDamageSource(LivingHurtEvent event) {
        // Workaround for removed patch to get the attacking entity.
        lastActiveDamageSource = event.getSource();
    }

    @SubscribeEvent
    public static void peggingHasNoKnockback(LivingKnockBackEvent event) {
        System.out.println("knocked");
        if (lastActiveDamageSource == null)
            return;
        Entity entity = lastActiveDamageSource.getDirectEntity();
        if (!(entity instanceof Player player)) {
            System.out.println("Source isn't instance of Player");
            return;
        }
        ItemStack item = player.getItemBySlot(EquipmentSlot.LEGS);
        if (item.is(AllItems.STRAP.get())) {
            event.setStrength(0f);
        }

    }
}
