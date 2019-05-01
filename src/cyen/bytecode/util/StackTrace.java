package cyen.bytecode.util;

public class StackTrace {
    public final Element[] elements;

    public StackTrace( Element... elements ) {
        this.elements = elements;
    }

    public static class Element {
        public final String location;
        public final int lineNum;

        public Element( String location, int lineNum ) {
            this.location = location;
            this.lineNum = lineNum;
        }

        @Override
        public String toString() {
            return " @ " + location + " : Ln" + lineNum;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for( Element element : elements ) {
            builder.append( element.toString() );
            builder.append( "\n" );
        }
        return builder.toString();
    }
}
