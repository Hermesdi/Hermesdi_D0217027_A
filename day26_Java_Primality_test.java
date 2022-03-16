import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args)  {
        BigInteger bi = new BigInteger(sc.nextLine());
        sc.close();
        System.out.println(bi.isProbablePrime(10)?"prime":"not prime");
    }
}