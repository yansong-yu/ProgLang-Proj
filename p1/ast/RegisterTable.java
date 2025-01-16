package ast;
import java.util.Hashtable;

public class RegisterTable{
    public static Hashtable<String, DataTypeYYS> table = new Hashtable<>(); // ident, datatype

    public static Boolean tryRegister(String ident, DataTypeYYS dataType){
        Boolean flag = table.containsKey(ident);

        if (flag == true){
            // has been declared
            return false;
        }
        table.put(ident, dataType);
        return true;
    }

    public static DataTypeYYS checkRegistered(String ident){
        Boolean flag = table.containsKey(ident);
        if (flag){
            return table.get(ident);
        }
        return DataTypeYYS.NULL;
    }
}