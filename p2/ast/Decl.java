package ast;
import java.io.PrintStream;

public class Decl extends Unit {
    public final VarDecl varDecl;
    public final Expr expr;
    public Decl(VarDecl d, Location loc) {
	super(loc);
	varDecl = d;
	expr = null;
    }
    public Decl(VarDecl d, Expr e, Location loc) {
	super(loc);
	varDecl = d;
	expr = e;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent);
	varDecl.print(ps); 
	if (expr != null) {
	    ps.print(" = ");
	    expr.print(ps);
	}
	ps.print(";");
    }
    public void print(PrintStream ps) {
	print(ps,"");
    }
	public String check(){
		if (expr == null)
			return varDecl.check();
		String res = expr.check();
		if (res == null){
			return res;
		}
		String res1 = varDecl.check();
		if (res1 == null){
			return res1;
		}
		if (res1 != res){
			Logger.log(String.format("**[ERROR] lhs: %s and rhs: %s have different data type!", varDecl.toString(), expr.toString()));
			return null;
		}
		return res;
	}
}
