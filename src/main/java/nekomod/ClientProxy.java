package nekomod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import nekomod.mob.entity.EntityNeko;
import nekomod.mob.model.Neko;
import nekomod.mob.render.NekoRender;

public class ClientProxy extends CommonProxy
{
  public void registerRenderInformation()
  {
    RenderingRegistry.registerEntityRenderingHandler(EntityNeko.class, new NekoRender(new Neko(), 0.3F));  
  }
  
}
