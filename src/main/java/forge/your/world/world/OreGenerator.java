package forge.your.world.world;

import forge.your.world.init.BlocksHandler;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * class use for handle world generation(only ore generation)
 */
public class OreGenerator implements IWorldGenerator {

    /**
     * function call for start ore generation
     */
    public void startWorldGeneration() {
        ForgeRegistries.BIOMES.forEach(biome -> {

            biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    FillerBlockType.NATURAL_STONE,
                                    BlocksHandler.TERILLIUM_ORE.getDefaultState(),
                                    4),
                            Placement.COUNT_RANGE,
                            new CountRangeConfig(
                                    6,
                                    2,
                                    0,
                                    28
                            )
                    )
            );

            biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(
                            Feature.ORE,
                            new OreFeatureConfig(
                                    FillerBlockType.NETHERRACK,
                                    BlocksHandler.RED_DIAMOND_ORE.getDefaultState(),
                                    4),
                            Placement.COUNT_RANGE,
                            new CountRangeConfig(
                                    32,
                                    2,
                                    0,
                                    126
                            )
                    )
            );

            biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(
                            Feature.EMERALD_ORE,
                            new ReplaceBlockConfig(
                                    Blocks.END_STONE.getDefaultState(),
                                    BlocksHandler.ENDERIUM_ORE.getDefaultState()
                            ),
                            Placement.COUNT_RANGE,
                            new CountRangeConfig(
                                    42,
                                    16,
                                    0,
                                    64
                            )
                    )
            );

        });
    }
}
