package cyen.bytecode.instruction.globals;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;

public class InsnSetGlobal implements IBytecodeInsn {
    public final String name;

    public InsnSetGlobal( String name ) {
        this.name = name;
    }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.setGlobal( name, ctx.pop() );
    }
}
