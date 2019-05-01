package cyen.bytecode.instruction;

import cyen.bytecode.ExecContext;

public interface IInstruction {
    void execute( ExecContext ctx );
}
