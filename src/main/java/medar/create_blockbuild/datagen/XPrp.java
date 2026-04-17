package medar.create_blockbuild.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import medar.create_blockbuild.Create_blockbuild;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class XPrp extends RecipeProvider {

    public XPrp(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            ResourceLocation id = ForgeRegistries.BLOCKS.getKey(block);

            if (id == null) {
                continue;
            }

            if (shouldInclude(id)) {
                // First recipe type (was XPrp / mixing)
                generateMixingRecipe(writer, id);

                // Second recipe type (was HXPrp)
                generateOtherRecipe(writer, id);
            }
        }
    }

    private boolean shouldInclude(ResourceLocation id) {
        if (!"minecraft".equals(id.getNamespace())) {
            return false;
        }

        String path = id.getPath();

        // Non-block / technical / impossible
        if (path.contains("air")) return false;
        if (path.contains("cave_air")) return false;
        if (path.contains("void_air")) return false;
        if (path.contains("portal")) return false;
        if (path.contains("gateway")) return false;
        if (path.contains("fire")) return false;
        if (path.contains("water")) return false;
        if (path.contains("lava")) return false;
        if (path.contains("bubble_column")) return false;
        if (path.contains("moving_piston")) return false;
        if (path.contains("piston_head")) return false;
        if (path.contains("end_portal")) return false;
        if (path.contains("nether_portal")) return false;
        if (path.contains("structure_void")) return false;

        // Command / dev / admin / structure
        if (path.contains("command_block")) return false;
        if (path.contains("structure_block")) return false;
        if (path.contains("jigsaw")) return false;
        if (path.contains("barrier")) return false;
        if (path.contains("light")) return false;
        if (path.contains("debug")) return false;
        if (path.contains("bedrock")) return false;
        if (path.contains("spawner")) return false;
        if (path.contains("reinforced_deepslate")) return false;

        // Plants / crops / organics that are usually not wanted here
        if (path.contains("wheat")) return false;
        if (path.contains("carrots")) return false;
        if (path.contains("potatoes")) return false;
        if (path.contains("beetroots")) return false;
        if (path.contains("melon_stem")) return false;
        if (path.contains("pumpkin_stem")) return false;
        if (path.contains("attached_melon_stem")) return false;
        if (path.contains("attached_pumpkin_stem")) return false;
        if (path.contains("cocoa")) return false;
        if (path.contains("sugar_cane")) return false;
        if (path.contains("bamboo_sapling")) return false;
        if (path.contains("sapling")) return false;
        if (path.contains("leaves")) return false;
        if (path.contains("mangrove_propagule")) return false;
        if (path.contains("flower")) return false;
        if (path.contains("tulip")) return false;
        if (path.contains("daisy")) return false;
        if (path.contains("orchid")) return false;
        if (path.contains("allium")) return false;
        if (path.contains("bluet")) return false;
        if (path.contains("rose_bush")) return false;
        if (path.contains("peony")) return false;
        if (path.contains("lilac")) return false;
        if (path.contains("sunflower")) return false;
        if (path.contains("fern")) return false;
        if (path.contains("grass")) return false;
        if (path.contains("dead_bush")) return false;
        if (path.contains("vine")) return false;
        if (path.contains("lily_pad")) return false;
        if (path.contains("seagrass")) return false;
        if (path.contains("kelp")) return false;
        if (path.contains("moss_carpet")) return false;
        if (path.contains("pink_petals")) return false;
        if (path.contains("spore_blossom")) return false;
        if (path.contains("hanging_roots")) return false;
        if (path.contains("roots")) return false;
        if (path.contains("fungus")) return false;
        if (path.contains("wart")) return false;
        if (path.contains("mushroom")) return false;
        if (path.contains("torchflower")) return false;
        if (path.contains("pitcher_crop")) return false;
        if (path.contains("pitcher_plant")) return false;

        // Redstone / rails / utility / interactables
        if (path.contains("rail")) return false;
        if (path.contains("redstone")) return false;
        if (path.contains("repeater")) return false;
        if (path.contains("comparator")) return false;
        if (path.contains("observer")) return false;
        if (path.contains("lever")) return false;
        if (path.contains("tripwire")) return false;
        if (path.contains("target")) return false;
        if (path.contains("daylight_detector")) return false;
        if (path.contains("lightning_rod")) return false;
        if (path.contains("hopper")) return false;
        if (path.contains("dispenser")) return false;
        if (path.contains("dropper")) return false;
        if (path.contains("lectern")) return false;
        if (path.contains("note_block")) return false;
        if (path.contains("jukebox")) return false;
        if (path.contains("crafter")) return false;
        if (path.contains("smithing_table")) return false;
        if (path.contains("cartography_table")) return false;
        if (path.contains("fletching_table")) return false;
        if (path.contains("grindstone")) return false;
        if (path.contains("loom")) return false;
        if (path.contains("stonecutter")) return false;
        if (path.contains("crafting_table")) return false;
        if (path.contains("furnace")) return false;
        if (path.contains("smoker")) return false;
        if (path.contains("blast_furnace")) return false;
        if (path.contains("anvil")) return false;
        if (path.contains("chipped_anvil")) return false;
        if (path.contains("damaged_anvil")) return false;
        if (path.contains("enchanting_table")) return false;
        if (path.contains("brewing_stand")) return false;
        if (path.contains("beacon")) return false;
        if (path.contains("respawn_anchor")) return false;

        // Containers / special functional blocks
        if (path.contains("chest")) return false;
        if (path.contains("barrel")) return false;
        if (path.contains("shulker_box")) return false;
        if (path.contains("ender_chest")) return false;
        if (path.contains("trapped_chest")) return false;

        // Doors / gates / trapdoors / buttons etc, usually not in your target
        if (path.endsWith("_door")) return false;
        if (path.endsWith("_trapdoor")) return false;
        if (path.endsWith("_button")) return false;
        if (path.endsWith("_pressure_plate")) return false;
        if (path.endsWith("_fence_gate")) return false;

        // Usually not desired if you want mostly full-ish building/natural blocks
        if (path.endsWith("_wall")) return false;
        if (path.endsWith("_stairs")) return false;
        if (path.endsWith("_slab")) return false;
        if (path.endsWith("_fence")) return false;
        if (path.endsWith("_pane")) return false;
        if (path.endsWith("_bed")) return false;
        if (path.endsWith("_banner")) return false;
        if (path.endsWith("_carpet")) return false;
        if (path.endsWith("_candles")) return false;
        if (path.endsWith("_candle")) return false;
        if (path.endsWith("_sign")) return false;
        if (path.endsWith("_wall_sign")) return false;
        if (path.endsWith("_hanging_sign")) return false;
        if (path.endsWith("_wall_hanging_sign")) return false;

        // Decorative / tiny / weird partial blocks
        if (path.startsWith("potted_")) return false;
        if (path.contains("skull")) return false;
        if (path.contains("head")) return false;
        if (path.contains("coral")) return false;
        if (path.contains("fan")) return false;
        if (path.contains("turtle_egg")) return false;
        if (path.contains("sniffer_egg")) return false;
        if (path.contains("cake")) return false;
        if (path.contains("candle_cake")) return false;
        if (path.contains("bell")) return false;
        if (path.contains("chain")) return false;
        if (path.contains("lantern")) return false;
        if (path.contains("campfire")) return false;
        if (path.contains("cauldron")) return false;
        if (path.contains("scaffolding")) return false;

        // Mob / special entity-ish blocks
        if (path.contains("end_rod")) return false;
        if (path.contains("tripwire_hook")) return false;

        return true;
    }

    // ==== FIRST RECIPE TYPE: Create mixing (your original XPrp logic) ====

    private void generateMixingRecipe(Consumer<FinishedRecipe> writer, ResourceLocation blockId) {
        ResourceLocation recipeId = new ResourceLocation(
                Create_blockbuild.MODID,
                "mixing/" + blockId.getNamespace() + "/" + blockId.getPath()
        );

        writer.accept(new FinishedRecipe() {
            @Override
            public void serializeRecipeData(JsonObject json) {
                json.addProperty("type", "create:mixing");

                JsonArray ingredients = new JsonArray();

                JsonObject mainBlock = new JsonObject();
                mainBlock.addProperty("item", blockId.toString());
                ingredients.add(mainBlock);

                JsonObject essence = new JsonObject();
                essence.addProperty("item", "create_blockbuild:world_essence");
                ingredients.add(essence);

                JsonObject fluid = new JsonObject();
                fluid.addProperty("fluid", "create_enchantment_industry:experience");
                fluid.addProperty("amount", 500);
                ingredients.add(fluid);

                json.add("ingredients", ingredients);

                JsonArray results = new JsonArray();

                JsonObject blockResult = new JsonObject();
                blockResult.addProperty("item", blockId.toString());
                blockResult.addProperty("count", 3);
                results.add(blockResult);

                JsonObject emptyEssence = new JsonObject();
                emptyEssence.addProperty("item", "create_blockbuild:world_essence_empty");
                emptyEssence.addProperty("count", 1);
                results.add(emptyEssence);

                json.add("results", results);
            }

            @Override
            public ResourceLocation getId() {
                return recipeId;
            }

            @Override
            public RecipeSerializer<?> getType() {
                // TODO: put the actual Create mixing serializer here
                return net.minecraftforge.registries.ForgeRegistries.RECIPE_SERIALIZERS.getValue(
                        new ResourceLocation("create", "mixing")
                );
            }

            @Override
            public @Nullable JsonObject serializeAdvancement() {
                return null;
            }

            @Override
            public @Nullable ResourceLocation getAdvancementId() {
                return null;
            }
        });
    }

    // ==== SECOND RECIPE TYPE: your old HXPrp-style recipe ====

    private void generateOtherRecipe(Consumer<FinishedRecipe> writer, ResourceLocation blockId) {
        ResourceLocation recipeId = new ResourceLocation(
                Create_blockbuild.MODID,
                "other/" + blockId.getNamespace() + "/" + blockId.getPath()
        );

        writer.accept(new FinishedRecipe() {
            @Override
            public void serializeRecipeData(JsonObject json) {
                json.addProperty("type", "create:mixing");

                JsonArray ingredients = new JsonArray();

                JsonObject mainBlock = new JsonObject();
                mainBlock.addProperty("item", blockId.toString());
                ingredients.add(mainBlock);

                JsonObject essence = new JsonObject();
                essence.addProperty("item", "create_blockbuild:world_essence");
                ingredients.add(essence);

                JsonObject fluid = new JsonObject();
                fluid.addProperty("fluid", "create_enchantment_industry:hyper_experience");
                fluid.addProperty("amount", 500);
                ingredients.add(fluid);

                json.add("ingredients", ingredients);

                JsonArray results = new JsonArray();

                JsonObject blockResult = new JsonObject();
                blockResult.addProperty("item", blockId.toString());
                blockResult.addProperty("count", 9);
                results.add(blockResult);

                JsonObject emptyEssence = new JsonObject();
                emptyEssence.addProperty("item", "create_blockbuild:world_essence_empty");
                emptyEssence.addProperty("count", 1);
                results.add(emptyEssence);

                json.add("results", results);
            }

            @Override
            public ResourceLocation getId() {
                return recipeId;
            }

            @Override
            public RecipeSerializer<?> getType() {
                // TODO: your second recipe's serializer
                return net.minecraftforge.registries.ForgeRegistries.RECIPE_SERIALIZERS.getValue(
                        new ResourceLocation("yourmod", "other_recipe_type")
                );
            }

            @Override
            public @Nullable JsonObject serializeAdvancement() {
                return null;
            }

            @Override
            public @Nullable ResourceLocation getAdvancementId() {
                return null;
            }
        });
    }
}