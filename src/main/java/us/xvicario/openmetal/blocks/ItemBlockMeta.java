package us.xvicario.openmetal.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import us.xvicario.openmetal.ModOpenMetal;

/**
 * Created by XVicarious on 12/1/2017.
 */
public class ItemBlockMeta extends ItemBlock {


    public ItemBlockMeta(Block block) {
        super(block);
        if (!(block instanceof IMetaBlockName)) {
            throw new IllegalArgumentException(String.format("The given Block %s is not an instance of ISpecialBlockName!", block.getUnlocalizedName()));
        }
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile." + ModOpenMetal.MODID + ":ore." + ((IMetaBlockName)this.block).getSpecialName(stack);
    }
}
