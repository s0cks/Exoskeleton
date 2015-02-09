package exoskeleton.core;

public final class Method{
    public final String obfName;
    public final String deobfName;

    public Method(String deobfName, String obfName){
        this.obfName = obfName;
        this.deobfName = deobfName;
    }

    public boolean is(String name){
        return name.equalsIgnoreCase(this.obfName) || name.equalsIgnoreCase(this.deobfName);
    }
}