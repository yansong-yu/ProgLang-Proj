package ast;
import java.io.PrintStream;

public class CompExpr extends CondExpr {
    public static final int GE = 1;
    public static final int GT = 2;
    public static final int LE = 3;
    public static final int LT = 4;
    public static final int EQ = 5;
    public static final int NE = 6;
    public final Expr expr1, expr2;
    public final int op;
    public CompExpr(Expr e1, int oper, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	switch (op) { 
	case GE: ps.print(">="); break;
	case GT: ps.print(">"); break;
	case LE: ps.print("<="); break;
	case LT: ps.print("<"); break;
	case EQ: ps.print("=="); break;
	case NE: ps.print("!="); break;
	}
	expr2.print(ps);
	ps.print(")");
    }

	public String check(){
		String res1 = expr1.check();
		String res2 = expr2.check();
		if (res1 == null || res2 == null){
			return null;
		}
		if (res1 != res2){
			String ops = "";
			switch (op) {
				case GE: ops = ">="; break;
				case GT: ops = ">"; break;
				case LE: ops = "<="; break;
				case LT: ops = "<"; break;
				case EQ: ops = "=="; break;
				case NE: ops = "!="; break;
			}
			Logger.log(String.format("**[ERROR] for comp operator %s, lhs: %s and rhs: %s do not have same data type!", ops, expr1.toString(), expr2.toString()));
			return null;
		}
		return "";
	}
}
