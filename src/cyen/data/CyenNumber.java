package cyen.data;

import cyen.bytecode.ExecContext;
import cyen.data.number.ENumBinaryOperand;
import cyen.data.number.ENumUnaryOperand;
import cyen.data.number.INumberData;
import cyen.data.number.data.*;

public abstract class CyenNumber extends CyenNumeric<CyenNumber> {
    public CyenNumber( ExecContext ctx ) {
        super( ctx );
    }

    public abstract INumberData data( ExecContext ctx );

    public CyenNumber bitOr( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.BIT_OR.apply( data( ctx ), other.data( ctx ) ) );
    }

    public CyenNumber bitAnd( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.BIT_AND.apply( data( ctx ), other.data( ctx ) ) );
    }

    public CyenNumber bitXor( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.BIT_XOR.apply( data( ctx ), other.data( ctx ) ) );
    }

    public CyenNumber rightShiftSigned( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.RIGHT_SIGNED.apply( data( ctx ), other.data( ctx ) ) );
    }

    public CyenNumber rightShiftUnsigned( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.RIGHT_UNSIGNED.apply( data( ctx ), other.data( ctx ) ) );
    }

    public CyenNumber leftShift( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.LEFT_SHIFT.apply( data( ctx ), other.data( ctx ) ) );
    }

    public CyenNumber bitNot( ExecContext ctx ) {
        return create( ctx, ENumUnaryOperand.BIT_NOT.apply( data( ctx ) ) );
    }

    @Override
    public CyenNumber imag( ExecContext ctx ) {
        return create( ctx, ENumUnaryOperand.IMAG.apply( data( ctx ) ) );
    }

    @Override
    public CyenNumber real( ExecContext ctx ) {
        return create( ctx, ENumUnaryOperand.REAL.apply( data( ctx ) ) );
    }

    @Override
    public CyenNumber add( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.ADD.apply( data( ctx ), other.data( ctx ) ) );
    }

    @Override
    public CyenNumber sub( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.SUB.apply( data( ctx ), other.data( ctx ) ) );
    }

    @Override
    public CyenNumber mul( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.MUL.apply( data( ctx ), other.data( ctx ) ) );
    }

    @Override
    public CyenNumber div( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.POW.apply( data( ctx ), other.data( ctx ) ) );
    }

    @Override
    public CyenNumber floorDiv( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.FLOOR_DIV.apply( data( ctx ), other.data( ctx ) ) );
    }

    @Override
    public CyenNumber mod( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.MOD.apply( data( ctx ), other.data( ctx ) ) );
    }

    @Override
    public CyenNumber pow( ExecContext ctx, CyenNumber other ) {
        return create( ctx, ENumBinaryOperand.POW.apply( data( ctx ), other.data( ctx ) ) );
    }

    @Override
    public CyenNumber neg( ExecContext ctx ) {
        return create( ctx, ENumUnaryOperand.NEG.apply( data( ctx ) ) );
    }

    @Override
    public CyenNumber abs( ExecContext ctx ) {
        return create( ctx, ENumUnaryOperand.ABS.apply( data( ctx ) ) );
    }

    @Override
    public CyenNumber floor( ExecContext ctx ) {
        return create( ctx, ENumUnaryOperand.FLOOR.apply( data( ctx ) ) );
    }

    @Override
    public CyenNumber ceil( ExecContext ctx ) {
        return create( ctx, ENumUnaryOperand.CEIL.apply( data( ctx ) ) );
    }

    @Override
    public CyenNumber round( ExecContext ctx ) {
        return create( ctx, ENumUnaryOperand.ROUND.apply( data( ctx ) ) );
    }

    @Override
    public String stringify( ExecContext ctx ) {
        return data( ctx ).stringified();
    }

    @Override
    public String type() {
        return "number";
    }

    public static CyenNumber create( ExecContext ctx, INumberData data ) {
        switch( data.type() ) {
            case DOUBLE:
                return new CyenDouble( ctx, (DataDouble) data );
            case FLOAT:
                return new CyenFloat( ctx, (DataFloat) data );
            case BYTE:
                return new CyenByte( ctx, (DataByte) data );
            case SHORT:
                return new CyenShort( ctx, (DataShort) data );
            case INT:
                return new CyenInt( ctx, (DataInt) data );
            case LONG:
                return new CyenLong( ctx, (DataLong) data );
        }
        return null; // Never happens
    }
}
