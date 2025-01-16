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
    public void print(PrintStream ps) { 
	varDecl.print(ps); 
	if (expr != null) {
	    ps.print(" = ");
	    expr.print(ps);
	}
	ps.print(";");
    }
	
	public RecordYYS check(){
		if (expr != null){
			RecordYYS recRight = expr.check();
			if (recRight.statusCode == false){
				return recRight;
			}
			RecordYYS recLeft = varDecl.check();
			if (recLeft.statusCode == false){
				return recLeft;
			}
			if (recLeft.dataType == recRight.dataType){
				return recLeft;
			}
			System.out.println("Error: Data types don't match for varDecl " + varDecl + " and " + expr);
			return new RecordYYS(DataTypeYYS.NULL, false);
		}

		RecordYYS recLeft = varDecl.check();
		return recLeft;
	}
}
