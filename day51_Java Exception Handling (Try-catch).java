import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
      try {
      int x = sc.nextInt();
      int y = sc.nextInt();
      System.out.println(x / y);
    } catch(ArithmeticException | InputMismatchException e) {
      if (e instanceof ArithmeticException) {
        System.out.println("java.lang.ArithmeticException: / by zero");
      } else if (e instanceof InputMismatchException){
        System.out.println("java.util.InputMismatchException");
      }
    }
    sc.close();
        
    }
}