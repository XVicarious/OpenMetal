package us.xvicario.openmetal;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import slimeknights.mantle.block.EnumBlock;
import slimeknights.mantle.item.ItemBlockMeta;

import java.util.Locale;

public abstract class OMPulse {

    protected static <T extends Block> T registerBlock(IForgeRegistry<Block> registry, T block, String name) {
        if (!name.equals(name.toLowerCase(Locale.US))) {
            throw new IllegalArgumentException(String.format("Unlocalized names need to be all lowercase! Block %s", name));
        }
        String prefixedName = String.format("%s.%s", ModOpenMetal.MODID, name.toLowerCase(Locale.US));
        block.setUnlocalizedName(prefixedName);
        register(registry, block, name);
        return block;
    }

    protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, String name) {
        thing.setRegistryName(new ResourceLocation(ModOpenMetal.MODID, name));
        registry.register(thing);
        return thing;
    }

    protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, ResourceLocation name) {
        thing.setRegistryName(name);
        registry.register(thing);
        return thing;
    }

    protected static <T extends EnumBlock<?>> T registerEnumItemBlock(IForgeRegistry<Item> registry, T block) {
        ItemBlock itemBlock = new ItemBlockMeta(block);

        itemBlock.setUnlocalizedName(block.getUnlocalizedName());

        register(registry, itemBlock, block.getRegistryName());
        ItemBlockMeta.setMappingProperty(block, block.prop);
        return block;
    }

}
