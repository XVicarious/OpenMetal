package us.xvicario.openmetal;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;

/**
 * Created by XVicarious on 11/30/2017.
 */
public class BlockRenderRegister {

    public static void registerBlockRenderer() {

    }

    public static void reg(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(ModOpenMetal.MODID + ":" + block.getUnlocalizedName().substring(5), "dicks"));
    }

}
