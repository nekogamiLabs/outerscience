package nekomod;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy
  implements IGuiHandler
{
  public void registerRenderInformation()
  {
  }

  public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
  {
    return null;
  }

  public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    return null;
  }

  
  public void preInit(FMLPreInitializationEvent e) {
	  
  }
  public void init(FMLInitializationEvent e) {
      NetworkRegistry.INSTANCE.registerGuiHandler(MainClass.modInstance, new GUIhandler());
  }
  public void registerTileEntities(){
  }
}
