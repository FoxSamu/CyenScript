import cyen.bytecode.Bytecode;
import cyen.bytecode.ExecContext;
import cyen.bytecode.instruction.jump.InsnGoto;
import cyen.bytecode.instruction.jump.InsnIfNotGoto;
import cyen.bytecode.instruction.primitives.InsnPrimitivePush;
import cyen.bytecode.instruction.primitives.InsnStringPush;
import cyen.bytecode.instruction.print.InsnPrint;

public class Main {
    public static void main( String[] args ) {
        Bytecode bytecode = new Bytecode(
                new InsnPrimitivePush.Bool( false ),
                new InsnIfNotGoto( 5 ),
                new InsnStringPush( "Not skipped" ),
                new InsnPrint(),
                new InsnGoto( 7 ),
                new InsnStringPush( "Skipped" ),
                new InsnPrint()
        );

        ExecContext ctx = new ExecContext( "context", bytecode );

        ctx.execute();
    }
}
