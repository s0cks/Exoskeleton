package exoskeleton.common.lib.skills;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import exoskeleton.api.Skill;
import exoskeleton.api.Tree;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraft.world.storage.SaveHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class SkillsManager{
    public static boolean unlocked(EntityPlayer player, Tree tree, Skill skill){
        return PlayerSkills.get(player).hasSkill(tree.name.toLowerCase(), skill.tag);
    }

    public static void getPlayerData(EntityPlayer player){
        IPlayerFileData pNBTManagerObj = MinecraftServer.getServer().worldServerForDimension(0).getSaveHandler().getSaveHandler();
        SaveHandler sh = (SaveHandler) pNBTManagerObj;
        File dir = ObfuscationReflectionHelper.getPrivateValue(SaveHandler.class, sh, "playersDirectory", "field_75771_c");
        File file = new File(dir, player.getDisplayName() + ".exo");
        NBTTagCompound comp = load(file);
        PlayerSkills skills = new PlayerSkills();
        skills.load(comp);
        PlayerSkills.instances.put(player, skills);
    }

    public static void savePlayerData(EntityPlayer player){
        IPlayerFileData pNBTManagerObj = MinecraftServer.getServer().worldServerForDimension(0).getSaveHandler().getSaveHandler();
        SaveHandler sh = (SaveHandler) pNBTManagerObj;
        File dir = ObfuscationReflectionHelper.getPrivateValue(SaveHandler.class, sh, "playersDirectory", "field_75771_c");
        File file = new File(dir, player.getDisplayName() + ".exo");
        NBTTagCompound comp = new NBTTagCompound();
        PlayerSkills.instances.get(player).save(comp);
        save(comp, file);
    }

    private static NBTTagCompound load(File file){
        try{
            NBTTagCompound comp = new NBTTagCompound();
            if(file != null && file.exists()){
                try{
                    FileInputStream fis = new FileInputStream(file);
                    comp = CompressedStreamTools.readCompressed(fis);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            return comp;
        } catch(Exception e){
            e.printStackTrace();
            return new NBTTagCompound();
        }
    }

    private static void save(NBTTagCompound comp, File file){
        try{
            FileOutputStream fos = new FileOutputStream(file);
            CompressedStreamTools.writeCompressed(comp, fos);
            fos.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}