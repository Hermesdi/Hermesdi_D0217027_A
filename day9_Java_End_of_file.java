import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        
        int Nomor_Baris=1;
        while (scanner.hasNext()){
         System.out.println(Nomor_Baris + " "+ scanner.nextLine());
         Nomor_Baris++;
        }
        scanner.close();
      
    }
}