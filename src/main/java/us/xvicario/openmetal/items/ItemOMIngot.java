package us.xvicario.openmetal.items;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import us.xvicario.openmetal.EnumMetal;
import us.xvicario.openmetal.IVariant;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by XVicarious on 12/3/2017.
 */
public class ItemOMIngot extends ItemOpenMetal {

    public ItemOMIngot() {
        super("ingot");
    }

    @Override
    @Nonnull
    public String getUnlocalizedName(final ItemStack itemStack) {
        return super.getUnlocalizedName(itemStack)
                + "."
                + EnumMetal.byMetadata(itemStack.getMetadata()).getName();
    }

    @Override
    @ParametersAreNonnullByDefault
    public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
        if (isInCreativeTab(tab)) {
            final List<ItemStack> items = Stream.of(EnumMetal.values())
                    .map(enumType -> new ItemStack(this, 1, enumType.getMeta()))
                    .collect(Collectors.toList());

            subItems.addAll(items);
        }
    }

    public ItemStack get(IVariant type, int amount) {
        return new ItemStack(this, amount, type.getMeta());
    }

}
