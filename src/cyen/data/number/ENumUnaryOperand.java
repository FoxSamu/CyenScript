package cyen.data.number;

public enum ENumUnaryOperand {
    NEG( new SimpleTypeSupplier(), INumberType::neg ),
    ABS( new SimpleTypeSupplier(), INumberType::abs ),
    IMAG( new SimpleTypeSupplier(), INumberType::imag ),
    REAL( new SimpleTypeSupplier(), INumberType::real ),
    FLOOR( new SimpleTypeSupplier(), INumberType::floor ),
    CEIL( new SimpleTypeSupplier(), INumberType::ceil ),
    ROUND( new SimpleTypeSupplier(), INumberType::round ),
    BIT_NOT( new IntegerTypeSupplier(), INumberType::bitNot );

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
}
