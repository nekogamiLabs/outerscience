package nekomod;


import nekomod.mob.entity.EntityNeko;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GUIhandler implements IGuiHandler {

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	  {
	  if(ID == 0){
		  EntityNeko entity;
		  TileEntity te;
	  
		  entity = (EntityNeko)world.getEntityByID(x);
		  if(entity!=null)
		  {
			  return new NekoInv(player.inventory, entity);
		  }
	  }
	  
	  return null;
	  }
	  

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	  { 
		if(ID == 0){
			EntityNeko entity;
	  
			entity = (EntityNeko)world.getEntityByID(x);
			if(entity!=null)
			{
				return new NekoGui(player.inventory, (EntityNeko)entity);
			}
		}
		
	  return null;
	   
	  }
	
}
