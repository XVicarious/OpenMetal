package us.xvicario.openmetal;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Level;

/**
 * Created by XVicarious on 12/1/2017.
 */
@ObjectHolder(ModOpenMetal.MODID)
public class BlockHandler {

    public static Block blockOMOre;
    public static ItemBlock itemBlockOMOre;

    public static void init() {
        blockOMOre = new BlockOMOre();
        blockOMOre.setRegistryName("ore");
        itemBlockOMOre = new ItemBlockMeta(blockOMOre);

    }

    @Mod.EventBusSubscriber(modid = ModOpenMetal.MODID)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            BlockHandler.init();
            event.getRegistry().register(BlockHandler.blockOMOre);;
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
            ResourceLocation registryName =
                    Preconditions.checkNotNull(
                            BlockHandler.blockOMOre.getRegistryName(),
                            "Block has %s null registry name",
                            BlockHandler.blockOMOre);
            ModOpenMetal.logger.info("RegistryName is " + BlockHandler.blockOMOre.getRegistryName());
            event.getRegistry().register(BlockHandler.itemBlockOMOre.setRegistryName(registryName));
        }

        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void registerModel(ModelRegistryEvent event) {
            for (int i = 0; i < EnumOres.values().length; i++) {
                ModelLoader.setCustomModelResourceLocation(
                        Item.getItemFromBlock(blockOMOre),
                        i,
                        new ModelResourceLocation(
                                blockOMOre.getRegistryName(),
                                "inventory")
                );
                ModelBakery.registerItemVariants(Item.getItemFromBlock(blockOMOre));
            }
        }

    }

}
