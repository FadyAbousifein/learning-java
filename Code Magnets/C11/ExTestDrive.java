import java.util.function.DoubleUnaryOperator;

class MyEx extends Exception {

}

public class ExTestDrive {
    public static void main(String[] args) {
        String test = args[0]; 
        try {
            doRisky(test); 
        } catch (MyEx e) {
            System.out.print("a");
            System.out.print("w");
        } finally {
            System.out.print("s");
        }
    }
    static void doRisky(String t) throws MyEx {
        if("yes".equals(t)) {
            System.out.print("t");
        }
        System.out.print("h");
        throw new MyEx();
    }
}
