package us.xvicario.openmetal;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import us.xvicario.openmetal.proxy.CommonProxy;

/**
 * Created by XVicarious on 11/30/2017.
 */
@Mod.EventBusSubscriber(modid = ModOpenMetal.MODID)
@Mod(modid = ModOpenMetal.MODID, version = ModOpenMetal.VERSION, name = ModOpenMetal.NAME)
public class ModOpenMetal {
    public static final String MODID = "openmetal";
    public static final String VERSION = "0.0.1";
    public static final String NAME = "OpenMetal";

    @SidedProxy(clientSide = "us.xvicario.openmetal.proxy.ClientProxy", serverSide = "us.xvicario.openmetal.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static ModOpenMetal instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {

    }

}
