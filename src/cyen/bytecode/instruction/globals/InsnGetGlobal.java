package cyen.bytecode.instruction.globals;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;

public class InsnGetGlobal implements IBytecodeInsn {
    public final String name;

    public InsnGetGlobal( String name ) {
        this.name = name;
    }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.push( ctx.getGlobal( name ) );
    }
}
