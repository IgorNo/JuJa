package sortings;

import java.util.Arrays;
import java.util.Random;

public class InsertionSorter {

    // Такая версия алгоритм сортировки вставками :
    public static void sortNotOptimal(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }
    }

    public static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = Arrays.binarySearch(arr, 0, k, newElement);
            if (location++ < 0) {
                location = -location;
            }
            System.arraycopy(arr, location, arr, location + 1, k - location);
            arr[location] = newElement;
        }
    }

    private static boolean hasSorted(int[] arr, int k) {
        for (int i = 1; i < k; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -6, -5, -3, -2, 0, -7, -8, 0, -10, -9};
//        int[] arr = {};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
/*реализована не оптимально, так как внутренний цикл while
- ищет позицию для вставки, перебирая последовательно элементы, при этом он 
- поэлементно "смещает" массив.*/

/*В целях оптимизации перепишите алгоритм:
1. Ищите позицию для вставки элемента бинарным поиском (Arrays.binarySearch(...)). 
2. Найдя позицию - смещайте всю часть массива за один вызов (System.arraycopy(...)). 
В моих экспериментах эти две оптимизации ускорили сортировку в 2.2-2.6 раза. Скорость сортировки измерял данным кодом*/


class Test {
    public static void main(String[] args) {
        // fill random elements
        Random rnd = new Random(0);
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }
        // library sort
        int[] expected = array.clone();
        Arrays.sort(expected);
        // lab sort
        int[] actual = array.clone();
        InsertionSorter.sort(actual);
        // compare results: library vs lab
        if (!Arrays.equals(actual, expected)) {
            throw new AssertionError("expected = " + Arrays.toString(expected) + " but actual  = " + Arrays.toString(actual));
        }

        System.out.print("OK");
    }
}