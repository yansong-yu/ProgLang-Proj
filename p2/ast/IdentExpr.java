package ast;
import java.io.PrintStream;

public class IdentExpr extends Expr {
    public final String ident; 
    public IdentExpr(String i, Location loc) {
	super(loc);
	ident = i;
    }
    public void print(PrintStream ps) {
	ps.print(ident);
    }
    public String check(){
        String res = TableTree.root.find(ident);
        if (res == null) {
            Logger.log(String.format("**[ERROR] variable %s has not been declared!", ident));
        }
        return res;
    }
}
