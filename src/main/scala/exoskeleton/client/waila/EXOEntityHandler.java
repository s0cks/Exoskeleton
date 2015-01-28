package exoskeleton.client.waila;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaEntityAccessor;
import mcp.mobius.waila.api.IWailaEntityProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import java.util.List;

public class EXOEntityHandler
implements IWailaEntityProvider{
    @Override
    public Entity getWailaOverride(IWailaEntityAccessor accessor, IWailaConfigHandler config){
        return accessor.getEntity();
    }

    @Override
    public List<String> getWailaHead(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config){
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config){
        if(entity instanceof EntityPlayer){
            currenttip.add("Test");
        }

        return currenttip;
    }

    @Override
    public List<String> getWailaTail(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config){
        return currenttip;
    }

    public static void register(IWailaRegistrar registrar){
        registrar.registerBodyProvider(new EXOEntityHandler(), EntityPlayer.class);
    }
}