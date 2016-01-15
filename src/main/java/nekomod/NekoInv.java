package nekomod;

import nekomod.mob.entity.EntityNeko;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class NekoInv extends Container{
	
	public static EntityNeko te;
	
	public NekoInv(InventoryPlayer playerInv, EntityNeko te) {
		this.te = te;
		
		/*
		 * SLOTS:
		 * 
		 * Neko Entity 0-8 ........ 0  - 8
		 * Player Inventory 9-35 .. 9  - 35
		 * Player Inventory 0-8 ... 36 - 44
		 */
		
		// Tile Entity, Slot 0-8, Slot IDs 0-8
	    for (int y = 0; y < 3; ++y) {
	        for (int x = 0; x < 3; ++x) {
	            this.addSlotToContainer(new Slot(te, x + y * 3, 62 + x * 18, 17 + y * 18));
	        }
	    }

	    // Player Inventory, Slot 9-35, Slot IDs 9-35
	    for (int y = 0; y < 3; ++y) {
	        for (int x = 0; x < 9; ++x) {
	            this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
	        }
	    }

	    // Player Inventory, Slot 0-8, Slot IDs 36-44
	    for (int x = 0; x < 9; ++x) {
	        this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
	    }
	    }
	    @Override
		public boolean canInteractWith(EntityPlayer player) {
	        return this.te.isUseableByPlayer(player);
	    }
	    @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
                ItemStack stack = null;
                Slot slotObject = (Slot) inventorySlots.get(slot);

                //null checks and checks if the item can be stacked (maxStackSize > 1)
                if (slotObject != null && slotObject.getHasStack()) {
                        ItemStack stackInSlot = slotObject.getStack();
                        stack = stackInSlot.copy();

                        //merges the item into player inventory since its in the tileEntity
                        if (slot < 9) {
                                if (!this.mergeItemStack(stackInSlot, 9, 44, true)) {
                                        return null;
                                }
                        }
                        //places it into the tileEntity is possible since its in the player inventory
                        else if (!this.mergeItemStack(stackInSlot, 0, 9, false)) {
                                return null;
                        }

                        if (stackInSlot.stackSize == 0) {
                                slotObject.putStack(null);
                        } else {
                                slotObject.onSlotChanged();
                        }

                        if (stackInSlot.stackSize == stack.stackSize) {
                                return null;
                        }
                        slotObject.onPickupFromSlot(player, stackInSlot);
                }
                return stack;
        }
	    }
    

	
	
	