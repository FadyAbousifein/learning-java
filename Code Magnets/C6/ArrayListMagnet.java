import java.util.ArrayList;

public class ArrayListMagnet {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(0, "Zero");
        a.add(1, "One");
        a.add(2, "Two"); 
        a.add(3, "Three"); 
        printAL(a);

        a.remove(2); 
        if(a.contains("Three")) {
            a.add("Four"); 
        }
        printAL(a);

        if(a.indexOf("four") != 4) {
            a.add(4, "4.2"); 
        }
        printAL(a);

        if(a.contains("two")) {
            a.add("2.2");
        }
        printAL(a);
    }

    public static void printAL(ArrayList<String> al) {
        for(String element : al) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }
}

