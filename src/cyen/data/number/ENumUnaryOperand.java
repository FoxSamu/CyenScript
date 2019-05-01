package cyen.data.number;

public enum ENumUnaryOperand {
    NEG( new SimpleTypeSupplier(), INumberType::neg ),
    ABS( new SimpleTypeSupplier(), INumberType::abs ),
    IMAG( new SimpleTypeSupplier(), INumberType::imag ),
    REAL( new SimpleTypeSupplier(), INumberType::real ),
    FLOOR( new SimpleTypeSupplier(), INumberType::floor ),
    CEIL( new SimpleTypeSupplier(), INumberType::ceil ),
    ROUND( new SimpleTypeSupplier(), INumberType::round ),
    BIT_NOT( new IntegerTypeSupplier(), INumberType::bitNot ),
    BIT_FLIP( new IntegerTypeSupplier(), INumberType::bitFlip ),
    BIT_COUNT( new IntegerTypeSupplier(), INumberType::bitCount ),
    BINARY_SWAP( new SwapTypeSupplier(), INumberType::binarySwap );

    public final ITypeSupplier typeSupplier;
    public final IOperandInvoker invoker;

    ENumUnaryOperand( ITypeSupplier typeSupplier, IOperandInvoker invoker ) {
        this.typeSupplier = typeSupplier;
        this.invoker = invoker;
    }

    public INumberData apply( INumberData data ) {
        INumberType type = typeSupplier.computeType( data.type().type );
        return invoker.invoke( type, data );
    }

    public interface ITypeSupplier {
        INumberType computeType( INumberType type );
    }

    public interface IOperandInvoker {
        INumberData invoke( INumberType type, INumberData data );
    }

    public static class SimpleTypeSupplier implements ITypeSupplier {
        @Override
        public INumberType computeType( INumberType type ) {
            return type;
        }
    }

    public static class IntegerTypeSupplier implements ITypeSupplier {
        @Override
        public INumberType computeType( INumberType type ) {
            return type.getLevel() == 5 ? ENumberType.LONG.type : type.getLevel() == 4 ? ENumberType.INT.type : type;
        }
    }

    public static class SwapTypeSupplier implements ITypeSupplier {
        @Override
        public INumberType computeType( INumberType type ) {
            int level = type.getLevel();
            if( level == 5 ) return ENumberType.LONG.type;
            if( level == 4 ) return ENumberType.INT.type;
            if( level == 3 ) return ENumberType.DOUBLE.type;
            return ENumberType.FLOAT.type;
        }
    }
}
