package medar.create_blockbuild.datagen;
import com.google.gson.JsonObject;
import medar.create_blockbuild.Create_blockbuild;
import net.minecraft.data.DataGenerator;
import com.google.gson.JsonArray;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Create_blockbuild.MODID)

public class XpRecipeProvider {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();

        generator.addProvider(event.includeServer(), new XPrp(output));
        //generator.addProvider(event.includeServer(), new HXPrp(output));
    }
}