package cyen.data;

import cyen.bytecode.ExecContext;

public abstract class CyenArithmetic <T extends CyenArithmetic<T>> extends CyenObject {
    public CyenArithmetic( ExecContext ctx ) {
        super( ctx );
    }

    public abstract T add( ExecContext ctx, T other );
    public abstract T sub( ExecContext ctx, T other );
    public abstract T mul( ExecContext ctx, T other );
    public abstract T div( ExecContext ctx, T other );
    public abstract T floorDiv( ExecContext ctx, T other );
    public abstract T mod( ExecContext ctx, T other );
    public abstract T pow( ExecContext ctx, T other );
    public abstract T neg( ExecContext ctx );
    public abstract T abs( ExecContext ctx );
    public abstract T floor( ExecContext ctx );
    public abstract T ceil( ExecContext ctx );
    public abstract T round( ExecContext ctx );
}
