package forge.your.world.data;

import forge.your.world.init.BlocksHandler;
import forge.your.world.init.ItemsHandler;
import forge.your.world.items.ItemsTags;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

/**
 * forge your world recipes data generator
 */
public class Recipes extends RecipeProvider {

    /**
     * constructor
     * @param generatorIn data generator instance
     */
    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    /**
     * load all recipes
     */
    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        this.oreSmelting(consumer);
        this.oreBlasting(consumer);
        this.shapedRecipe(consumer);
        this.shapelessRecipe(consumer);
    }

    private void shapedRecipe(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shapedRecipe(ItemsHandler.TERILLIUM)
                .key('T', ItemsTags.RAW_TERILLIUM)
                .key('G', Tags.Items.DUSTS_GLOWSTONE)
                .key('R', Tags.Items.DUSTS_REDSTONE)
                .patternLine(" G ")
                .patternLine("RTR")
                .patternLine(" G ")
                .addCriterion("has_raw_terillium", this.hasItem(ItemsTags.RAW_TERILLIUM))
                .build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BlocksHandler.TERILLIUM_BLOCK)
                .key('T', ItemsTags.TERILLIUM)
                .patternLine("TTT")
                .patternLine("TTT")
                .patternLine("TTT")
                .addCriterion("has_terillium", this.hasItem(ItemsTags.TERILLIUM))
                .build(consumer);

    }

    public void shapelessRecipe(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapelessRecipe(ItemsHandler.TERILLIUM, 9)
                .addIngredient(ItemsTags.TERILLIUM_BLOCK)
                .addCriterion("has_terillium_block", this.hasItem(ItemsTags.TERILLIUM_BLOCK))
                .build(consumer, "terillium_from_block");
    }

    private void oreSmelting(Consumer<IFinishedRecipe> consumer) {
        // trillium
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(BlocksHandler.TERILLIUM_ORE), ItemsHandler.TERILLIUM, 0.1f, 200)
                .addCriterion("has_terillium_ore", this.hasItem(BlocksHandler.TERILLIUM_ORE)).build(consumer, "terillium_smelting");
    }

    private void oreBlasting(Consumer<IFinishedRecipe> consumer) {
        // trillium
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(BlocksHandler.TERILLIUM_ORE), ItemsHandler.TERILLIUM, 0.1f, 100)
                .addCriterion("has_terillium_ore", this.hasItem(BlocksHandler.TERILLIUM_ORE)).build(consumer, "terillium_blasting");
    }

}