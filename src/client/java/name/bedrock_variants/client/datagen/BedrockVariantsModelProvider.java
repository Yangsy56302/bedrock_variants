package name.bedrock_variants.client.datagen;

import name.bedrock_variants.BedrockVariantsRegister;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Blocks;

public class BedrockVariantsModelProvider extends FabricModelProvider {
    public BedrockVariantsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.family(Blocks.BEDROCK).generateFor(BedrockVariantsRegister.BEDROCK_FAMILY);
        blockStateModelGenerator.family(BedrockVariantsRegister.COBBLED_BEDROCK).generateFor(BedrockVariantsRegister.COBBLED_BEDROCK_FAMILY);
        blockStateModelGenerator.family(BedrockVariantsRegister.POLISHED_BEDROCK).generateFor(BedrockVariantsRegister.POLISHED_BEDROCK_FAMILY);
        blockStateModelGenerator.family(BedrockVariantsRegister.BEDROCK_BRICKS).generateFor(BedrockVariantsRegister.BEDROCK_BRICK_FAMILY);
        blockStateModelGenerator.family(BedrockVariantsRegister.BEDROCK_TILES).generateFor(BedrockVariantsRegister.BEDROCK_TILE_FAMILY);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {}

    @Override
    public String getName() {
        return "BedrockVariantsModelGenerator";
    }
}