package cyen.data.number;

import cyen.data.number.type.*;

public enum ENumberType {
    BYTE( new TypeByte() ),
    SHORT( new TypeShort() ),
    INT( new TypeInt() ),
    LONG( new TypeLong() ),
    DOUBLE( new TypeDouble() ),
    FLOAT( new TypeFloat() );
    public final INumberType type;

    ENumberType( INumberType type ) {
        this.type = type;
    }
}
