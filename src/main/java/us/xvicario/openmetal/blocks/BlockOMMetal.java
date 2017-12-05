package us.xvicario.openmetal.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import us.xvicario.openmetal.CreativeTabOpenMetal;
import us.xvicario.openmetal.IVariant;
import us.xvicario.openmetal.items.ItemOMIngot;

/**
 * Created by XVicarious on 12/3/2017.
 */
public class BlockOMMetal extends BlockOpenMetal implements IMetaBlockName {

    public static final PropertyEnum TYPE = PropertyEnum.create("type", ItemOMIngot.EnumType.class);

    public BlockOMMetal() {
        super(Material.ROCK, "metal");
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(CreativeTabOpenMetal.tabOpenMetal);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, ItemOMIngot.EnumType.COPPER));
    }

    @Override
    public void getSubBlocks(CreativeTabs creativeTabs, NonNullList<ItemStack> items) {
        for (ItemOMIngot.EnumType enumOres : ItemOMIngot.EnumType.values()) {
            items.add(new ItemStack(this, 1, enumOres.getMeta()));
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((ItemOMIngot.EnumType) state.getValue(TYPE)).getMeta();
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, ItemOMIngot.EnumType.values()[meta]);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    public String getSpecialName(ItemStack itemStack) {
        return ItemOMIngot.EnumType.byMetadata(itemStack.getMetadata()).getName();
    }

    @Override
    public ItemStack get(IVariant type, int amount) {
        return new ItemStack(this, amount, type.getMeta());
    }

    public String getName(final ItemStack itemStack) {
        return ItemOMIngot.EnumType.byMetadata(itemStack.getMetadata()).getName();
    }

}
