package cyen.util;

import java.lang.reflect.Method;
import java.util.Collection;

@Deprecated
public class ClassUtil {
    public static Class getClosestSuperclass( Class param, int idx, Collection<Method> parents ) {
        Class out = null;
        for( Method m : parents ) {
            if( m.getParameterCount() <= idx ) continue;
            Class p = m.getParameters()[ idx ].getType();
            if( p.isAssignableFrom( param ) ) {
                if( out == null ) out = p;
                else {
                    if( out.isAssignableFrom( p ) ) {
                        out = p;
                    }
                }
            }
        }
        return out;
    }

    public static <T extends Collection<Method>> T filter( T methods, int idx, Class paramType ) {
        methods.removeIf( method -> {
            if( method.getParameterCount() <= idx ) return true;
            return method.getParameters()[ idx ].getType() != paramType;
        } );
        return methods;
    }
}
