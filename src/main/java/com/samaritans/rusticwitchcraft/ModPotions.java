package com.samaritans.rusticwitchcraft;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModPotions {
    public static final Potion FERTILE_FEET = new PotionBase(false, 1098816, "fertile_feet", new ResourceLocation("rusticwitchcraft:textures/fertile_feet.png"));

    public static void init() {
        GameRegistry.findRegistry(Potion.class).register(FERTILE_FEET);
    }
}
