package cyen.bytecode.instruction.util;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;

public class InsnLineNumber implements IBytecodeInsn {
    public final int line;

    public InsnLineNumber( int line ) { this.line = line; }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.setLineNum( line );
    }
}
