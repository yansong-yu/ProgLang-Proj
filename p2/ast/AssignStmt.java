package ast;
import java.io.PrintStream;

public class AssignStmt extends Stmt {
    public final String ident;
    public final Expr expr;
    public AssignStmt(String i, Expr e, Location loc) {
	super(loc);
	ident = i;
	expr = e;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + ident + " = ");
	expr.print(ps);
	ps.print(";");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }

    public String check(){
        String identType = TableTree.root.find(ident);
        String exprType = expr.check();
        if (identType == null){
            Logger.log(String.format("**[ERROR]: variable %s has not been declared!", ident));
        }
        if (exprType == null){
            return null;
        }
        if (identType != exprType){
            Logger.log(String.format("**[ERROR] lhs: %s and rhs: %s have different data type!", ident, expr.toString()));
            return null;
        }
        return identType;
    }
}
