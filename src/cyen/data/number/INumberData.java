package cyen.data.number;

public interface INumberData {
    double doubleValue();
    float floatValue();
    int intValue();
    byte byteValue();
    short shortValue();
    long longValue();

    String stringified();

    ENumberType type();
}
