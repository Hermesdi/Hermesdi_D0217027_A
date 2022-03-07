import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        boolean isPalindro = true;
        for(int i=0; i<A.length(); i++){
            if(!A.substring(i, i+1).equals(A.substring(A.length()-1-i, A.length()-i ))){
                isPalindro=false;
                break;
                
            }
        }
        if (isPalindro){
            System.out.println("Yes");   
        }else{
            System.out.println("No");
        }
        
    }
}

