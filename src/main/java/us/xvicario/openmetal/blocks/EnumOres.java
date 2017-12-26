package us.xvicario.openmetal.blocks;

import net.minecraft.util.IStringSerializable;
import slimeknights.mantle.block.EnumBlock;
import us.xvicario.openmetal.IVariant;

import javax.annotation.Nonnull;
import java.util.Locale;

/**
 * Created by XVicarious on 12/24/2017.
 */
public enum EnumOres implements EnumBlock.IEnumMeta, IStringSerializable, IVariant {
    COPPER,
    TIN,
    MANGANESE;

    private final int id;

    EnumOres() {
        this.id = ordinal();
    }

    @Nonnull
    public String getName() {
        return this.toString().toLowerCase(Locale.US);
    }

    public static String getNameFromMeta(final int id) {
        return EnumOres.values()[id].getName();
    }

    @Override
    public int getMeta() {
        return id;
    }

}
