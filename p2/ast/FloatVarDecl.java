package ast;
import java.io.PrintStream;

public class FloatVarDecl extends VarDecl {
    public FloatVarDecl(String i, Location loc) {
	super(i,loc);
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }
    public String check(){
        Boolean flag = TableTree.root.insert(ident, "FLOAT");
        if (flag == false){
            Logger.log(String.format("**[ERROR] variable %s has already been declared in the code block!", ident));
            return null;
        }
        return "FLOAT";
    }
}
