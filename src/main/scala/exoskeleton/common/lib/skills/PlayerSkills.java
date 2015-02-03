package exoskeleton.common.lib.skills;

import exoskeleton.common.Exoskeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class PlayerSkills{
    public static final Map<EntityPlayer, PlayerSkills> instances = new HashMap<EntityPlayer, PlayerSkills>();

    public static PlayerSkills get(EntityPlayer p){
        return instances.get(p);
    }

    public final Map<String, List<String>> aquired = new HashMap<String, List<String>>();

    public boolean hasSkill(String tree, String skill){
        return this.aquired.containsKey(tree) && this.aquired.get(tree).contains(skill);
    }

    public void addSkill(String tree, String skill){
        if(this.aquired.containsKey(tree)){
            this.aquired.get(tree).add(skill);
        } else{
            this.aquired.put(tree, new LinkedList<String>());
            this.addSkill(tree, skill);
        }
    }

    public void removeSkill(String tree, String skill){
        if(this.aquired.containsKey(tree)){
            this.aquired.get(tree).remove(skill);
        }
    }

    public void load(NBTTagCompound comp){
        NBTTagList trees = comp.getTagList("exo.trees", 10);
        for(int i = 0; i < trees.tagCount(); i++){
            NBTTagCompound treeComp = trees.getCompoundTagAt(i);
            List<String> skills = new LinkedList<String>();

            NBTTagList treeSkills = treeComp.getTagList("skills", 10);
            for(int j = 0; j < treeSkills.tagCount(); j++){
                skills.add(treeSkills.getCompoundTagAt(j).getString("key"));
            }

            this.aquired.put(treeComp.getString("name"), skills);
            Exoskeleton.logger().info("Tree (" + treeComp.getString("name") + ") Loaded " + skills.size() + " skills");
        }
    }

    public void save(NBTTagCompound comp){
        NBTTagList trees = new NBTTagList();
        for(Entry<String, List<String>> entry : this.aquired.entrySet()){
            NBTTagCompound treeComp = new NBTTagCompound();
            treeComp.setString("name", entry.getKey());

            NBTTagList skills = new NBTTagList();
            for(String str : entry.getValue()){
                NBTTagCompound skillComp = new NBTTagCompound();
                skillComp.setString("key", str);
                skills.appendTag(skillComp);
            }

            treeComp.setTag("skills", skills);
            trees.appendTag(treeComp);
        }
        comp.setTag("exo.trees", trees);
    }
}