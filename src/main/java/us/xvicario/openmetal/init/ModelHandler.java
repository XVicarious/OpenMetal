package us.xvicario.openmetal.init;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import us.xvicario.openmetal.EnumMetal;
import us.xvicario.openmetal.ModOpenMetal;
import us.xvicario.openmetal.ModelHandlerBase;
import us.xvicario.openmetal.blocks.BlockOMMetal;
import us.xvicario.openmetal.blocks.BlockOMOre;

/**
 * Created by XVicarious on 12/3/2017.
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = ModOpenMetal.MODID)
public class ModelHandler extends ModelHandlerBase {

    public static final ModelHandler INSTANCE = new ModelHandler();

    @SubscribeEvent
    public static void registerAllModels(final ModelRegistryEvent event) {
        INSTANCE.registerBlockModels();
        INSTANCE.registerItemModels();
    }

    private void registerBlockModels() {
        registerVariantBlockItemModels(BlockHandler.OM_ORE.getDefaultState(), BlockOMOre.TYPE);
        registerVariantBlockItemModels(BlockHandler.OM_METAL.getDefaultState(), BlockOMMetal.TYPE);

        BlockHandler.RegistrationHandler.ITEM_BLOCKS.stream()
                .filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
    }

    private void registerItemModels() {
        registerVariantItemModels(ItemHandler.OM_INGOT, "ingot", EnumMetal.values());

        ItemHandler.RegistrationHandler.ITEMS.stream()
                .filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
    }

}
