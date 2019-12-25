package com.samaritans.rusticwitchcraft;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rustic.common.Config;
import rustic.common.blocks.BlockChair;
import rustic.common.blocks.BlockTable;

public class ModBlocks {
    public static BlockChair CHAIR_ELDER;
    public static BlockChair CHAIR_CYPRESS;
    public static BlockChair CHAIR_DRAGONS_BLOOD;
    public static BlockChair CHAIR_JUNIPER;

    public static BlockTable TABLE_ELDER;
    public static BlockTable TABLE_CYPRESS;
    public static BlockTable TABLE_DRAGONS_BLOOD;
    public static BlockTable TABLE_JUNIPER;


    public static void init() {
        if (Config.ENABLE_CHAIRS) {
            CHAIR_ELDER = new BlockChair("elder");
            CHAIR_CYPRESS = new BlockChair("cypress");
            CHAIR_DRAGONS_BLOOD = new BlockChair("dragons_blood");
            CHAIR_JUNIPER = new BlockChair("juniper");
        }
        if (Config.ENABLE_TABLES) {
            TABLE_ELDER = new BlockTable("elder");
            TABLE_CYPRESS = new BlockTable("cypress");
            TABLE_DRAGONS_BLOOD = new BlockTable("dragons_blood");
            TABLE_JUNIPER = new BlockTable("juniper");
        }
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        if (Config.ENABLE_CHAIRS) {
            CHAIR_ELDER.initModel();
            CHAIR_CYPRESS.initModel();
            CHAIR_DRAGONS_BLOOD.initModel();
            CHAIR_JUNIPER.initModel();
        }
        if (Config.ENABLE_TABLES) {
            TABLE_ELDER.initModel();
            TABLE_CYPRESS.initModel();
            TABLE_DRAGONS_BLOOD.initModel();
            TABLE_JUNIPER.initModel();
        }
    }
}
