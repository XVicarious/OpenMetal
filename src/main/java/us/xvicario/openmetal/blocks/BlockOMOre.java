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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import us.xvicario.openmetal.CreativeTabOpenMetal;
import us.xvicario.openmetal.EnumOres;

/**
 * Created by XVicarious on 11/30/2017.
 */
public class BlockOMOre extends BlockOpenMetal implements IMetaBlockName {

    public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumOres.class);

    public BlockOMOre() {
        super(Material.ROCK, "ore");
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(CreativeTabOpenMetal.tabOpenMetal);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumOres.COPPER));
    }

    @Override
    public void getSubBlocks(CreativeTabs creativeTaba, NonNullList<ItemStack> items) {
        for (EnumOres enumOres : EnumOres.values()) {
            items.add(new ItemStack(this, 1, enumOres.getId()));
        }
    }

    @Override
    public boolean isNormalCube(IBlockState state, IBlockAccess world, BlockPos pos) {
        return true;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, TYPE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumOres) state.getValue(TYPE)).getId();
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(TYPE, EnumOres.values()[meta]);
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
        return EnumOres.getNameFromMeta(itemStack.getMetadata());
    }

    public String getName(final ItemStack itemStack) {
        return EnumOres.getNameFromMeta(itemStack.getMetadata());
    }

}
