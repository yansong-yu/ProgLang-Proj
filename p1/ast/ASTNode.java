package ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
abstract class ASTNode {
    public final Location loc;
    ASTNode(Location loc) { this.loc = loc; }
    public abstract void print(PrintStream ps);
    public String toString() { 
	ByteArrayOutputStream b = new ByteArrayOutputStream();
	print(new PrintStream(b));
	return new String(b.toByteArray(),java.nio.charset.StandardCharsets.UTF_8);
    }

    // Type checking
    public RecordYYS check(){
        System.out.println("The Check Method Has Not Been Implemented!");
        return null;
    } 
}
