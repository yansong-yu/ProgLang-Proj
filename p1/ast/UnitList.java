package ast;
import java.io.PrintStream;

public class UnitList extends ASTNode {
    public final Unit unit;
    public final UnitList unitList; 
    public UnitList(Unit u, UnitList ul, Location loc) {
        super(loc);
	unit = u;
	unitList = ul;
    }
    public UnitList(Unit u, Location loc) { 
        super(loc);
	unit = u;
        unitList = null;
    }
    public void print(PrintStream ps) {
	unit.print(ps);
	ps.println();
	if (unitList != null)
	    unitList.print(ps);
    }

    public RecordYYS check(){
        RecordYYS rec = unit.check();
        // System.out.println("Pass the unit check line 1!");
        if (rec.statusCode == false){
            return rec;
        }
        // System.out.println("Pass the unit check line 2!");
        if (unitList != null){
            rec = unitList.check();
            return rec;
        }
        return rec;
    }
}
