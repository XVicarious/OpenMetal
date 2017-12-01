package us.xvicario.openmetal;

import net.minecraft.util.IStringSerializable;

/**
 * Created by XVicarious on 11/30/2017.
 */
public enum EnumOres implements IStringSerializable {
    COPPER(0, "copper"),
    TIN(1, "tin"),
    MANGANESE(2, "manganese");
    private int id;
    private String name;
    private EnumOres(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return getName();
    }
}