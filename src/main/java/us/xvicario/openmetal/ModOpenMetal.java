package us.xvicario.openmetal;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import slimeknights.mantle.pulsar.control.PulseManager;
import slimeknights.mantle.pulsar.debug.EventSpy;
import us.xvicario.openmetal.base.BaseMetal;

/**
 * Created by XVicarious on 11/30/2017.
 */
@Mod.EventBusSubscriber(modid = ModOpenMetal.MODID)
@Mod(modid = ModOpenMetal.MODID, version = ModOpenMetal.VERSION, name = ModOpenMetal.NAME)
public class ModOpenMetal {

    public static final String MODID = "openmetal";
    public static final String VERSION = "0.0.1";
    public static final String NAME = "OpenMetal";

    @Mod.Instance(MODID)
    public static ModOpenMetal instance;

    private static PulseManager manager;

    public static Logger logger;

    static {

        manager = new PulseManager(MODID);

        manager.registerPulse(new EventSpy());
        manager.registerPulse(new BaseMetal());

    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {

    }

}
