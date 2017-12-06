package us.xvicario.openmetal.proxy;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import us.xvicario.openmetal.ModOpenMetal;

import java.io.File;

/**
 * Created by XVicarious on 11/30/2017.
 */
public class CommonProxy {

    public static Configuration config;

    public void preInit(FMLPreInitializationEvent event) {
        ModOpenMetal.logger.debug("OpenMetal pre-initialization");
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "OpenMetal.cfg"));
        // todo: read configuration file
        // todo: packet handler
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }



}
