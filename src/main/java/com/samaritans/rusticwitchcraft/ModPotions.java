package com.samaritans.rusticwitchcraft;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModPotions {
    public static final Potion NATURES_AURA = new PotionBase(false, 1098816, "natures_aura").setIconIndex(0, 0);

    public static void init() {
        GameRegistry.findRegistry(Potion.class).register(NATURES_AURA);
    }
}
