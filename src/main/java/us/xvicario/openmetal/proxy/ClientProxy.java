package us.xvicario.openmetal.proxy;

import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import us.xvicario.openmetal.BlockOMOre;
import us.xvicario.openmetal.BlockRenderRegister;
import us.xvicario.openmetal.ModOpenMetal;

import java.io.File;

/**
 * Created by XVicarious on 11/30/2017.
 */
public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    public void init(FMLInitializationEvent event) {
        super.init(event);
        BlockRenderRegister.registerBlockRenderer();
    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

}
