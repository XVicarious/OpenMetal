package us.xvicario.openmetal.proxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.LoaderState;
import us.xvicario.openmetal.ModOpenMetal;

public class CommonProxy {

    public void preInit() {
        if (!Loader.instance().isInState(LoaderState.PREINITIALIZATION)) {
            ModOpenMetal.logger.error("Proxy.preInit has to be called during the pre-initialization");
        }
    }

    public void init() {
        if (!Loader.instance().isInState(LoaderState.INITIALIZATION)) {
            ModOpenMetal.logger.error("Proxy.init has to be called during the initialization");
        }
    }

    public void postInit() {
        if (!Loader.instance().isInState(LoaderState.POSTINITIALIZATION)) {
            ModOpenMetal.logger.error("Proxy.postInit has to be called during the post-initialization");
        }
    }

    public void registerModels() {
        if (!Loader.instance().isInState(LoaderState.PREINITIALIZATION)) {
            ModOpenMetal.logger.error("Proxy.registerModels has to be called during the pre-initialization");
        }
    }

}
