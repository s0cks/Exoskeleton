package exoskeleton.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exoskeleton.api.Core;
import exoskeleton.api.ExoskeletonCores;
import exoskeleton.common.core.CoreAssassin$;
import exoskeleton.common.core.CoreBulldozer$;
import exoskeleton.common.core.CoreGhost$;
import exoskeleton.common.core.CoreInferno$;
import exoskeleton.common.core.CoreMystic$;
import exoskeleton.common.core.CoreRecon$;
import exoskeleton.common.core.CoreReflex$;
import exoskeleton.common.core.CoreSkybound$;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

@SideOnly(Side.CLIENT)
public class GuiDebug
extends GuiScreen{
    private final EntityPlayer player;

    public GuiDebug(EntityPlayer player){
        this.player = player;
    }

    public void initGui(){
        this.buttonList.add(new GuiButton(0, 10, 10, "Recon"));
        this.buttonList.add(new GuiButton(1, 10, 30, "Reflex"));
        this.buttonList.add(new GuiButton(2, 10, 50, "Inferno"));
        this.buttonList.add(new GuiButton(3, 10, 70, "Ghost"));
        this.buttonList.add(new GuiButton(4, 10, 90, "Skybound"));
        this.buttonList.add(new GuiButton(5, 10, 110, "Bulldozer"));
        this.buttonList.add(new GuiButton(6, 10, 130, "Mystic"));
        this.buttonList.add(new GuiButton(7, 10, 150, "Assassin"));
    }

    @Override
    public void actionPerformed(GuiButton button){
        ItemStack stack = this.player.getCurrentEquippedItem();

        if(stack == null){
            return;
        }

        Core core = ExoskeletonCores.findCore(stack);

        if(core != null){
            return;
        }

        switch(button.id)
        {
            case 0:{
                ExoskeletonCores.installCore(stack, CoreRecon$.MODULE$);
                break;
            }

            case 1:{
                ExoskeletonCores.installCore(stack, CoreReflex$.MODULE$);
                break;
            }

            case 2:{
                ExoskeletonCores.installCore(stack, CoreInferno$.MODULE$);
                break;
            }

            case 3:{
                ExoskeletonCores.installCore(stack, CoreGhost$.MODULE$);
                break;
            }

            case 4:{
                ExoskeletonCores.installCore(stack, CoreSkybound$.MODULE$);
                break;
            }

            case 5:{
                ExoskeletonCores.installCore(stack, CoreBulldozer$.MODULE$);
                break;
            }

            case 6:{
                ExoskeletonCores.installCore(stack, CoreMystic$.MODULE$);
                break;
            }

            case 7:{
                ExoskeletonCores.installCore(stack, CoreAssassin$.MODULE$);
                break;
            }
        }

        this.mc.setIngameFocus();
    }
}