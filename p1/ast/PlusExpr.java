package ast;
import java.io.PrintStream;

public class PlusExpr extends Expr {
    public final Expr expr1, expr2;
    public PlusExpr(Expr e1, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	ps.print("+");
	expr2.print(ps);
	ps.print(")");
    }
	public RecordYYS check(){
		RecordYYS recRight = expr2.check();
		RecordYYS recLeft = expr1.check();
		if (recLeft.statusCode && recRight.statusCode){
			if (recLeft.dataType == recRight.dataType){
				return recLeft;
			}
			System.out.println("Error: Data types don't match for Plus " + expr1 + " and " + expr2);
			return new RecordYYS(DataTypeYYS.NULL, false);
		}
		
		return new RecordYYS(DataTypeYYS.NULL, false);
	}
}
