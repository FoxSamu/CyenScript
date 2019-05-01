package cyen.bytecode.instruction;

import cyen.bytecode.ExecContext;

public interface IBytecodeInsn {
    void execute( ExecContext ctx );
}
