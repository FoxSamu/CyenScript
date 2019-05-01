package cyen.data;

import cyen.bytecode.ExecContext;

public interface ICyenData {
    boolean canInvoke( ExecContext ctx );
    ICyenData invoke( ExecContext ctx, ICyenData self, ICyenData... args );

    boolean canInstantiate( ExecContext ctx );
    ICyenData instantiate( ExecContext ctx, ICyenData... args );

    ICyenData getMember( ExecContext ctx, String name );
    void setMember( ExecContext ctx, String name, ICyenData value );
    void removeMember( ExecContext ctx, String name );
    boolean hasMember( ExecContext ctx, String name );

    String stringify( ExecContext ctx );

    boolean booleanize( ExecContext ctx );

    Class getParamClass();
    Object getParamObject();

    String constructor();
    String type();
}
