package ast;
import java.io.PrintStream;

public class IntVarDecl extends VarDecl {
    public IntVarDecl(String i, Location loc) {
	super(i,loc);
    }
    public void print(PrintStream ps) {
	ps.print("int " + ident);
    }

    public String check(){
        Boolean flag = TableTree.root.insert(ident, "INT");
        if (flag == false){
            Logger.log(String.format("**[ERROR] variable %s has already been declared in the code block!", ident));
            return null;
        }
        return "INT";
    }
}
