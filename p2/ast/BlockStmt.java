package ast;
import java.io.PrintStream;

public class BlockStmt extends Stmt {
    public final UnitList block;
    public BlockStmt(UnitList b, Location loc) {
	super(loc);
	block = b;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "{\n");
	block.print(ps, indent + "  ");
	ps.print(indent + "}");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
    public String check(){
        TableTreeNode node = new TableTreeNode();
        node.parent = TableTree.root;
        TableTree.root = node;
        String res = block.check();
        TableTree.root = node.parent;
        return res;
    }
}
