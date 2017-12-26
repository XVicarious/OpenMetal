package us.xvicario.openmetal.base.block;

import net.minecraft.block.properties.PropertyEnum;
import us.xvicario.openmetal.blocks.BlockOpenMetal;
import us.xvicario.openmetal.blocks.EnumOres;

public class BlockBaseMetalOre extends BlockOpenMetal {

    public static final PropertyEnum<EnumOres> TYPE = PropertyEnum.create("type", EnumOres.class);

    public BlockBaseMetalOre() {
        super(TYPE);
    }

}
