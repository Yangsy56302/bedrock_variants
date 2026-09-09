package name.bedrock_variants.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BedrockVariantsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BedrockVariantsModelProvider::new);
		// pack.addProvider(BedrockVariantsRecipeProvider::new);
		// pack.addProvider(BedrockVariantsTagGenerator::new);
	}
}
