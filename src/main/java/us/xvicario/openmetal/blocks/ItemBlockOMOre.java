package us.xvicario.openmetal.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by XVicarious on 11/30/2017.
 */
public class ItemBlockOMOre extends ItemBlock {

    public ItemBlockOMOre(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return super.getUnlocalizedName(itemStack) + "." + ((IMetaBlockName) this.block).getSpecialName(itemStack);
    }

}
