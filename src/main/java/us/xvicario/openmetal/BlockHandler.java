package us.xvicario.openmetal;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
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
        itemBlockOMOre = new ItemBlock(blockOMOre);

    }

    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @Mod.EventBusSubscriber(modid = ModOpenMetal.MODID)
    public static class RegistrationHandler {
        @SubscribeEvent
        public void registerBlocks(RegistryEvent.Register<Block> event) {
            BlockHandler.init();
            ModOpenMetal.logger.log(Level.INFO, "Registering blocks...");
            event.getRegistry().register(BlockHandler.blockOMOre);
        }

        @SubscribeEvent
        public void registerItemBlocks(RegistryEvent.Register<Item> event) {
            ModOpenMetal.logger.log(Level.INFO, "Registering item blocks...");
            ResourceLocation registryName = Preconditions.checkNotNull(BlockHandler.blockOMOre.getRegistryName(), "Block has %s null registry name", BlockHandler.blockOMOre);
            event.getRegistry().register(BlockHandler.itemBlockOMOre.setRegistryName(registryName));
        }
    }

}
