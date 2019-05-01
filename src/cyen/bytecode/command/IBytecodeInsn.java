package cyen.bytecode.command;

import cyen.bytecode.ExecContext;

public interface IBytecodeInsn {
    void execute( ExecContext ctx );
}
