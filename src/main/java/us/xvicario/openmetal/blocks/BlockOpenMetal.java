package us.xvicario.openmetal.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import us.xvicario.openmetal.ModOpenMetal;

/**
 * Created by XVicarious on 12/3/2017.
 */
public abstract class BlockOpenMetal extends Block implements IMetaBlockName {

    BlockOpenMetal(final Material material, final String blockName) {
        super(material, material.getMaterialMapColor());
        setBlockName(this, blockName);
    }

    public static void setBlockName(final Block block, final String blockName) {
        block.setRegistryName(ModOpenMetal.MODID, blockName);
        block.setUnlocalizedName(block.getRegistryName().toString());
    }
}
