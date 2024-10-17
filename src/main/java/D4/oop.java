package D4;

class testClass {
    public int num1 = 10;
    public int num2 = 20;

    public int Plus(int a, int b){
        return a+b;
    }

    public void printX(int a, int b) {
        System.out.println("Kết quả: " +Plus(a,b));
    }
}


public class oop {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;

        //Khởi tạo 1 object thuộc 1 class
        testClass obj = new testClass();
        //obj.Plus(a,b);
        obj.printX(a,b);// cách gọi ra các thành phần trong class thông qua obj




    }
}
