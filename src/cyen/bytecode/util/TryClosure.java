package cyen.bytecode.util;

public class TryClosure {
    public final int catchLoc;
    public final int errorIndex;

    public TryClosure( int catchLoc, int errorIndex ) {
        this.catchLoc = catchLoc;
        this.errorIndex = errorIndex;
    }
}
