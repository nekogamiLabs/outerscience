package nekomod.mob.render;

import nekomod.mob.entity.EntityNeko;
import nekomod.mob.model.Neko;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class NekoRender extends RenderLiving
{
  private static ResourceLocation base = new ResourceLocation("outerscience:textures/mobs/nekoSkin.png");
  private static ResourceLocation Black = new ResourceLocation("outerscience:textures/mobs/blackNeko.png");
  private static ResourceLocation Red = new ResourceLocation("outerscience:textures/mobs/redNeko.png");
  private static ResourceLocation Green = new ResourceLocation("outerscience:textures/mobs/greenNeko.png");
  private static ResourceLocation Brown = new ResourceLocation("outerscience:textures/mobs/brownNeko.png");
  private static ResourceLocation Blue = new ResourceLocation("outerscience:textures/mobs/blueNeko.png");
  private static ResourceLocation Purple = new ResourceLocation("outerscience:textures/mobs/purpleNeko.png");
  private static ResourceLocation Cyan = new ResourceLocation("outerscience:textures/mobs/cyanNeko.png");
  private static ResourceLocation Lgrey = new ResourceLocation("outerscience:textures/mobs/lgreyNeko.png");
  private static ResourceLocation Grey = new ResourceLocation("outerscience:textures/mobs/greyNeko.png");
  private static ResourceLocation Pink = new ResourceLocation("outerscience:textures/mobs/pinkNeko.png");
  private static ResourceLocation Lime = new ResourceLocation("outerscience:textures/mobs/limeNeko.png");
  private static ResourceLocation Yellow = new ResourceLocation("outerscience:textures/mobs/yellowNeko.png");
  private static ResourceLocation Lblue = new ResourceLocation("outerscience:textures/mobs/lightblueNeko.png");
  private static ResourceLocation Magenta = new ResourceLocation("outerscience:textures/mobs/magentaNeko.png");
  private static ResourceLocation Orange = new ResourceLocation("outerscience:textures/mobs/orangeNeko.png");
  private static ResourceLocation White = new ResourceLocation("outerscience:textures/mobs/whiteNeko.png");
  private static ResourceLocation RedStone = new ResourceLocation("outerscience:textures/mobs/redstoneNeko.png");
  private static ResourceLocation Bikini = new ResourceLocation("outerscience:textures/mobs/bikiniNeko.png");
  protected Neko model;

  public NekoRender(ModelBase p_i1262_1_, float p_i1262_2_)
  {
    super(p_i1262_1_, p_i1262_2_);
    this.model = ((Neko)this.mainModel);
  }

  protected ResourceLocation getlightTextures(EntityNeko par1Entity) {
    switch (par1Entity.getColor())
    {
    case 1:
      return Red;
    case 2:
      return Green;
    case 3:
      return Brown;
    case 4:
      return Blue;
    case 5:
      return Purple;
    case 6:
      return Cyan;
    case 7:
      return Lgrey;
    case 8:
      return Grey;
    case 9:
      return Pink;
    case 10:
      return Lime;
    case 11:
      return Yellow;
    case 12:
      return Lblue;
    case 13:
      return Magenta;
    case 14:
      return Orange;
    case 15:
      return White;
    case 16:
      return Bikini;
    case 17:
      return RedStone;
    default:
      return base;
    }
  }

  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getlightTextures((EntityNeko)entity);
  }
}
