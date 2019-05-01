package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.exception.CyenInvocationException;
import cyen.util.MethodsInvocable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

@Deprecated
public class CyenNative extends CyenObject {
    private final Object object;
    private final Class cls;

    private final HashMap<String, MethodsInvocable> methodMap = new HashMap<>();
    private final HashMap<String, Field> fieldMap = new HashMap<>();

    public CyenNative( ExecContext ctx, Object object, Class cls ) {
        super( ctx );
        this.object = object;
        this.cls = cls;

        Method[] methods = cls.getMethods();
        Field[] fields = cls.getFields();

        for( Method m : methods ) {
            MethodsInvocable invocable;
            if( ! methodMap.containsKey( m.getName() ) ) {
                invocable = new MethodsInvocable( object, cls, m.getName() );
                methodMap.put( m.getName(), invocable );
            }
        }

        for( Field f : fields ) {
            fieldMap.put( f.getName(), f );
        }
    }

    @Override
    public boolean hasMember( ExecContext ctx, String name ) {
        if( methodMap.containsKey( name ) ) return true;
        if( fieldMap.containsKey( name ) ) return true;
        return super.hasMember( ctx, name );
    }

    @Override
    public ICyenData getMember( ExecContext ctx, String name ) {
        if( methodMap.containsKey( name ) ) {
            return new CyenFunction( ctx, methodMap.get( name ) );
        }
        if( fieldMap.containsKey( name ) ) {
            try {
                Object obj = fieldMap.get( name ).get( object );
                if( ! ( obj instanceof ICyenData ) ) {
                    obj = new CyenNative( ctx, obj, obj.getClass() );
                }
                return (ICyenData) obj;
            } catch( IllegalAccessException exc ) {
                throw new CyenInvocationException( "Failed to get field value", exc );
            }
        }
        return super.getMember( ctx, name );
    }

    @Override
    public Class getParamClass() {
        return cls;
    }

    @Override
    public Object getParamObject() {
        return object;
    }

    @Override
    public String constructor() {
        return cls.getSimpleName();
    }

    @Override
    public String type() {
        return "native";
    }

    @Override
    public String stringify( ExecContext ctx ) {
        return String.format( "[native %s]", cls.getTypeName() );
    }
}
