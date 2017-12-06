package us.xvicario.openmetal;

import us.xvicario.openmetal.items.ItemOMIngot;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by XVicarious on 12/6/2017.
 */
public enum EnumMetal implements IVariant {
    COPPER(0, "copper"),
    TIN(1, "tin"),
    MANGANESE(2, "manganese"),
    BRONZE(3, "bronze"),
    HEPATIZON(4, "hepatizon"),
    ANGMALLEN(5, "angmallen");

    private static final EnumMetal[] META_LOOKUP = Stream.of(values())
            .sorted(Comparator.comparing(EnumMetal::getMeta)).toArray(EnumMetal[]::new);

    private final int meta;
    private final String name;

    EnumMetal(final int meta, final String name) {
        this.meta = meta;
        this.name = name;
    }

    @Override
    public int getMeta() {
        return meta;
    }

    @Override
    @Nonnull
    public String getName() {
        return name;
    }

    public static EnumMetal byMetadata(int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }
        return META_LOOKUP[meta];
    }

}
