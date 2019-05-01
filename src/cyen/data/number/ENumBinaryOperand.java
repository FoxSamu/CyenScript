package cyen.data.number;

public enum ENumBinaryOperand {
    ADD( new ArithmeticTypeSupplier(), INumberType::add ),
    SUB( new ArithmeticTypeSupplier(), INumberType::sub ),
    MUL( new ArithmeticTypeSupplier(), INumberType::mul ),
    DIV( new ArithmeticTypeSupplier(), INumberType::div ),
    MOD( new ArithmeticTypeSupplier(), INumberType::mod ),
    FLOOR_DIV( new ArithmeticTypeSupplier(), INumberType::floorDiv ),
    POW( new ArithmeticTypeSupplier(), INumberType::pow ),
    RIGHT_SIGNED( new BitShiftTypeSupplier(), ( type, left, right ) -> type.rightShiftSigned( left, right.intValue() ) ),
    RIGHT_UNSIGNED( new BitShiftTypeSupplier(), ( type, left, right ) -> type.rightShiftUnsigned( left, right.intValue() ) ),
    LEFT_SHIFT( new BitShiftTypeSupplier(), ( type, left, right ) -> type.leftShift( left, right.intValue() ) ),
    LEFT_ROTATE( new BitShiftTypeSupplier(), ( type, left, right ) -> type.leftRotate( left, right.intValue() ) ),
    RIGHT_ROTATE( new BitShiftTypeSupplier(), ( type, left, right ) -> type.rightRotate( left, right.intValue() ) ),
    BIT_OR( new BitwiseTypeSupplier(), INumberType::bitOr ),
    BIT_AND( new BitwiseTypeSupplier(), INumberType::bitAnd ),
    BIT_XOR( new BitwiseTypeSupplier(), INumberType::bitXor );

    public final ITypeSupplier typeSupplier;
    public final IOperandInvoker invoker;

    ENumBinaryOperand( ITypeSupplier typeSupplier, IOperandInvoker invoker ) {
        this.typeSupplier = typeSupplier;
        this.invoker = invoker;
    }

    public INumberData apply( INumberData left, INumberData right ) {
        INumberType type = typeSupplier.computeType( left.type().type, right.type().type );
        return invoker.invoke( type, left, right );
    }

    public interface ITypeSupplier {
        INumberType computeType( INumberType left, INumberType right );
    }

    public interface IOperandInvoker {
        INumberData invoke( INumberType type, INumberData left, INumberData right );
    }

    public static class ArithmeticTypeSupplier implements ITypeSupplier {
        @Override
        public INumberType computeType( INumberType left, INumberType right ) {
            return left.getLevel() > right.getLevel() ? left : right;
        }
    }

    public static class BitwiseTypeSupplier implements ITypeSupplier {
        @Override
        public INumberType computeType( INumberType left, INumberType right ) {
            int highestLevel = Math.max( left.getLevel(), right.getLevel() );
            return highestLevel == 5 ? ENumberType.LONG.type : highestLevel == 4 ? ENumberType.INT.type : left.getLevel() > right.getLevel() ? left : right;
        }
    }

    public static class BitShiftTypeSupplier implements ITypeSupplier {
        @Override
        public INumberType computeType( INumberType left, INumberType right ) {
            if( left.getLevel() == 5 ) return ENumberType.LONG.type;
            if( left.getLevel() == 4 ) return ENumberType.INT.type;
            return left;
        }
    }
}
