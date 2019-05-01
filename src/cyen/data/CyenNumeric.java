package cyen.data;

import cyen.bytecode.ExecContext;

public abstract class CyenNumeric <T extends CyenNumeric<T>> extends CyenArithmetic<T> {
    public CyenNumeric( ExecContext ctx ) {
        super( ctx );
    }

    public abstract T imag( ExecContext ctx );
    public abstract T real( ExecContext ctx );
}
