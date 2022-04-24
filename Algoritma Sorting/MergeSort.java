import java.util.ArrayList;
import java.util.Scanner;

public class ExampleClass1 {
    private final ArrayList<Integer> arrayToSort;

    public ExampleClass1(ArrayList<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public ArrayList<Integer> getArrayAfterSorting() {
        return arrayToSort;
    }

    public void divideArrayElements(int indexStart, int indexEnd) {

        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
            int middleElement = (indexEnd + indexStart) / 2;

            divideArrayElements(indexStart, middleElement);
            divideArrayElements(middleElement + 1, indexEnd);

            mergeArrayElements(indexStart, middleElement, indexEnd);
        }
    }

    public void mergeArrayElements(int indexStart, int indexMiddle, int indexEnd) {

        ArrayList<Integer> tempArray = new ArrayList<>();

        int getLeftIndex = indexStart;
        int getRightIndex = indexMiddle + 1;

        while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) {

            if (arrayToSort.get(getLeftIndex) <= arrayToSort.get(getRightIndex)) {

                tempArray.add(arrayToSort.get(getLeftIndex));
                getLeftIndex++;

            } else {

                tempArray.add(arrayToSort.get(getRightIndex));
                getRightIndex++;

            }
        }

        while (getLeftIndex <= indexMiddle) {
            tempArray.add(arrayToSort.get(getLeftIndex));
            getLeftIndex++;
        }

        while (getRightIndex <= indexEnd) {
            tempArray.add(arrayToSort.get(getRightIndex));
            getRightIndex++;
        }


        for (int i = 0; i < tempArray.size(); indexStart++) {
            arrayToSort.set(indexStart, tempArray.get(i++));

        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Panjang Array : ");
        int panjang = scan.nextInt();
        for (int i = 0; i < panjang; i++) {
            int nilai = scan.nextInt();
            integerArrayList.add(nilai);
        }

        ExampleClass1 exampleClass1 = new ExampleClass1(integerArrayList);

        System.out.print("Array Sebelum Merge Sort : ");
        for (Integer integer : exampleClass1.getArrayAfterSorting()) {
            System.out.print(integer+" ");
        }

        System.out.println();

        exampleClass1.divideArrayElements(0, integerArrayList.size() - 1);

        System.out.print("Array Setelah Merge Sort : ");
        for (Integer integer : exampleClass1.getArrayAfterSorting()) {
            System.out.print(integer+" ");
        }
        System.out.println();

    }
}