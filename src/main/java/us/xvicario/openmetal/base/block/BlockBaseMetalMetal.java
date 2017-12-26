package us.xvicario.openmetal.base.block;

import net.minecraft.block.properties.PropertyEnum;
import us.xvicario.openmetal.EnumMetal;
import us.xvicario.openmetal.blocks.BlockOpenMetal;

public class BlockBaseMetalMetal extends BlockOpenMetal {

    public static final PropertyEnum<EnumMetal> TYPE = PropertyEnum.create("type", EnumMetal.class);

    public BlockBaseMetalMetal() {
        super(TYPE);
    }

}
