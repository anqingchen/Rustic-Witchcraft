package com.samaritans.rusticwitchcraft;

import com.bewitchment.registry.ModObjects;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rustic.common.Config;
import rustic.common.crafting.BrewingBarrelRecipe;
import rustic.common.crafting.CrushingTubRecipe;
import rustic.common.crafting.RecipeNonIngredientReturn;
import rustic.common.crafting.Recipes;

public class ModRecipes {
    public static void init() {
        if (Config.ENABLE_CHAIRS) {
            GameRegistry.addShapedRecipe(new ResourceLocation(RusticWitchcraft.MODID, "greatwood_chair"),
                    new ResourceLocation(RusticWitchcraft.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_CYPRESS, 4), "P  ", "PPP", "S S", 'P', new ItemStack(ModObjects.cypress_planks), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(RusticWitchcraft.MODID, "silverwood_chair"),
                    new ResourceLocation(RusticWitchcraft.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_DRAGONS_BLOOD, 4), "P  ", "PPP", "S S", 'P', new ItemStack(ModObjects.dragons_blood_planks), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(RusticWitchcraft.MODID, "greatwood_chair"),
                    new ResourceLocation(RusticWitchcraft.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_ELDER, 4), "P  ", "PPP", "S S", 'P', new ItemStack(ModObjects.elder_planks), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(RusticWitchcraft.MODID, "greatwood_chair"),
                    new ResourceLocation(RusticWitchcraft.MODID, "chair"), new ItemStack(ModBlocks.CHAIR_JUNIPER, 4), "P  ", "PPP", "S S", 'P', new ItemStack(ModObjects.juniper_planks), 'S', new ItemStack(Items.STICK));
        }
        if (Config.ENABLE_TABLES) {
            GameRegistry.addShapedRecipe(new ResourceLocation(RusticWitchcraft.MODID, "greatwood_table"),
                    new ResourceLocation(RusticWitchcraft.MODID, "table"), new ItemStack(ModBlocks.TABLE_CYPRESS, 2), "PPP", "S S", 'P', new ItemStack(ModObjects.cypress_planks), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(RusticWitchcraft.MODID, "silverwood_table"),
                    new ResourceLocation(RusticWitchcraft.MODID, "table"), new ItemStack(ModBlocks.TABLE_DRAGONS_BLOOD, 2), "PPP", "S S", 'P', new ItemStack(ModObjects.dragons_blood_planks), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(RusticWitchcraft.MODID, "greatwood_table"),
                    new ResourceLocation(RusticWitchcraft.MODID, "table"), new ItemStack(ModBlocks.TABLE_ELDER, 2), "PPP", "S S", 'P', new ItemStack(ModObjects.elder_planks), 'S', new ItemStack(Items.STICK));
            GameRegistry.addShapedRecipe(new ResourceLocation(RusticWitchcraft.MODID, "greatwood_table"),
                    new ResourceLocation(RusticWitchcraft.MODID, "table"), new ItemStack(ModBlocks.TABLE_JUNIPER, 2), "PPP", "S S", 'P', new ItemStack(ModObjects.juniper_planks), 'S', new ItemStack(Items.STICK));
        }

        ItemStack juniperBucket = FluidUtil.getFilledBucket(new FluidStack(ModFluids.JUNIPER_BERRY_JUICE, 1000));
        GameRegistry.findRegistry(IRecipe.class).register((new RecipeNonIngredientReturn(null, juniperBucket, new Object[]{new ItemStack(ModObjects.juniper_berries), new ItemStack(Items.SUGAR), new ItemStack(Items.WATER_BUCKET)})).setRegistryName(new ResourceLocation("rusticwitchcraft", "junier_spirit")));

        // Crushing
        Recipes.crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.ELDERBERRY_JUICE, 250), new ItemStack(ModObjects.elderberries)));
        Recipes.crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.WORMWOOD_MIXTURE, 250), new ItemStack(ModObjects.wormwood)));
        Recipes.crushingTubRecipes.add(new CrushingTubRecipe(new FluidStack(ModFluids.SAGE_JUICE, 250), new ItemStack(ModObjects.white_sage)));

        // Brewing
        Recipes.brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluids.GIN, 1), new FluidStack(ModFluids.JUNIPER_BERRY_JUICE, 1)));
        Recipes.brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluids.ELDERBERYY_WINE, 1), new FluidStack(ModFluids.ELDERBERRY_JUICE, 1)));
        Recipes.brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluids.ABSINTHE, 1), new FluidStack(ModFluids.WORMWOOD_MIXTURE, 1)));
        Recipes.brewingRecipes.add(new BrewingBarrelRecipe(new FluidStack(ModFluids.SAGE_LIQUEUR, 1), new FluidStack(ModFluids.SAGE_JUICE, 1)));
    }
}
