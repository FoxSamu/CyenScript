package cyen.data;

import cyen.bytecode.ExecContext;

import java.util.HashMap;

public class CyenObject implements ICyenData {

    private final HashMap<String, ICyenData> members = new HashMap<>();

    public CyenObject( ExecContext ctx ) {
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
    public ICyenData instantiate( ExecContext ctx ) {
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
        return "Object";
    }

    @Override
    public String type() {
        return "object";
    }
}
