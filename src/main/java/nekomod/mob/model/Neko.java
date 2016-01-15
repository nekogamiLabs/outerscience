package nekomod.mob.model;

import org.lwjgl.opengl.GL11;

import nekomod.mob.entity.EntityNeko;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Neko extends ModelBase
{
	  //fields
	    ModelRenderer tail;
	    ModelRenderer head;
	    ModelRenderer body;
	    ModelRenderer rightarm;
	    ModelRenderer leftarm;
	    ModelRenderer rightleg;
	    ModelRenderer leftleg;
	    ModelRenderer chest;
	    ModelRenderer rightEar;
	    ModelRenderer leftEar;
	    ModelRenderer hairOverlay;
	  
	  public Neko()
	  {
	    textureWidth = 64;
	    textureHeight = 64;
	    
	      tail = new ModelRenderer(this, 0, 32);
	      tail.addBox(-1F, -1F, 0F, 2, 2, 9);
	      tail.setRotationPoint(0F, 9F, 1F);
	      tail.setTextureSize(64, 64);
	      tail.mirror = true;
	      setRotation(tail, -0.7853982F, 0F, 0F);
	      head = new ModelRenderer(this, 0, 0);
	      head.addBox(-4F, -8F, -4F, 8, 8, 8);
	      head.setRotationPoint(0F, 0F, 0F);
	      head.setTextureSize(64, 64);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      body = new ModelRenderer(this, 16, 16);
	      body.addBox(-4F, 0F, -2F, 8, 12, 4);
	      body.setRotationPoint(0F, 0F, 0F);
	      body.setTextureSize(64, 64);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      rightarm = new ModelRenderer(this, 40, 16);
	      rightarm.addBox(-2F, -2F, -2F, 3, 12, 4);
	      rightarm.setRotationPoint(-5F, 2F, 0F);
	      rightarm.setTextureSize(64, 64);
	      rightarm.mirror = true;
	      setRotation(rightarm, 0F, 0F, 0F);
	      leftarm = new ModelRenderer(this, 40, 16);
	      leftarm.addBox(-1F, -2F, -2F, 3, 12, 4);
	      leftarm.setRotationPoint(5F, 2F, 0F);
	      leftarm.setTextureSize(64, 64);
	      leftarm.mirror = true;
	      setRotation(leftarm, 0F, 0F, 0F);
	      rightleg = new ModelRenderer(this, 0, 16);
	      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
	      rightleg.setRotationPoint(-2F, 12F, 0F);
	      rightleg.setTextureSize(64, 64);
	      rightleg.mirror = true;
	      setRotation(rightleg, 0F, 0F, 0F);
	      leftleg = new ModelRenderer(this, 0, 16);
	      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
	      leftleg.setRotationPoint(2F, 12F, 0F);
	      leftleg.setTextureSize(64, 64);
	      leftleg.mirror = true;
	      setRotation(leftleg, 0F, 0F, 0F);
	      chest = new ModelRenderer(this, 18, 19);
	      chest.addBox(-4F, 0F, -1F, 8, 4, 2);
	      chest.setRotationPoint(0F, 2F, -2F);
	      chest.setTextureSize(64, 64);
	      chest.mirror = true;
	      setRotation(chest, 0F, 0F, 0F);
	      rightEar = new ModelRenderer(this, 0, 3);
	      rightEar.addBox(1F, -10F, -2F, 2, 2, 1);
	      rightEar.setRotationPoint(0F, 0F, 0F);
	      rightEar.setTextureSize(64, 64);
	      rightEar.mirror = true;
	      setRotation(rightEar, 0F, 0F, 0F);
	      leftEar = new ModelRenderer(this, 0, 0);
	      leftEar.addBox(-3F, -10F, -2F, 2, 2, 1);
	      leftEar.setRotationPoint(0F, 0F, 0F);
	      leftEar.setTextureSize(64, 64);
	      leftEar.mirror = true;
	      setRotation(leftEar, 0F, 0F, 0F);
	      hairOverlay = new ModelRenderer(this, 32, 8);
	      hairOverlay.addBox(-4F, -8F, -4.3F, 8, 8, 0);
	      hairOverlay.setRotationPoint(0F, 0F, 0F);
	      hairOverlay.setTextureSize(64, 64);
	      hairOverlay.mirror = true;
	      setRotation(hairOverlay, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    tail.render(f5);
	    head.render(f5);
	    body.render(f5);
	    rightarm.render(f5);
	    leftarm.render(f5);
	    rightleg.render(f5);
	    leftleg.render(f5);
	    chest.render(f5);
	    rightEar.render(f5);
	    leftEar.render(f5);
	    hairOverlay.render(f5);
	  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
    EntityNeko var5 = (EntityNeko)par7Entity;
    
    this.head.rotateAngleY = (par4 / 57.295776F);
    this.head.rotateAngleX = (par5 / 54.112679F);
    this.hairOverlay.rotateAngleY = (par4 / 57.295776F);
    this.hairOverlay.rotateAngleX = (par5 / 54.112679F);
    this.leftEar.rotateAngleY = (par4 / 57.295776F);
    this.leftEar.rotateAngleX = (par5 / 54.112679F);
    this.rightEar.rotateAngleY = (par4 / 57.295776F);
    this.rightEar.rotateAngleX = (par5 / 54.112679F);
    this.rightarm.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 2.0F * par2 * 0.5F);
    this.leftarm.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F);
    this.rightarm.rotateAngleZ = 0.0F;
    this.leftarm.rotateAngleZ = 0.0F;
    this.rightleg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F) * 1.4F * par2);
    this.leftleg.rotateAngleX = (MathHelper.cos(par1 * 0.6662F + 3.141593F) * 1.4F * par2);
    this.rightleg.rotateAngleZ = 0.0F;
    this.leftleg.rotateAngleZ = 0.0F;
    this.tail.rotateAngleZ = 0.0F;
    //scale code to make the nekos not so tall
    GL11.glScalef(0.9F, 0.9F, 0.9F);
    GL11.glTranslatef(0.0F, 0.1F, 0.0F);
    
    if (var5.isSitting())
    {
      this.tail.rotateAngleZ = 3.0F;
    }
    
      
    
  }
}
