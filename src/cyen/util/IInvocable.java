package cyen.util;

import cyen.bytecode.ExecContext;
import cyen.data.ICyenData;

public interface IInvocable {
    ICyenData invoke( ExecContext context, ICyenData self, ICyenData... params );

    default String getStringified() {
        return "[unknown function]";
    }
}
