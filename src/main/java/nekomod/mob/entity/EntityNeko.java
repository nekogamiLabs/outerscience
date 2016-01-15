package nekomod.mob.entity;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import nekomod.MainClass;
import nekomod.NekoInv;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class EntityNeko extends EntityTameable implements IInventory {
	
  //TODO make nekos have inventory, use bows, use blood to mutate
	
  private ItemStack[] inv;
  public int nekoMode;
  public int nekolvl;
  public int currentlvl;
  
  
  public EntityNeko(World par1World)
  {
    super(par1World);
    inv = new ItemStack[44];
    setSize(0.9F, 2.0F);
    getNavigator().setAvoidsWater(true);
    this.tasks.addTask(0, new EntityAISwimming(this));
    this.tasks.addTask(2, this.aiSit);
    this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
    this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
    this.tasks.addTask(5, new EntityAIAttackOnCollide(this, 2.0D, true));
    this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
    this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
    this.tasks.addTask(8, new EntityAILookIdle(this));
    this.tasks.addTask(9, new EntityAIMoveIndoors(this));
    this.tasks.addTask(10, new EntityAIRestrictOpenDoor(this));
    this.tasks.addTask(11, new EntityAIOpenDoor(this, true));
    this.tasks.addTask(12, new EntityAIMoveTowardsRestriction(this, 0.300000011920929D));
    this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
    this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
    this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
    this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityWolf.class, 200, false));
    setTamed(false);
  }
  
  //NBT
  
  public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
  {
    super.readEntityFromNBT(par1NBTTagCompound);
    setColor(par1NBTTagCompound.getInteger("Color"));
    setLvl(par1NBTTagCompound.getInteger("Level"));
    
    NBTTagList tagList = par1NBTTagCompound.getTagList("Inventory", 9);
    for(int i = 0; i < tagList.tagCount(); i++){
    	NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
    	byte slot = tag.getByte("Slot");
    	if(slot >= 0 && slot < inv.length){
    		inv[slot] = ItemStack.loadItemStackFromNBT(tag);
    	}
    }
  }
  
  //EndNBT

  private void setLvl(int integer) {
	// TODO Auto-generated method stub
	  nekolvl = integer; 
	
}

public boolean isAIEnabled() {
    return true;
  }
  
  protected void applyEntityAttributes()
  {
	  
	  super.applyEntityAttributes();
	  this.setCustomNameTag(getRandomName());
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);

      if (this.isTamed())
      {
          this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
      }
      else
      {
          this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
      }
  }

  private String getRandomName() {
	  String[] randomString = new String[45];
	  randomString[0] = "Amethyst";
	  randomString[2] = "Autumn";
	  randomString[3] = "Blossom";
	  randomString[4] = "Coral";
	  randomString[5] = "Daisy";
	  randomString[6] = "Diamond";
	  randomString[7] = "Dove";
	  randomString[8] = "Emerald";
	  randomString[9] = "Fleur";
	  randomString[10] = "Flora";
	  randomString[11] = "Gaia";
	  randomString[12] = "Garnet";
	  randomString[13] = "Ginger";
	  randomString[14] = "Harmony";
	  randomString[15] = "Hazel";
	  randomString[16] = "Indigo";
	  randomString[17] = "Ivy";
	  randomString[18] = "Iris";
	  randomString[19] = "Jade";
	  randomString[20] = "Jasimine";
	  randomString[21] = "Lily";
	  randomString[22] = "Luna";
	  randomString[23] = "Nirivana";
	  randomString[24] = "Sara";
	  randomString[25] = "Justus";
	  randomString[26] = "Renae";
	  randomString[27] = "Opal";
	  randomString[28] = "Olive";
	  randomString[29] = "Pearl";
	  randomString[30] = "Phoenix";
	  randomString[31] = "Primrose";
	  randomString[32] = "Rain";
	  randomString[33] = "River";
	  randomString[34] = "Robin";
	  randomString[35] = "Rose";
	  randomString[36] = "Sage";
	  randomString[37] = "Sapphire";
	  randomString[38] = "Sky";
	  randomString[39] = "Sol";
	  randomString[40] = "Teal";
	  randomString[41] = "Topaz";
	  randomString[42] = "Terra";
	  randomString[43] = "Willow";
	  randomString[44] = "Winter";
	  int i = (int) Math.floor(randomString.length * Math.random());

	  
	return randomString[i];
}

protected void fall(float par1)
  {
  }

  protected String getLivingSound()
  {
    return "mob.cat.meow";
  }

  protected String getHurtSound()
  {
    return "mob.cat.hitt";
  }

  protected String getDeathSound()
  {
    return "mob.cat.hitt";
  }

  protected float getSoundVolume()
  {
    return 0.3F;
  }
  
  public int getTalkInterval()
  {
      return 50;
  }

  public boolean isBreedingItem(ItemStack par1ItemStack) {
    return (par1ItemStack != null) && ((par1ItemStack.getItem() instanceof ItemSeeds));
  }

  protected boolean canDespawn()
  {
    return false;
  }

  public void setTamed(boolean par1)
  {
    super.setTamed(par1);

    if (par1)
    {
      getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
    }
    else
    {
      getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
    }
  }

  protected Item getDropItem()
  {
    return null;
  }

  public boolean canMateWith(EntityAnimal par1EntityAnimal)
  {
    if (par1EntityAnimal == this)
    {
      return false;
    }
    if (!isTamed())
    {
      return false;
    }
    if (!(par1EntityAnimal instanceof EntityNeko))
    {
      return false;
    }

    EntityNeko entityneko = (EntityNeko)par1EntityAnimal;
    return entityneko.isTamed();
  }

  protected void entityInit()
  {
    super.entityInit();
    this.dataWatcher.addObject(19, new Float(this.getHealth()));
    this.dataWatcher.addObject(18, new Byte((byte)0));
  }
  public int getColor()
  {
    return this.dataWatcher.getWatchableObjectByte(18);
  }

  public void setColor(int par1)
  {
    this.dataWatcher.updateObject(18, Byte.valueOf((byte)par1));
  }

  public boolean interact(EntityPlayer par1EntityPlayer)
  {
    ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
    currentlvl = nekolvl;

    if (isTamed())
    {
      if (itemstack != null)
      {
        if ((itemstack.getItem() instanceof ItemFood))
        {
          ItemFood itemfood = (ItemFood)itemstack.getItem();

          if ((itemfood == Items.cooked_fished) && (this.dataWatcher.getWatchableObjectFloat(19) < 20.0F))
          {
            if (!par1EntityPlayer.capabilities.isCreativeMode)
            {
              itemstack.stackSize -= 1;
            }

            this.heal((float)itemfood.func_150905_g(itemstack));

            if (itemstack.stackSize <= 0)
            {
              par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            }
            return true;
          }
        }
        if ((itemstack != null) && (itemstack.getItem() == Items.dye))
        {
          if (!par1EntityPlayer.capabilities.isCreativeMode)
          {
            itemstack.stackSize -= 1;
          }
          if (itemstack.stackSize <= 0)
          {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
          }
          setColor(itemstack.getItemDamage());
        }
        if ((itemstack !=null) && (itemstack.getItem() == Items.water_bucket))
        {
      	  if (!par1EntityPlayer.capabilities.isCreativeMode)
            {
              itemstack.stackSize -= 1;
            }
            if (itemstack.stackSize <= 0)
            {
              par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            }
            setColor(16);
        }
        
        if ((itemstack !=null) && (itemstack.getItem() == Items.redstone))
        {
        	  if (!par1EntityPlayer.capabilities.isCreativeMode)
        	  {
              itemstack.stackSize -= 1;
            }
            if (itemstack.stackSize <= 0)
            {
              par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            }
              setColor(17);
        }

      }else if (itemstack == null && par1EntityPlayer.isSneaking()){
    	  par1EntityPlayer.openGui(MainClass.modInstance, 0, worldObj, getEntityId(), 0, 0);
      }
      
      if ((this.func_152114_e(par1EntityPlayer)) && (!this.worldObj.isRemote) && (!isBreedingItem(itemstack) && !par1EntityPlayer.isSneaking()))
    	  //this.func_152114_e(par1EntityPlayer) && !this.worldObj.isClient && !this.isBreedingItem(var2)
    	  //par1EntityPlayer.getCommandSenderName().equals(getOwner())
      {
        this.aiSit.setSitting(!isSitting());
        this.isJumping = false;
        setPathToEntity((PathEntity)null);
        setTarget((Entity)null);
        setAttackTarget((EntityLivingBase)null);
        if(this.isSitting()){
        	par1EntityPlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "" + this.getCustomNameTag() + ": " + "Following"));
        }else{
        	par1EntityPlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GOLD + "" + this.getCustomNameTag() + ": " + "Waiting"));
        }
      }
      
    }
    else {
      if ((itemstack != null) && (itemstack.getItem() == Items.cooked_fished))
      {
        if (!par1EntityPlayer.capabilities.isCreativeMode)
        {
          itemstack.stackSize -= 1;
        }

        if (itemstack.stackSize <= 0)
        {
          par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
        }

        if (!this.worldObj.isRemote)
        {
          if (this.rand.nextInt(3) == 0)
          {
            setTamed(true);
            setPathToEntity((PathEntity)null);
            setAttackTarget((EntityLivingBase)null);
            playTameEffect(true);
            this.worldObj.setEntityState(this, (byte)7);
            this.aiSit.setSitting(true);
            this.setHealth(20.0F);
            this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
            this.currentlvl++;
            setLvl(currentlvl);
          }
          else
          {
            playTameEffect(false);
            this.worldObj.setEntityState(this, (byte)6);
          }
        }
        return true;
      }
    }
    return super.interact(par1EntityPlayer);
  }

public boolean attackEntityAsMob(Entity par1Entity)
  {
    int var2 = isTamed() ? 4 : 2;
    return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
  }

  public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
  {
    if (isEntityInvulnerable())
    {
      return false;
    }

    Entity var3 = par1DamageSource.getEntity();
    this.aiSit.setSitting(false);

    if ((var3 != null) && (!(var3 instanceof EntityPlayer)) && (!(var3 instanceof EntityArrow)))
    {
      par2 = (par2 + 1.0F) / 2.0F;
    }

    return super.attackEntityFrom(par1DamageSource, par2);
  }

  public boolean isAngry()
  {
    return (this.dataWatcher.getWatchableObjectByte(16) & 0x2) != 0;
  }

  public void setAngry(boolean par1)
  {
    byte var2 = this.dataWatcher.getWatchableObjectByte(16);

    if (par1)
    {
      this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 0x2)));
    }
    else
    {
      this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & 0xFFFFFFFD)));
    }
  }

  public void setAttackTarget(EntityLivingBase par1EntityLivingBase)
  {
    super.setAttackTarget(par1EntityLivingBase);

    if (par1EntityLivingBase == null)
    {
      setAngry(false);
    }
    else if (!isTamed())
    {
      setAngry(true);
    }
  }

@Override
public EntityAgeable createChild(EntityAgeable arg0) {
	// TODO Auto-generated method stub
	return null;
}

//Entity Inventory Shit

@Override
public int getSizeInventory() {
	return 44;
}

@Override
public ItemStack getStackInSlot(int slot){
	return inv[slot];
}

@Override
public void setInventorySlotContents(int slot, ItemStack stack){
	inv[slot] = stack;
	if (stack != null && stack.stackSize > getInventoryStackLimit()){
		stack.stackSize = getInventoryStackLimit();
	}
}

@Override
public ItemStack getStackInSlotOnClosing(int slot){
	ItemStack stack = getStackInSlot(slot);
	if(stack !=null){
		setInventorySlotContents(slot, null);
	}
	return stack;
}

@Override
public int getInventoryStackLimit(){
	return 64;
}

@Override
public boolean isUseableByPlayer(EntityPlayer player) {
	return true;
}

@Override
public void openInventory(){}
@Override
public void closeInventory(){}

@Override
public boolean hasCustomInventoryName(){
	return true;
}

@Override
public String getInventoryName(){
	return getRandomName();
}

public boolean isItemValidForSlot(int slot, ItemStack itemStack){
	return true;
}

@Override
public ItemStack decrStackSize(int slot, int amt) {
	ItemStack stack = getStackInSlot(slot);
	if(stack != null){
		if(stack.stackSize <= amt){
			setInventorySlotContents(slot, null);
		} else {
			stack = stack.splitStack(amt);
			if(stack.stackSize == 0){
				setInventorySlotContents(slot, null);
			}
		}
	}
	return stack;
}

@Override
public void markDirty() {
	// TODO Auto-generated method stub
}

//NBT

public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
{
  super.writeEntityToNBT(par1NBTTagCompound);
  par1NBTTagCompound.setInteger("Color", getColor());
  par1NBTTagCompound.setInteger("Level", getLevel());
  
  NBTTagList itemList = new NBTTagList();
  for (int i  = 0; i < inv.length; i++){
	  ItemStack stack = inv[i];
	  if(stack != null){
		  NBTTagCompound tag = new NBTTagCompound();
		  tag.setByte("Slot", (byte) i);
		  stack.writeToNBT(tag);
		  itemList.appendTag(tag);
	  }
  }
  par1NBTTagCompound.setTag("Inventory", itemList);
}

private int getLevel() {
	// TODO Auto-generated method stub
	return this.nekolvl;
}


//ENDNBT

}
