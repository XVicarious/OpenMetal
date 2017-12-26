package us.xvicario.openmetal.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.item.ItemMetaDynamic;

/**
 * Created by XVicarious on 12/24/2017.
 */
public class ItemMetalMeta extends ItemMetaDynamic {

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            for (int i = 0; i <= availabilityMask.length; i++) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
    }

}
