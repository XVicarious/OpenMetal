package us.xvicario.openmetal.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import us.xvicario.openmetal.IVariant;

import java.util.Comparator;
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
    public String getUnlocalizedName(final ItemStack itemStack) {
        return super.getUnlocalizedName(itemStack) + "." + EnumType.byMetadata(itemStack.getMetadata()).getName();
    }

    @Override
    public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
        if (isInCreativeTab(tab)) {
            final List<ItemStack> items = Stream.of(EnumType.values())
                    .map(enumType -> new ItemStack(this, 1, enumType.getMeta()))
                    .collect(Collectors.toList());

            subItems.addAll(items);
        }
    }


    public enum EnumType implements IVariant {
        COPPER(0, "copper"),
        TIN(1, "tin"),
        MANGANESE(2, "manganese"),
        BRONZE(3, "bronze"),
        HEPATIZON(4, "hepatizon"),
        ANGMALLEN(5, "angmallen");

        private static final EnumType[] META_LOOKUP = Stream.of(values()).sorted(Comparator.comparing(EnumType::getMeta)).toArray(EnumType[]::new);

        private final int meta;
        private final String name;

        EnumType(final int meta, final String name) {
            this.meta = meta;
            this.name = name;
        }

        @Override
        public int getMeta() {
            return meta;
        }

        @Override
        public String getName() {
            return name;
        }

        public static EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }
            return META_LOOKUP[meta];
        }
    }
}
