package us.xvicario.openmetal.blocks;

import net.minecraft.item.ItemStack;
import us.xvicario.openmetal.IVariant;

/**
 * Created by XVicarious on 11/30/2017.
 */
public interface IMetaBlockName {

    String getName(ItemStack itemStack);

    ItemStack get(IVariant type, int amount);

}
