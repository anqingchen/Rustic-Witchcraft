package com.samaritans.rusticwitchcraft;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = RusticWitchcraft.MODID, name = RusticWitchcraft.NAME, version = RusticWitchcraft.VERSION, dependencies = "required-after:rustic;required-after:bewitchment")
public class RusticWitchcraft
{
    public static final String MODID = "rusticwitchcraft";
    public static final String NAME = "Rustic Witchcraft";
    public static final String VERSION = "0.0.1";

    private static Logger logger;

    public RusticWitchcraft() {
        MinecraftForge.EVENT_BUS.register(ModEventHandler.class);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ModBlocks.init();
        ModFluids.init();
        ModPotions.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModRecipes.init();
    }
}
