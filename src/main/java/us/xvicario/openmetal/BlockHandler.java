package us.xvicario.openmetal;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import us.xvicario.openmetal.blocks.BlockOMMetal;
import us.xvicario.openmetal.blocks.BlockOMOre;
import us.xvicario.openmetal.items.ItemOMIngot;

import java.util.HashSet;
import java.util.Set;

import static us.xvicario.openmetal.InjectionUtils.Null;

/**
 * Created by XVicarious on 12/1/2017.
 */
@ObjectHolder(ModOpenMetal.MODID)
public class BlockHandler {

    public static BlockOMOre OM_ORE = new BlockOMOre();

    public static BlockOMMetal OM_METAL = new BlockOMMetal();

    @Mod.EventBusSubscriber(modid = ModOpenMetal.MODID)
    public static class RegistrationHandler {

        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();
            final Block[] blocks = {
                    OM_ORE,
                    OM_METAL
            };
            registry.registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();
            final ItemBlock[] items = {
                    new ItemMultiTexture(OM_ORE, OM_ORE, OM_ORE::getName),
                    new ItemMultiTexture(OM_METAL, OM_METAL, OM_METAL::getName)
            };
            for (final ItemBlock item : items) {
                final Block block = item.getBlock();
                final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
                registry.register(item.setRegistryName(registryName));
                ITEM_BLOCKS.add(item);
            }
            for (ItemOMIngot.EnumType resourceType : ItemOMIngot.EnumType.values()) {
                OreDictionary.registerOre(OreDictUtils.metalNames[resourceType.getMeta()], BlockHandler.OM_METAL.get(resourceType, 1));
            }
        }

    }

}
