package cyen.data;

import cyen.bytecode.ExecContext;

public class CyenString extends CyenCollective {

    private final String value;

    private final CyenChar[] chars;

    public CyenString( ExecContext ctx, String string ) {
        super( ctx );
        this.value = string;

        chars = new CyenChar[ value.length() ];
        for( int i = 0; i < value.length(); i++ ) {
            chars[ i ] = new CyenChar( ctx, value.charAt( i ) );
        }
    }

    public String getValue( ExecContext ctx ) {
        return value;
    }

    @Override
    public String stringify( ExecContext ctx ) {
        return value;
    }

    @Override
    public int getSize( ExecContext ctx ) {
        return value.length();
    }

    @Override
    public ICyenData getItem( ExecContext ctx, int index ) {
        if( index < 0 || index >= getSize( ctx ) ) return null;
        return chars[ index ];
    }

    @Override
    public void setItem( ExecContext ctx, int index, ICyenData data ) {

    }

    @Override
    public Class getParamClass() {
        return String.class;
    }

    @Override
    public Object getParamObject() {
        return value;
    }

    @Override
    public String constructor() {
        return "String";
    }

    @Override
    public String type() {
        return "string";
    }
}
