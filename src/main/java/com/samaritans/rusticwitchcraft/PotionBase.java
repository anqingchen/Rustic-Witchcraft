package com.samaritans.rusticwitchcraft;

import com.samaritans.rusticwitchcraft.RusticWitchcraft;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionBase extends Potion {
    public static final ResourceLocation POTION_ICONS = new ResourceLocation("rusticwitchcraft:textures/potion_icons.png");

    public PotionBase(boolean isBadEffect, int color, String name) {
        super(isBadEffect, color);
        this.setPotionName("effect." + name);
        if (!isBadEffect) this.setBeneficial();
        this.setRegistryName(RusticWitchcraft.MODID, name);
    }

    @Override
    public Potion setIconIndex(int p_76399_1_, int p_76399_2_) {
        super.setIconIndex(p_76399_1_, p_76399_2_);
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getStatusIconIndex() {
        Minecraft.getMinecraft().getTextureManager().bindTexture(POTION_ICONS);
        return super.getStatusIconIndex();
    }
}
