package exoskeleton.core.transformer;

import exoskeleton.core.Method;
import exoskeleton.core.ObfuscationMappings;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class EndermanTransformer
implements IClassTransformer{
    private final Method method = new Method("shouldAttackPlayer", "f");

    @Override
    public byte[] transform(String name, String tName, byte[] bits){
        if(ObfuscationMappings.ENTITY_ENDERMAN.isOf(name)){
            ClassReader reader = new ClassReader(bits);
            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES|ClassWriter.COMPUTE_MAXS);
            EndermanVisitor visitor = new EndermanVisitor(writer);
            reader.accept(visitor, 0);

            return writer.toByteArray();
        }

        return bits;
    }

    private final class EndermanVisitor
    extends ClassVisitor{
        public EndermanVisitor(ClassVisitor visitor){
            super(Opcodes.ASM4, visitor);
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
                        this.visitVarInsn(Opcodes.ALOAD, 1);
                        this.visitMethodInsn(Opcodes.INVOKESTATIC, "exoskeleton/Hooks", "shouldAttackPlayer",
                                "(Lnet/minecraft/entity/monster/EntityEnderman;Lnet/minecraft/entity/player/EntityPlayer;)Z");
                        this.visitInsn(Opcodes.IRETURN);
                    }
                };
            }

            return visitor;
        }
    }
}