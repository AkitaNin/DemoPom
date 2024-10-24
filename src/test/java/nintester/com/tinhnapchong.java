package nintester.com;

class Adder{
    static int add (int a, int b){
        return a +b;
    }

    static int add (int a, int b, int c){
        return a +b+c;
    }

    static String add (String a, String b, String c){
        return a +b+c;
    }
}



public class tinhnapchong {
    public static void main(String[] args) {
        System.out.println(Adder.add(1,9));
        System.out.println(Adder.add(1,2,9));
        System.out.println(Adder.add("a","b","c"));
    }


}
