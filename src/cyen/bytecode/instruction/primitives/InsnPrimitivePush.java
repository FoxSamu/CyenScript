package cyen.bytecode.instruction.primitives;

import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.IBytecodeInsn;
import cyen.data.*;

public class InsnPrimitivePush {
    public static class Byte implements IBytecodeInsn {
        public final byte value;

        public Byte( byte value ) {
            this.value = value;
        }

        @Override
        public void execute( ExecContext ctx ) {
            ctx.push( new CyenByte( ctx, value ) );
        }
    }

    public static class Short implements IBytecodeInsn {
        public final short value;

        public Short( short value ) {
            this.value = value;
        }

        @Override
        public void execute( ExecContext ctx ) {
            ctx.push( new CyenShort( ctx, value ) );
        }
    }

    public static class Int implements IBytecodeInsn {
        private final int value;

        public Int( int value ) {
            this.value = value;
        }

        @Override
        public void execute( ExecContext ctx ) {
            ctx.push( new CyenInt( ctx, value ) );
        }
    }

    public static class Long implements IBytecodeInsn {
        private final long value;

        public Long( long value ) {
            this.value = value;
        }

        @Override
        public void execute( ExecContext ctx ) {
            ctx.push( new CyenLong( ctx, value ) );
        }
    }

    public static class Double implements IBytecodeInsn {
        private final double value;

        public Double( double value ) {
            this.value = value;
        }

        @Override
        public void execute( ExecContext ctx ) {
            ctx.push( new CyenDouble( ctx, value ) );
        }
    }

    public static class Float implements IBytecodeInsn {
        private final float value;

        public Float( float value ) {
            this.value = value;
        }

        @Override
        public void execute( ExecContext ctx ) {
            ctx.push( new CyenFloat( ctx, value ) );
        }
    }

    public static class Char implements IBytecodeInsn {
        private final char value;

        public Char( char value ) {
            this.value = value;
        }

        @Override
        public void execute( ExecContext ctx ) {
            ctx.push( new CyenChar( ctx, value ) );
        }
    }

    public static class Bool implements IBytecodeInsn {
        private final boolean value;

        public Bool( boolean value ) {
            this.value = value;
        }

        @Override
        public void execute( ExecContext ctx ) {
            ctx.push( new CyenBoolean( ctx, value ) );
        }
    }
}
