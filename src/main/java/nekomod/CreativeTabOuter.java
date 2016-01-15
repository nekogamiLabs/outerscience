package nekomod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabOuter extends CreativeTabs {

	public CreativeTabOuter(String tabLabel)
	{
		super(tabLabel);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
	return Item.getItemFromBlock(Blocks.end_stone);
	}

}
