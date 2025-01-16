package ast;
import java.io.PrintStream;

public class FloatVarDecl extends VarDecl {
    public FloatVarDecl(String i, Location loc) {
	super(i,loc);
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }
    public RecordYYS check(){
        Boolean flag = RegisterTable.tryRegister(ident, DataTypeYYS.FLOAT);
        if (flag){
            return new RecordYYS(DataTypeYYS.FLOAT, true);
        }
        System.out.println("Error: Ident \'" + ident + "\' already defined!");
        return new RecordYYS(DataTypeYYS.NULL, false);
    }
}
