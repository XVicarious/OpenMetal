package us.xvicario.openmetal;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import us.xvicario.openmetal.blocks.BlockOMOre;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by XVicarious on 12/1/2017.
 */
@ObjectHolder(ModOpenMetal.MODID)
public class BlockHandler {

    public static Block blockOMOre;
    public static ItemBlock itemBlockOMOre;

    public static void init() {
        blockOMOre = new BlockOMOre();
        itemBlockOMOre = new ItemMultiTexture(blockOMOre, blockOMOre, ((BlockOMOre)blockOMOre)::getName);
    }

    @Mod.EventBusSubscriber(modid = ModOpenMetal.MODID)
    public static class RegistrationHandler {

        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            BlockHandler.init();
            event.getRegistry().register(blockOMOre);
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
            ResourceLocation registryName =
                    Preconditions.checkNotNull(
                            blockOMOre.getRegistryName(),
                            "Block %s has null registry name",
                            blockOMOre);
            ModOpenMetal.logger.debug("RegistryName is " + blockOMOre.getRegistryName());
            event.getRegistry().register(itemBlockOMOre.setRegistryName(registryName));
            ITEM_BLOCKS.add(itemBlockOMOre);
        }

    }

}
