package us.xvicario.openmetal;

import net.minecraft.util.IStringSerializable;
import slimeknights.mantle.block.EnumBlock;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Created by XVicarious on 12/6/2017.
 */
public enum EnumMetal implements EnumBlock.IEnumMeta, IStringSerializable, IVariant {
    COPPER,
    TIN,
    MANGANESE,
    BRONZE,
    HEPATIZON,
    ANGMALLEN;

    private static final EnumMetal[] META_LOOKUP = Stream.of(values())
            .sorted(Comparator.comparing(EnumMetal::getMeta)).toArray(EnumMetal[]::new);

    private final int meta;

    EnumMetal() {
        this.meta = ordinal();
    }

    @Override
    public int getMeta() {
        return meta;
    }

    @Nonnull
    public String getName() {
        return this.toString().toLowerCase(Locale.US);
    }

    public static EnumMetal byMetadata(int meta) {
        if (meta < 0 || meta >= META_LOOKUP.length) {
            meta = 0;
        }
        return META_LOOKUP[meta];
    }

}
