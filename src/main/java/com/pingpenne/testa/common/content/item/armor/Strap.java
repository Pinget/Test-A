package com.pingpenne.testa.common.content.item.armor;

import com.pingpenne.testa.common.content.item.AllItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Strap extends Item implements Wearable {
    public Strap(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        super.onArmorTick(stack, world, player);
        if (!world.isClientSide) {
            if (stopShift(player)) {
                pegHit(world, player);
                System.out.println("pegHit run");
            }
        }
    }

    int shiftCounter = 0;

    private boolean stopShift(Player player) {
        System.out.println(shiftCounter);
        if (player.isCrouching()) {
            shiftCounter++;
        } else if (shiftCounter > 10) {
            shiftCounter = 0;
            System.out.println("Has shifted! True");
            return true;
        }
        return false;
    }

    //Knockback reduction is defined in an event in EventHandler

    private void pegHit(Level world, Player player) {
        LivingEntity entity;
        List<LivingEntity> entityList;
        AABB aabb = player.getBoundingBox();
        entityList = world.getEntitiesOfClass(LivingEntity.class, aabb.inflate(1f));
        for (LivingEntity victim : entityList
        ) {
            if (!(victim instanceof Player)) {
                entity = victim;
                entity.hurt(DamageSource.playerAttack(player), 2f);
                break;
            }
        }

    }


    @Nullable
    @Override
    public EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.LEGS;
    }

    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        EquipmentSlot equipmentslottype = Mob.getEquipmentSlotForItem(itemstack);
        ItemStack itemstack1 = playerIn.getItemBySlot(equipmentslottype);
        if (itemstack1.isEmpty()) {
            playerIn.setItemSlot(equipmentslottype, itemstack.copy());
            itemstack.setCount(0);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
        } else {
            return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
        }
    }

    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_ELYTRA;
    }

}


