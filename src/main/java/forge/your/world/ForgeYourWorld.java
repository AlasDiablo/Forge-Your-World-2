package forge.your.world;

import forge.your.world.init.BlocksHandler;
import forge.your.world.init.RegisteryHolder;
import forge.your.world.proxy.ClientProxy;
import forge.your.world.proxy.IProxy;
import forge.your.world.proxy.ServerProxy;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * main class of the mod
 */
@Mod(RegisteryHolder.MOD_ID)
public class ForgeYourWorld {

    /**
     * the proxy sided (server and client)
     */
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static final Logger LOGGER = LogManager.getLogger();

    /**
     * creative tab use by the mod
     */
    public static ItemGroup FYW_GROUP = new ItemGroup("fyw.group") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlocksHandler.TERILLIUM_BLOCK);
        }
    };

    /**
     * mod constructor
     */
    public ForgeYourWorld() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    /**
     * function use for setup the mod
     * @param event forge setup event
     */
    private void setup(final FMLCommonSetupEvent event) {
        proxy.startWorldGen();
    }
}
