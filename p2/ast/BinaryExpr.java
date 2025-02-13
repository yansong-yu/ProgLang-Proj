package ast;
import java.io.PrintStream;

public class BinaryExpr extends Expr {
    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;
    public static final int DIV = 4;
    public final Expr expr1, expr2;
    public final int op;
    public BinaryExpr(Expr e1, int oper, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	switch (op) {
	case PLUS: ps.print("+"); break;
	case MINUS: ps.print("-"); break;
	case TIMES: ps.print("*"); break;
	case DIV: ps.print("/"); break;
	}
	expr2.print(ps);
	ps.print(")");
    }

	public String check(){
		String res1 = expr1.check();
		String res2 = expr2.check();
		if (res1 == null || res2 == null)
			return null;
		if (res1 != res2){
			String ops = "";
			switch (op) {
				case PLUS: ops = "+"; break;
				case MINUS: ops = "-"; break;
				case TIMES: ops = "*"; break;
				case DIV: ops = "/"; break;
			}
			Logger.log(String.format("**[ERROR] for binary operator %s, lhs: %s and rhs: %s do not have same data type!", ops, expr1.toString(), expr2.toString()));
			return null;
		}
		return res1;
	}
}
