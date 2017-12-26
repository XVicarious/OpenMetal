package us.xvicario.openmetal.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import slimeknights.mantle.block.EnumBlock;
import us.xvicario.openmetal.CreativeTabOpenMetal;
import us.xvicario.openmetal.EnumMetal;
import us.xvicario.openmetal.IVariant;
import us.xvicario.openmetal.ModOpenMetal;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Created by XVicarious on 12/3/2017.
 */
public class BlockOMMetal extends EnumBlock implements IMetaBlockName {

    public static final PropertyEnum<EnumMetal> TYPE = PropertyEnum.create("type", EnumMetal.class);

    public BlockOMMetal() {
        super(Material.ROCK, TYPE, EnumMetal.class);
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(CreativeTabOpenMetal.TAB_OPEN_METAL);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ItemStack getPickBlock(
            IBlockState state,
            RayTraceResult target,
            World world,
            BlockPos pos,
            EntityPlayer player) {
        return new ItemStack(
                Item.getItemFromBlock(this),
                1,
                this.getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    public ItemStack get(IVariant type, int amount) {
        return new ItemStack(this, amount, type.getMeta());
    }

    @Override
    public String getName(final ItemStack itemStack) {
        return EnumMetal.byMetadata(itemStack.getMetadata()).getName();
    }

}
