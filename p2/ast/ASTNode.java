package ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
abstract class ASTNode {
    public final Location loc;
    ASTNode(Location loc) { this.loc = loc; }
    public abstract void print(PrintStream ps);
    public String toString() { 
	ByteArrayOutputStream b = new ByteArrayOutputStream();
	print(new PrintStream(b));
	return new String(b.toByteArray(),java.nio.charset.StandardCharsets.UTF_8);
    }

    public String check(){
        System.out.println("[ERROR] Check method has not yet been implemented!");
        return null; // null 表示错误
    }
}


/**
 * 整体逻辑：
 * 属性文法！
 * table 指针
 * type 属性
 * table 树：一开始只有一个根结点，只要遇到block就创建一个表作为子节点
 */
