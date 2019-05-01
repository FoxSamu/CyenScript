package cyen.data;

import cyen.bytecode.ExecContext;

public abstract class CyenConstructive extends CyenObject {
    public CyenConstructive( ExecContext ctx ) {
        super( ctx );
    }

    @Override
    public boolean canInstantiate( ExecContext ctx ) {
        return true;
    }

    @Override
    public abstract ICyenData instantiate( ExecContext ctx, ICyenData... args );

    public abstract String getName();

    @Override
    public String constructor() {
        return "Class";
    }
}
