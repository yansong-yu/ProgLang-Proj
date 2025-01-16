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
    public void print(PrintStream ps) { 
	ps.print(ident + " = ");
	expr.print(ps);
	ps.print(";");
    }
    public RecordYYS check(){
        DataTypeYYS typeLeft = RegisterTable.checkRegistered(ident);
        if (typeLeft == DataTypeYYS.NULL){
            System.out.println("Error: Ident \'" + ident + "\' is not declared!");
            return new RecordYYS(typeLeft, false);
        }
        RecordYYS recRight = expr.check();
        if (typeLeft == recRight.dataType){
            return new RecordYYS(typeLeft, true);
        }
        System.out.println("Error: Data types do not match for assignment " + ident + " = " + expr + "!");
        return new RecordYYS(DataTypeYYS.NULL, false);
    }
}
