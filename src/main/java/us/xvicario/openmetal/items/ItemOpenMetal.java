package us.xvicario.openmetal.items;

import net.minecraft.item.Item;
import us.xvicario.openmetal.CreativeTabOpenMetal;
import us.xvicario.openmetal.ModOpenMetal;

/**
 * Created by XVicarious on 12/3/2017.
 */
public class ItemOpenMetal extends Item {
    public ItemOpenMetal(final String itemName) {
        setItemName(this, itemName);
        setCreativeTab(CreativeTabOpenMetal.tabOpenMetal);
    }
    public static void setItemName(final Item item, final String itemName) {
        item.setRegistryName(ModOpenMetal.MODID, itemName);
        item.setUnlocalizedName(item.getRegistryName().toString());
    }
}
