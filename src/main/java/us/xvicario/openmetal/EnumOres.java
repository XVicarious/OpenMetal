package us.xvicario.openmetal;

import javax.annotation.Nonnull;

/**
 * Created by XVicarious on 11/30/2017.
 */
public enum EnumOres implements IVariant {
    COPPER(0, "copper"),
    TIN(1, "tin"),
    MANGANESE(2, "manganese");

    private int id;
    private String name;

    EnumOres(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    @Nonnull
    public String getName() {
        return name;
    }

    public static String getNameFromMeta(final int id) {
        return values()[id].getName();
    }

    @Override
    public int getMeta() {
        return id;
    }

    @Override
    public String toString() {
        return getName();
    }

}
