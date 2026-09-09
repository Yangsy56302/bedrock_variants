package name.bedrock_variants;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class BedrockVariantsRegister {
    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BedrockVariants.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BedrockVariants.MOD_ID, name));
    }

	private static Block register(
		String name,
		Function<BlockBehaviour.Properties, Block> blockFactory,
		BlockBehaviour.Properties settings
	) {
		ResourceKey<Block> blockKey = keyOfBlock(name);
		Block block = blockFactory.apply(settings.setId(blockKey));

		ResourceKey<Item> itemKey = keyOfItem(name);

		BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
		Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register((content) -> {
            content.addBefore(Blocks.BRICKS, block);
        });

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

    public static final Block BEDROCK_SLAB = register(
        "bedrock_slab", SlabBlock::new,
        BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)
    );
    public static final Block BEDROCK_STAIRS = register(
        "bedrock_stairs",
        (properties) -> new StairBlock(Blocks.BEDROCK.defaultBlockState(), properties),
        BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)
    );
    public static final Block BEDROCK_WALL = register(
        "bedrock_wall", WallBlock::new,
        BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK).forceSolidOn()
    );

    public static final Block COBBLED_BEDROCK = register(
        "cobbled_bedrock", Block::new,
        BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)
    );
    public static final Block COBBLED_BEDROCK_SLAB = register(
        "cobbled_bedrock_slab", SlabBlock::new,
        BlockBehaviour.Properties.ofFullCopy(COBBLED_BEDROCK)
    );
    public static final Block COBBLED_BEDROCK_STAIRS = register(
        "cobbled_bedrock_stairs",
        (properties) -> new StairBlock(COBBLED_BEDROCK.defaultBlockState(), properties),
        BlockBehaviour.Properties.ofFullCopy(COBBLED_BEDROCK)
    );
    public static final Block COBBLED_BEDROCK_WALL = register(
        "cobbled_bedrock_wall", WallBlock::new,
        BlockBehaviour.Properties.ofFullCopy(COBBLED_BEDROCK).forceSolidOn()
    );

    public static final Block POLISHED_BEDROCK = register(
        "polished_bedrock", Block::new,
        BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)
    );
    public static final Block CHISELED_BEDROCK = register(
        "chiseled_bedrock", Block::new,
        BlockBehaviour.Properties.ofFullCopy(POLISHED_BEDROCK)
    );
    public static final Block POLISHED_BEDROCK_SLAB = register(
        "polished_bedrock_slab", SlabBlock::new,
        BlockBehaviour.Properties.ofFullCopy(POLISHED_BEDROCK)
    );
    public static final Block POLISHED_BEDROCK_STAIRS = register(
        "polished_bedrock_stairs",
        (properties) -> new StairBlock(POLISHED_BEDROCK.defaultBlockState(), properties),
        BlockBehaviour.Properties.ofFullCopy(POLISHED_BEDROCK)
    );
    public static final Block POLISHED_BEDROCK_WALL = register(
        "polished_bedrock_wall", WallBlock::new,
        BlockBehaviour.Properties.ofFullCopy(POLISHED_BEDROCK).forceSolidOn()
    );

    public static final Block BEDROCK_BRICKS = register(
        "bedrock_bricks", Block::new,
        BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)
    );
    public static final Block CRACKED_BEDROCK_BRICKS = register(
        "cracked_bedrock_bricks", Block::new,
        BlockBehaviour.Properties.ofFullCopy(BEDROCK_BRICKS)
    );
    public static final Block BEDROCK_BRICK_SLAB = register(
        "bedrock_brick_slab", SlabBlock::new,
        BlockBehaviour.Properties.ofFullCopy(BEDROCK_BRICKS)
    );
    public static final Block BEDROCK_BRICK_STAIRS = register(
        "bedrock_brick_stairs",
        (properties) -> new StairBlock(BEDROCK_BRICKS.defaultBlockState(), properties),
        BlockBehaviour.Properties.ofFullCopy(BEDROCK_BRICKS)
    );
    public static final Block BEDROCK_BRICK_WALL = register(
        "bedrock_brick_wall", WallBlock::new,
        BlockBehaviour.Properties.ofFullCopy(BEDROCK_BRICKS).forceSolidOn()
    );

    public static final Block BEDROCK_TILES = register(
        "bedrock_tiles", Block::new,
        BlockBehaviour.Properties.ofFullCopy(Blocks.BEDROCK)
    );
    public static final Block CRACKED_BEDROCK_TILES = register(
        "cracked_bedrock_tiles", Block::new,
        BlockBehaviour.Properties.ofFullCopy(BEDROCK_TILES)
    );
    public static final Block BEDROCK_TILE_SLAB = register(
        "bedrock_tile_slab", SlabBlock::new,
        BlockBehaviour.Properties.ofFullCopy(BEDROCK_TILES)
    );
    public static final Block BEDROCK_TILE_STAIRS = register(
        "bedrock_tile_stairs",
        (properties) -> new StairBlock(BEDROCK_TILES.defaultBlockState(), properties),
        BlockBehaviour.Properties.ofFullCopy(BEDROCK_TILES)
    );
    public static final Block BEDROCK_TILE_WALL = register(
        "bedrock_tile_wall", WallBlock::new,
        BlockBehaviour.Properties.ofFullCopy(BEDROCK_TILES).forceSolidOn()
    );

    public static final BlockFamily BEDROCK_FAMILY =
        new BlockFamily.Builder(Blocks.BEDROCK)
            .polished(POLISHED_BEDROCK)
            .slab(BEDROCK_SLAB)
            .stairs(BEDROCK_STAIRS)
            .wall(BEDROCK_WALL)
            .getFamily();
    public static final BlockFamily COBBLED_BEDROCK_FAMILY =
        new BlockFamily.Builder(COBBLED_BEDROCK)
            .slab(COBBLED_BEDROCK_SLAB)
            .stairs(COBBLED_BEDROCK_STAIRS)
            .wall(COBBLED_BEDROCK_WALL)
            .getFamily();
    public static final BlockFamily POLISHED_BEDROCK_FAMILY =
        new BlockFamily.Builder(POLISHED_BEDROCK)
            .cut(BEDROCK_BRICKS)
            .chiseled(CHISELED_BEDROCK)
            .slab(POLISHED_BEDROCK_SLAB)
            .stairs(POLISHED_BEDROCK_STAIRS)
            .wall(POLISHED_BEDROCK_WALL)
            .getFamily();
    public static final BlockFamily BEDROCK_BRICK_FAMILY =
        new BlockFamily.Builder(BEDROCK_BRICKS)
            .cut(BEDROCK_TILES)
            .cracked(CRACKED_BEDROCK_BRICKS)
            .slab(BEDROCK_BRICK_SLAB)
            .stairs(BEDROCK_BRICK_STAIRS)
            .wall(BEDROCK_BRICK_WALL)
            .getFamily();
    public static final BlockFamily BEDROCK_TILE_FAMILY =
        new BlockFamily.Builder(BEDROCK_TILES)
            .cracked(CRACKED_BEDROCK_TILES)
            .slab(BEDROCK_TILE_SLAB)
            .stairs(BEDROCK_TILE_STAIRS)
            .wall(BEDROCK_TILE_WALL)
            .getFamily();

    public static final TagKey<Block> BLOCK_TAG_BEDROCK = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BedrockVariants.MOD_ID, "bedrock"));

	public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register((content) -> {
            content.addAfter(Blocks.CHISELED_TUFF_BRICKS, Blocks.BEDROCK);
        });
    }
}