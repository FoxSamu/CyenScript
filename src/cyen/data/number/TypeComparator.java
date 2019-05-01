package cyen.data.number;

import java.util.Comparator;

public class TypeComparator implements Comparator<INumberType> {
    @Override
    public int compare( INumberType o1, INumberType o2 ) {
        return o1.getLevel() - o2.getLevel();
    }
}
