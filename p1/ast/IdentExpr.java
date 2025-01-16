package ast;
import java.io.PrintStream;

public class IdentExpr extends Expr { // 这个应该是中间用这个变量的时候
    public final String ident; 
    public IdentExpr(String i, Location loc) {
	super(loc);
	ident = i;
    }
    public void print(PrintStream ps) {
	ps.print(ident);
    }
    public RecordYYS check(){
        DataTypeYYS dataType = RegisterTable.checkRegistered(ident);
        if (dataType == DataTypeYYS.NULL){
            System.out.println("Error: Ident \'" + ident + "\' is not declared!");
            return new RecordYYS(dataType, false);
        }
        return new RecordYYS(dataType, true);
    }
    
}
