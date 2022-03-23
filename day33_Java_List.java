import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       ArrayList<Integer> javalist = new ArrayList<>();
       for(int i=0; i<n; i++){
           int elemen = sc.nextInt();
           javalist.add(elemen);
       }
       int q = sc.nextInt();
       for(int i=0; i<q; i++){
           String list = sc.next();
           if(list.equals("Insert")){
               int x = sc.nextInt();
                int y = sc.nextInt();
                javalist.add(x,y);
           }else {
               int x = sc.nextInt();
               javalist.remove(x);
           }
           
           
       }
       Iterator itr = javalist.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
    }
    
}