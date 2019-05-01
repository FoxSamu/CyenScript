package cyen.bytecode.command.locals;

import cyen.bytecode.ExecContext;
import cyen.bytecode.command.IBytecodeInsn;

public class InsnMaxLocals implements IBytecodeInsn {

    public int amount;

    public InsnMaxLocals( int amount ) {
        this.amount = amount;
    }

    public InsnMaxLocals() {
    }

    @Override
    public void execute( ExecContext ctx ) {
        ctx.ensureLocalAmount( amount );
    }
}
