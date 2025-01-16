package ast;
import java.io.PrintStream;

public abstract class Unit extends ASTNode {
    public Unit(Location loc) {
	super(loc);
    }
}


// 运动时这些抽象类必然是某些具体类的instance，所以只需要给具体类实现check即可！！！