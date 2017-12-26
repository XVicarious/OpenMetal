package us.xvicario.openmetal.base;

import com.google.common.eventbus.Subscribe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.pulsar.pulse.Pulse;
import us.xvicario.openmetal.EnumMetal;
import us.xvicario.openmetal.OMPulse;
import us.xvicario.openmetal.base.block.BlockBaseMetalMetal;
import us.xvicario.openmetal.base.block.BlockBaseMetalOre;
import us.xvicario.openmetal.blocks.EnumOres;
import us.xvicario.openmetal.proxy.CommonProxy;

@Pulse(id = BaseMetal.PULSE_ID)
public class BaseMetal extends OMPulse {

    public static final String PULSE_ID = "basemetal";

    @SidedProxy(clientSide = "us.xvicario.openmetal.base.proxy.BaseClientProxy", serverSide = "us.xvicario.openmetal.base.proxy.BaseServerProxy")
    public static CommonProxy proxy;

    public static BlockBaseMetalOre blockOre;
    public static BlockBaseMetalMetal blockMetal;

    public static ItemStack[] itemBlockOre;
    public static ItemStack[] itemBlockMetal;

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {

        IForgeRegistry<Block> registry = event.getRegistry();

        blockOre = registerBlock(registry, new BlockBaseMetalOre(), "ore");
        blockMetal = registerBlock(registry, new BlockBaseMetalMetal(), "metal");

    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {

        IForgeRegistry<Item> registry = event.getRegistry();

        blockOre = registerEnumItemBlock(registry, blockOre);
        blockMetal = registerEnumItemBlock(registry, blockMetal);

        itemBlockOre = new ItemStack[EnumOres.values().length];
        for (EnumOres ore : EnumOres.values()) {
            itemBlockOre[ore.getMeta()] = new ItemStack(blockOre, 1, ore.getMeta());
        }

        itemBlockMetal = new ItemStack[EnumMetal.values().length];
        for (EnumMetal metal : EnumMetal.values()) {
            itemBlockMetal[metal.getMeta()] = new ItemStack(blockMetal, 1, metal.getMeta());
        }

    }

    @Subscribe
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        proxy.registerModels();
    }

}
