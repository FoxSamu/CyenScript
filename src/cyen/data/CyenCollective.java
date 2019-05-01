package cyen.data;

import cyen.bytecode.ExecContext;

public abstract class CyenCollective extends CyenObject {
    public CyenCollective( ExecContext ctx ) {
        super( ctx );
    }

    public abstract int getSize( ExecContext ctx );
    public abstract ICyenData getItem( ExecContext ctx, int index );
    public abstract void setItem( ExecContext ctx, int index, ICyenData data );
}
