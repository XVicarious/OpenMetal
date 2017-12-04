package us.xvicario.openmetal;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import us.xvicario.openmetal.blocks.BlockOMOre;
import us.xvicario.openmetal.items.ItemOMIngot;

import java.util.HashSet;
import java.util.Set;
import java.util.function.ToIntFunction;

/**
 * Created by XVicarious on 12/3/2017.
 */
@Mod.EventBusSubscriber(value = Side.CLIENT, modid = ModOpenMetal.MODID)
public class ModelHandler extends ModelHandlerBase {

    public static final ModelHandler INSTANCE = new ModelHandler();

    @SubscribeEvent
    public static void registerAllModels(final ModelRegistryEvent event) {
        //INSTANCE.registerBlockModels();
        //INSTANCE.registerItemModels();
    }

    private void registerBlockModels() {
        registerVariantBlockItemModels(BlockHandler.blockOMOre.getDefaultState(), BlockOMOre.TYPE);

        BlockHandler.RegistrationHandler.ITEM_BLOCKS.stream()
                .filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
    }

    private void registerItemModels() {
        registerVariantItemModels(ItemHandler.itemOMIngot, "ingot", ItemOMIngot.EnumType.values());

        ItemHandler.RegistrationHandler.ITEMS.stream()
                .filter(item -> !itemsRegistered.contains(item)).forEach(this::registerItemModel);
    }

}
