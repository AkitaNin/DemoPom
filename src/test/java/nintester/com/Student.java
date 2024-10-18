package nintester.com;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Student {
    public String name;
    public int age;


    public void display (){
        System.out.println("Name is: " +name);
        System.out.println("Age is: " +age);
    }

    public void getInfor(){
       name = "Tài chó điên";
       age = 30;
    }

}