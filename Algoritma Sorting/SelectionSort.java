import java.util.*;
import java.lang.Math;

public class JavaApplication1 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int panjang, i, j;
        
        panjang = input.nextInt();
        ArrayList<Integer> arr = new ArrayList();
        
        for (i = 0; i <= panjang - 1; i++) {
            int nilai = input.nextInt();
            arr.add(nilai);
        }
        for (i = 0; i <= panjang - 2; i++) {
            int jMin;
            
            jMin = i;
            for (j = i+1; j <= panjang - 1; j++) {
                if (arr.get(j) < arr.get(jMin)) {
                    jMin = j;
                }
            }
            if (jMin != i) {
                int temp, a, b;
                temp = arr.get(i);
                arr.set(i, arr.get(jMin));
                arr.set(jMin, temp);
            }
        }
        System.out.println(arr);
    }
}