package io.github.asyncronous.exo.core;

import net.minecraft.item.Item;

import io.github.asyncronous.exo.item.ItemCore;

public abstract class AbstractCore
implements ICore{
    protected final String id;

    public AbstractCore(String id){
        this.id = id;
    }

    @Override
    public Item getItem(){
        return new ItemCore(this);
    }

    @Override
    public String getName(){
        return this.id;
    }
}