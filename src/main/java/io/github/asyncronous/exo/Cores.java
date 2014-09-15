package io.github.asyncronous.exo;

import io.github.asyncronous.exo.core.CoreAssassin;
import io.github.asyncronous.exo.core.CoreBerzerker;
import io.github.asyncronous.exo.core.CoreBulldozer;
import io.github.asyncronous.exo.core.CoreEmpty;
import io.github.asyncronous.exo.core.CoreFrost;
import io.github.asyncronous.exo.core.CoreGhost;
import io.github.asyncronous.exo.core.CoreInfernal;
import io.github.asyncronous.exo.core.CoreIntro;
import io.github.asyncronous.exo.core.CoreMystic;
import io.github.asyncronous.exo.core.CoreRecon;
import io.github.asyncronous.exo.core.CoreReflex;
import io.github.asyncronous.exo.core.CoreSkybound;
import io.github.asyncronous.exo.core.ICore;

import java.util.LinkedList;
import java.util.List;

public class Cores{
    public static final ICore coreAssassin = new CoreAssassin();
    public static final ICore coreBerzerker = new CoreBerzerker();
    public static final ICore coreBulldozer = new CoreBulldozer();
    public static final ICore coreEmpty = new CoreEmpty();
    public static final ICore coreFrost = new CoreFrost();
    public static final ICore coreGhost = new CoreGhost();
    public static final ICore coreInfernal = new CoreInfernal();
    public static final ICore coreIntro = new CoreIntro();
    public static final ICore coreMystic = new CoreMystic();
    public static final ICore coreRecon = new CoreRecon();
    public static final ICore coreReflex = new CoreReflex();
    public static final ICore coreSkybound = new CoreSkybound();

    public static List<ICore> cores = new LinkedList<ICore>();

    static
    {
        cores.add(coreAssassin);
        cores.add(coreBerzerker);
        cores.add(coreBulldozer);
        cores.add(coreEmpty);
        cores.add(coreFrost);
        cores.add(coreGhost);
        cores.add(coreInfernal);
        cores.add(coreIntro);
        cores.add(coreMystic);
        cores.add(coreRecon);
        cores.add(coreReflex);
        cores.add(coreSkybound);
    }

    public static ICore find(String name){
        for(ICore core : cores){
            if(core.getName().equalsIgnoreCase(name)){
                return core;
            }
        }

        return coreEmpty;
    }
}
