package exoskeleton.core.transformer;

import exoskeleton.core.Method;
import exoskeleton.core.ObfuscationMappings;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class EntityPlayerTransformer
implements IClassTransformer{
    private static final Method method = new Method("isPushedByWater", "aC");

    @Override
    public byte[] transform(String name, String tName, byte[] bits){
        if(ObfuscationMappings.ENTITY_PLAYER.isOf(name)){
            ClassReader reader = new ClassReader(bits);
            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);
            EntityPlayerVisitor visitor = new EntityPlayerVisitor(writer);
            reader.accept(visitor, 0);

            return writer.toByteArray();
        }
        return bits;
    }

    private final class EntityPlayerVisitor
    extends ClassVisitor{
        public EntityPlayerVisitor(ClassVisitor cv){
            super(Opcodes.ASM4, cv);
        }

        @Override
        public MethodVisitor visitMethod(int access, final String name, String desc, String sig, String[] exc){
            MethodVisitor visitor = super.visitMethod(access, name, desc, sig, exc);

            if(method.is(name)){
                return new MethodVisitor(Opcodes.ASM4, visitor){
                    @Override
                    public void visitCode(){
                        System.out.println("Transforming " + name + " method");
                        this.visitVarInsn(Opcodes.ALOAD, 0);
                        this.visitMethodInsn(Opcodes.INVOKESTATIC, "exoskeleton/Hooks", "isPushedByWater", "(Lnet/minecraft/entity/player/EntityPlayer;)Z", false);
                        this.visitInsn(Opcodes.IRETURN);
                    }
                };
            }

            return visitor;
        }
    }
}