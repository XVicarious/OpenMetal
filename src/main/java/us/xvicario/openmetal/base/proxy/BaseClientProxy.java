package us.xvicario.openmetal.base.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.item.ItemBlockMeta;
import us.xvicario.openmetal.ModOpenMetal;
import us.xvicario.openmetal.proxy.CommonProxy;

import static us.xvicario.openmetal.base.BaseMetal.blockOre;

@SideOnly(Side.CLIENT)
public class BaseClientProxy extends CommonProxy {
    
    @Override
    public void registerModels() {
        super.registerModels();
        registerItemBlockMeta(blockOre);
    }

    public static void registerItemBlockMeta(Block block) {
        if (block != null) {
            Item item = Item.getItemFromBlock(block);
            if (item instanceof ItemBlockMeta) {
                ((ItemBlockMeta) item).registerItemModels();
            } else {
                ModOpenMetal.logger.error("Trying to register an ItemBlockMeta model for a non itemblockmeta block: " + block.getRegistryName());
            }
        }
    }

}
