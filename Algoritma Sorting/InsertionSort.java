import java.util.ArrayList;
import java.util.Scanner;
public class Seelection {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList();
         
        Scanner scan = new Scanner(System.in);
        System.out.print("Panjang Array : ");
        int panjang = scan.nextInt();
        for (int k = 0; k < panjang; k++) {
            System.out.print("index ke "+k+" : ");
           int nilai = scan.nextInt();
           arr.add(nilai);
        }
        int n = arr.size();
        int i = 1;
        int j;
        while(i<n){
            int temp = arr.get(i);
            for (j = i; j > 0; j--) {
                if (temp < arr.get(j-1)) {
                    arr.set(j, arr.get(j-1));
                }
                else{
                    break;
                }
            }
            arr.set(j, temp);
            i++;
        }
        System.out.println(arr);
   }
}