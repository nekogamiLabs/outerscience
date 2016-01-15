package nekomod;

import nekomod.mob.entity.EntityNeko;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class NekoGui extends GuiContainer {
	public static final ResourceLocation texture = new ResourceLocation(MainClass.modid.toLowerCase(), "textures/gui/nekoinv.png");

    public NekoGui(InventoryPlayer playerInv, EntityNeko te) {
        super(new NekoInv(playerInv, te));

        this.xSize = 176;
        this.ySize = 166;
    }

	@Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		mc.getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	    String s = "Neko";
	    this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);            //#404040
	}
}