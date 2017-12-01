package us.xvicario.openmetal;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;

/**
 * Created by XVicarious on 11/30/2017.
 */
public class CreativeTabOpenMetal extends CreativeTabs {

    public static final CreativeTabs tabOpenMetal = new CreativeTabOpenMetal(0, ModOpenMetal.MODID);

    private final int icon;

    private CreativeTabOpenMetal(int icon, String label) {
        super(label);
        this.icon = icon;
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(new ItemCoal());
    }

}
