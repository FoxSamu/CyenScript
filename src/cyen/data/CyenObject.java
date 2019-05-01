package cyen.data;

import cyen.bytecode.ExecContext;

import java.util.HashMap;

public class CyenObject implements ICyenData {

    private final HashMap<String, ICyenData> members = new HashMap<>();

    private final String constructorName;

    public CyenObject( ExecContext ctx ) {
        constructorName = "Object";
    }

    public CyenObject( ExecContext ctx, String constructor ) {
        constructorName = constructor;
    }

    @Override
    public boolean canInvoke( ExecContext ctx ) {
        return false;
    }

    @Override
    public ICyenData invoke( ExecContext ctx, ICyenData self, ICyenData... args ) {
        return null;
    }

    @Override
    public boolean canInstantiate( ExecContext ctx ) {
        return false;
    }

    @Override
    public ICyenData instantiate( ExecContext ctx, ICyenData... args ) {
        return null;
    }

    @Override
    public ICyenData getMember( ExecContext ctx, String name ) {
        return members.get( name );
    }

    @Override
    public void setMember( ExecContext ctx, String name, ICyenData value ) {
        members.put( name, value );
    }

    @Override
    public void removeMember( ExecContext ctx, String name ) {
        members.remove( name );
    }

    @Override
    public boolean hasMember( ExecContext ctx, String name ) {
        return members.containsKey( name );
    }

    @Override
    public String stringify( ExecContext ctx ) {
        return "[obj]";
    }

    @Override
    public Class getParamClass() {
        return this.getClass();
    }

    @Override
    public Object getParamObject() {
        return this;
    }

    @Override
    public String constructor() {
        return constructorName;
    }

    @Override
    public String type() {
        return "object";
    }

    @Override
    public boolean booleanize( ExecContext ctx ) {
        return true;
    }
}
