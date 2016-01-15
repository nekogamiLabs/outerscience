package nekomod.fluids;

import nekomod.MainClass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FluidLcl extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
	public static IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    public static IIcon flowingIcon;
   
    public FluidLcl(Fluid fluid, Material material) {
            super(fluid, material);
            setCreativeTab(MainClass.tabMyMod);
            this.setRenderPass(1);
            this.setQuantaPerBlock(8);
            String name = "lcl";
			this.setBlockName(name);
    }
   
    @Override
    public IIcon getIcon(int side, int meta) {
    	//return (side == 0 || side == 1)? stillIcon : flowingIcon;
    	return stillIcon;
    	
    }
   
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon("outerscience:lcl_still");
            flowingIcon = register.registerIcon("outerscience:lcl_flow");
    }
   
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
   
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
   
}