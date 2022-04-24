import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    ArrayList<Integer> nilai = new ArrayList();
    Scanner sc = new Scanner (System.in);
    System.out.println("Masukkan Panjang Array : ");
    int panjang = sc.nextInt();
    for (int i=0;i<panjang; i++){
        System.out.println("Index ke "+i+":");
        int angka = sc.nextInt();
        nilai.add(angka);
    }
    System.out.println(nilai);

    for(int i=0; i< nilai.size(); i++){
        for(int j=0; j<nilai.size()-1; j++){
            if (nilai.get(j)>nilai.get(j+1)){
                int temp = nilai.get(j);
                nilai.set(j, nilai.get(j+1));
                nilai.set(j+1, temp);
            }
        }

    }
    System.out.println(nilai);
}
}
