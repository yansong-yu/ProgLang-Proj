package ast;
import java.util.HashMap;

public class TableTreeNode{
    public HashMap<String, String> tbl = new HashMap<>(); // ident -> type: "FLOAT", "INT"
    public TableTreeNode parent = null;

    public boolean insert(String ident, String type){ // a new var declared
        if (tbl.containsKey(ident))
            return false; // ident already declared in this block
        tbl.put(ident, type);
        return true;
    }

    public String find(String ident){
        TableTreeNode node = this;
        while (node.tbl.containsKey(ident) == false){
            if (node.parent == null)
                break;
            node = node.parent;
        }
        if (node.tbl.containsKey(ident) == true){
            return node.tbl.get(ident);
        }
        return null;
    }
}