package nekomod;

//these are the imports, the code this code refers to.
import nekomod.fluids.FluidLcl;
import nekomod.items.ItemDNA;
import nekomod.items.LclBucket;
import nekomod.mob.entity.EntityNeko;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="outerscience", name="OuterScience", version="1.1") //sets mod info

public class MainClass
{
  @SidedProxy(clientSide="nekomod.ClientProxy", serverSide="nekomod.CommonProxy") //points to proxys
  //public - all classes can see this, static - can not be changed, CommonProxy - what it points to, proxy - what you put in the code to point to it.
  public static CommonProxy proxy;
  //modid
  public static final String modid = "outerscience";
  //Block variables
  public static Block bioChamber;
  public static Block bioChamberA;
  //fluidBlock
  public static Block yourFluidBlock;
  //Items
  public static Item dna;
  public static Item syringe;
  public static Item sterilesyringe;
  public static Item lclBucket;
  //Other
  public static CreativeTabs tabMyMod = new CreativeTabOuter("OuterScience");
  public static Fluid lcl;
  
  @Instance(modid)//many things need this instance 
  public static MainClass modInstance;
  
  
  
  
  public static void registerEntity(){
	  	//registers entities, use createEntity function here
		createEntity(EntityNeko.class, "NekoGirl", 0x000000, 0xD707DE, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.roofedForest, 40, 2, 6);
		
	}
  	//function for creating new entities DO NOT CHANGE
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor, BiomeGenBase biome1, BiomeGenBase biome2, BiomeGenBase biome3, int spawnProb, int minSpawn, int  maxSpawn){
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, MainClass.modInstance, 50, 3, true);
		EntityRegistry.addSpawn(entityClass, spawnProb, minSpawn, maxSpawn, EnumCreatureType.creature, biome1, biome2, biome3);
		
		createEgg(randomID, solidColor, spotColor);
	}
	//create egg function DO NOT CHANGE
	private static void createEgg(int randomID, int solidColor, int spotColor){
		EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
	}

	
  //MAIN EVENT
  @Mod.EventHandler
  public void load(FMLInitializationEvent event)
  {
	//proxy functions
    proxy.registerRenderInformation();
    proxy.init(event);
    proxy.registerTileEntities();
    
    
    
    registerBlocks(); //registers blocks
    
    registerEntity(); //registers entities 
    
    registerRecipies(); //registers crafting
    
    registerItems(); //registers items
    
    }
  
  private void registerItems() { //ALL ITEMS GO HERE
	  //DNA item
	  dna = new ItemDNA().setUnlocalizedName("DNA").setTextureName("outerscience:dna");
	  GameRegistry.registerItem(dna, dna.getUnlocalizedName().substring(5));
	  
	  //Make LCL bucket and handler 
	  lclBucket = new LclBucket(yourFluidBlock).setUnlocalizedName("lclBucket").setContainerItem(Items.bucket).setTextureName("outerscience:lclbucket").setCreativeTab(tabMyMod);
	  GameRegistry.registerItem(lclBucket, "yourBucket");
	  //FluidContainerRegistry.registerFluidContainer(lcl, new ItemStack(lclBucket), new ItemStack(Items.bucket));
	  FluidContainerRegistry.registerFluidContainer(
				new FluidContainerData(
					FluidRegistry.getFluidStack(lcl.getName(), 1000),
					new ItemStack(lclBucket),
					new ItemStack(Items.bucket)
				)
			);
  }
  
  private void registerBlocks() { //ALL BLOCKS GO HERE
	//FLUID BLOCKS
	lcl = new Fluid("fluidname").setIcons(FluidLcl.flowingIcon).setLuminosity(5).setDensity(90).setViscosity(10);
	FluidRegistry.registerFluid(lcl);
	yourFluidBlock = new FluidLcl(lcl, Material.water).setBlockName("fluidlcl");
	GameRegistry.registerBlock(yourFluidBlock, modid + "_" + yourFluidBlock.getUnlocalizedName().substring(5));
	lcl.setUnlocalizedName(yourFluidBlock.getUnlocalizedName());
  }
  
  private void registerRecipies(){ //crafting and crafting variables go here
	//Var  
	ItemStack dnaI = new ItemStack(dna);
	FluidStack lclF = new FluidStack(lcl, 100);
	  
	//note the lib must be in build path for this error to be resolved DO NOT CHANGE
	cofh.api.modhelpers.ThermalExpansionHelper.addCrucibleRecipe(4000, dnaI, lclF);
  }
}
