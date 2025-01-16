package ast;
import java.io.PrintStream;

public class IntVarDecl extends VarDecl {
    public IntVarDecl(String i, Location loc) {
	super(i,loc);
    }
    public void print(PrintStream ps) {
	ps.print("int " + ident);
    }
    public RecordYYS check(){
        Boolean flag = RegisterTable.tryRegister(ident, DataTypeYYS.INT);
        if (flag){
            return new RecordYYS(DataTypeYYS.INT, true);
        }
        System.out.println("Error: Ident \'" + ident + "\' already defined!");
        return new RecordYYS(DataTypeYYS.NULL, false);
    }
}
