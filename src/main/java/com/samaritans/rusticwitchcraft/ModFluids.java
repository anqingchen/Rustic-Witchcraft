package com.samaritans.rusticwitchcraft;

import com.bewitchment.registry.ModPotions;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rustic.common.blocks.fluids.FluidBooze;
import rustic.common.blocks.fluids.FluidDrinkable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class ModFluids {
    public static Fluid JUNIPER_BERRY_JUICE;
    public static Fluid ELDERBERRY_JUICE;
    public static Fluid WORMWOOD_MIXTURE;
    public static Fluid SAGE_JUICE;

    public static Fluid GIN;
    public static Fluid ELDERBERYY_WINE;
    public static Fluid ABSINTHE;
    public static Fluid SAGE_LIQUEUR;

    public static BlockFluidRW BLOCK_JUNIPER_BERRY_JUICE;
    public static BlockFluidRW BLOCK_ELDERBERRY_JUICE;
    public static BlockFluidRW BLOCK_WORMWOOD_MIXTURE;
    public static BlockFluidRW BLOCK_SAGE_JUICE;

    private static List<Fluid> FLUIDS = new ArrayList<>();

    public static void init() {
        JUNIPER_BERRY_JUICE = new FluidDrinkable("juniper_berry_juice", new ResourceLocation(RusticWitchcraft.MODID, "juniper_berry_juice_still"), new ResourceLocation(RusticWitchcraft.MODID, "juniper_berry_juice_flow")) {
            @Override
            public void onDrank(@Nonnull World world, @Nonnull EntityPlayer entityPlayer, @Nonnull ItemStack itemStack, @Nonnull FluidStack fluidStack) {
                entityPlayer.getFoodStats().addStats(1, 2.0F);
                entityPlayer.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 400, 1));
            }
        };
        register(JUNIPER_BERRY_JUICE);
        ELDERBERRY_JUICE = new FluidDrinkable("elderberry_juice", new ResourceLocation(RusticWitchcraft.MODID, "elderberry_juice_still"), new ResourceLocation(RusticWitchcraft.MODID, "elder_juice_flow")) {
            @Override
            public void onDrank(@Nonnull World world, @Nonnull EntityPlayer entityPlayer, @Nonnull ItemStack itemStack, @Nonnull FluidStack fluidStack) {
                entityPlayer.getFoodStats().addStats(1, 0.9F);
            }
        };
        register(ELDERBERRY_JUICE);
        WORMWOOD_MIXTURE = new FluidDrinkable("wormwood_mixture", new ResourceLocation(RusticWitchcraft.MODID, "wormwood_mixture_still"), new ResourceLocation(RusticWitchcraft.MODID, "wormwood_mixture_flow")) {
            @Override
            public void onDrank(@Nonnull World world, @Nonnull EntityPlayer entityPlayer, @Nonnull ItemStack itemStack, @Nonnull FluidStack fluidStack) {
                entityPlayer.getFoodStats().addStats(1, 0.9F);
            }
        };
        register(WORMWOOD_MIXTURE);
        SAGE_JUICE = new FluidDrinkable("sage_juice", new ResourceLocation(RusticWitchcraft.MODID, "sage_juice_still"), new ResourceLocation(RusticWitchcraft.MODID, "sage_juice_flow")) {
            @Override
            public void onDrank(@Nonnull World world, @Nonnull EntityPlayer entityPlayer, @Nonnull ItemStack itemStack, @Nonnull FluidStack fluidStack) {
                entityPlayer.getFoodStats().addStats(1, 1.0F);
                entityPlayer.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 75));
                entityPlayer.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 600, 15, false, false));
                entityPlayer.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 600, 15, false, false));
                entityPlayer.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 600, 15, false, false));
            }
        };
        register(SAGE_JUICE);
        GIN = new FluidBooze("gin", new ResourceLocation(RusticWitchcraft.MODID, "gin_still"), new ResourceLocation(RusticWitchcraft.MODID, "gin_flow")) {
            protected void affectPlayer(World world, EntityPlayer player, float quality) {
                if (quality > 0.5) {
                    float saturation = 2.0F * quality;
                    player.getFoodStats().addStats(1, saturation);
                    int durationx = (int)(12000.0F * Math.max(Math.abs((quality - 0.5F) * 2.0F), 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, durationx));
                } else {
                    int duration = (int)(1200.0F * Math.max(1.0F - quality, 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, duration));
                    duration = (int)(6000.0F * Math.max(1.0F - quality, 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, duration));
                }
            }
        }.setInebriationChance(0.5F).setDensity(1004).setViscosity(1400);
        register(GIN, false);
        ELDERBERYY_WINE = new FluidBooze("elderberry_wine", new ResourceLocation(RusticWitchcraft.MODID, "elderberry_wine_still"), new ResourceLocation(RusticWitchcraft.MODID, "elderberry_wine_flow")) {
            protected void affectPlayer(World world, EntityPlayer player, float quality) {
                if (quality > 0.5) {
                    float saturation = 2.0F * quality;
                    player.getFoodStats().addStats(1, saturation);
                    int durationx = (int)(12000.0F * Math.max(Math.abs((quality - 0.5F) * 2.0F), 0.0F));
                    player.addPotionEffect(new PotionEffect(ModPotions.magic_resistance, durationx));
                    player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, durationx));
                } else {
                    int duration = (int)(1200.0F * Math.max(1.0F - quality, 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, duration));
                    duration = (int)(6000.0F * Math.max(1.0F - quality, 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, duration));
                }
            }
        }.setInebriationChance(0.5F).setDensity(1004).setViscosity(1400);
        register(ELDERBERYY_WINE, false);
        ABSINTHE = new FluidBooze("absinthe", new ResourceLocation(RusticWitchcraft.MODID, "absinthe_still"), new ResourceLocation(RusticWitchcraft.MODID, "absinthe_flow")) {
            protected void affectPlayer(World world, EntityPlayer player, float quality) {
                if (quality > 0.5) {
                    float saturation = 2.0F * quality;
                    player.getFoodStats().addStats(1, saturation);
                    int durationx = (int)(12000.0F * Math.max(Math.abs((quality - 0.5F) * 2.0F), 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, durationx));
                } else {
                    int duration = (int)(1200.0F * Math.max(1.0F - quality, 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, duration));
                    duration = (int)(6000.0F * Math.max(1.0F - quality, 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, duration));
                }
            }
        }.setInebriationChance(0.5F).setDensity(1004).setViscosity(1400);
        register(ABSINTHE, false);
        SAGE_LIQUEUR = new FluidBooze("sage_liqueur", new ResourceLocation(RusticWitchcraft.MODID, "sage_liqueur_still"), new ResourceLocation(RusticWitchcraft.MODID, "sage_liqueur_flow")) {
            protected void affectPlayer(World world, EntityPlayer player, float quality) {
                if (quality > 0.5) {
                    float saturation = 2.0F * quality;
                    player.getFoodStats().addStats(1, saturation);
                    int durationx = (int)(12000.0F * Math.max(Math.abs((quality - 0.5F) * 2.0F), 0.0F));
                    player.addPotionEffect(new PotionEffect(com.samaritans.rusticwitchcraft.ModPotions.NATURES_AURA, durationx));
                } else {
                    int duration = (int)(1200.0F * Math.max(1.0F - quality, 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.POISON, duration));
                    duration = (int)(6000.0F * Math.max(1.0F - quality, 0.0F));
                    player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, duration));
                }
            }
        }.setInebriationChance(0.5F).setDensity(1004).setViscosity(1400);
        register(SAGE_LIQUEUR, false);
        BLOCK_JUNIPER_BERRY_JUICE = new BlockFluidRW("juniper_berry_juice", JUNIPER_BERRY_JUICE, Material.WATER);
        BLOCK_JUNIPER_BERRY_JUICE.setQuantaPerBlock(6);
        BLOCK_ELDERBERRY_JUICE = new BlockFluidRW("elderberry_juice", ELDERBERRY_JUICE, Material.WATER);
        BLOCK_ELDERBERRY_JUICE.setQuantaPerBlock(6);
        BLOCK_WORMWOOD_MIXTURE = new BlockFluidRW("wormwood_mixture", WORMWOOD_MIXTURE, Material.WATER);
        BLOCK_WORMWOOD_MIXTURE.setQuantaPerBlock(6);
        BLOCK_SAGE_JUICE = new BlockFluidRW("sage_juice", SAGE_JUICE, Material.WATER);
        BLOCK_SAGE_JUICE.setQuantaPerBlock(6);
    }

    private static void register(Fluid fluid) {
        register(fluid, true);
    }

    private static void register(Fluid fluid, boolean addBucket) {
        if (!FluidRegistry.registerFluid(fluid)) {
            fluid = FluidRegistry.getFluid(fluid.getName());
        }
        if (addBucket) {
            FluidRegistry.addBucketForFluid(fluid);
        }
        FLUIDS.add(fluid);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        BLOCK_JUNIPER_BERRY_JUICE.initModel();
        BLOCK_ELDERBERRY_JUICE.initModel();
        BLOCK_WORMWOOD_MIXTURE.initModel();
        BLOCK_SAGE_JUICE.initModel();
    }
}

