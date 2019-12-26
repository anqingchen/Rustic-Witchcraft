package com.samaritans.rusticwitchcraft;

import com.bewitchment.Bewitchment;
import com.bewitchment.Util;
import com.bewitchment.api.registry.Brew;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import rustic.common.items.ModItems;
import rustic.common.potions.PotionsRustic;

public class ModEventHandler {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModBlocks.initModels();
        ModFluids.initModels();
    }

    @SubscribeEvent
    public static void registerBWBrews(RegistryEvent.Register<Brew> event) {
        event.getRegistry().register(new Brew(new ResourceLocation(Bewitchment.MODID, "blazing_trail"), com.bewitchment.Util.get(ModItems.CHILI_PEPPER), new PotionEffect(PotionsRustic.BLAZING_TRAIL_POTION, (20 * 30))));
        event.getRegistry().register(new Brew(new ResourceLocation(Bewitchment.MODID, "iron_skin"), Util.get(ModItems.IRONBERRIES), new PotionEffect(PotionsRustic.IRON_SKIN_POTION, (20 * 30))));
    }

    @SubscribeEvent
    public static void handlePotion(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase entityLivingBase = event.getEntityLiving();
        if (entityLivingBase.isPotionActive(ModPotions.FERTILE_FEET) && entityLivingBase.ticksExisted % 120 == 0) {
            BlockPos pos = entityLivingBase.getPosition();
            World world = entityLivingBase.world;
            BlockPos.getAllInBoxMutable(pos.add(-2, -2, -2), pos.add(2, 2, 2)).forEach(p -> {
                if (world.getBlockState(p).getBlock() instanceof IGrowable && world.rand.nextDouble() < 0.05) {
                    IGrowable growable = ((IGrowable) world.getBlockState(p).getBlock());
                    if (growable.canGrow(world, p, world.getBlockState(p), true)) {
                        growable.grow(world, world.rand, p, world.getBlockState(p));
                        world.playEvent(2005, p, 0);
                    }
                }
            });
        }
    }
}
