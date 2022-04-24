import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RadixSort {
    public static final int ARRAY_LENGTH = 107;
    public static final int ARRAY_MAX_VALUE = 100;

    public static final String LOG_PREFIX = "=====================";
    public static final String LOG_SUFFIX = LOG_PREFIX;
    public static final String ARR_DELIMITER = "\t";

    public static void main(String[] args) {
        // 1. generate input array
        Random random = new Random();

        int[] intArr = new int[ARRAY_LENGTH];
        printLine(LOG_PREFIX + "The original array is:" + LOG_SUFFIX);
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = random.nextInt(ARRAY_MAX_VALUE);
            print(intArr[i]);
            if (i != intArr.length - 1) {
                print(ARR_DELIMITER);
            }
        }
        printLine("");

        // 2. radix sort
        radixSort(intArr);

        // 3. print sorted array
        printLine(LOG_PREFIX + "The sorted array is:" + LOG_SUFFIX);
        printLine(join(intArr, ARR_DELIMITER));
    }

    private static void radixSort(int[] intArr) {
        int maxDigits = String.valueOf(ARRAY_MAX_VALUE).length();
        for (int i = 1; i <= maxDigits; i++) {
            sortByDigit(intArr, i);
        }
    }

    private static void sortByDigit(int[] intArr, int i) {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
        for (int item : intArr) {
            int digit = getDigit(item, i);
            List<Integer> list = map.get(digit);
            if (list == null) {
                list = new ArrayList<Integer>();
                map.put(digit, (ArrayList<Integer>) list);
            }
            list.add(item);
        }
        int index = 0;
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            for (int item : list) {
                intArr[index++] = item;
            }
        }
    }

    private static int getDigit(int item, int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(item));
        String reverseStr = sb.reverse().toString();
        if (reverseStr.length() >= i) {
            return Integer.valueOf(reverseStr.charAt(i - 1));
        } else {
            return 0;
        }
    }

    public static void print(Object t) {
        System.out.print(t);
    }

    public static void printLine(Object t) {
        System.out.println(t);
    }

    public static String join(int[] arr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int element : arr) {
            sb.append(element);
            sb.append(delimiter);
        }
        return sb.substring(0, sb.length());
    }

}