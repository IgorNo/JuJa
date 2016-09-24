package arrays;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Array {

/* lab08
    В коде инвертирования массива
        public static void invert(int[] arr) {
            for (int k = 0; k < arr.length / 2; k++) {
                int tmp = arr[k];
                arr[k] = arr[arr.length - k - 1];
                arr[arr.length - k - 1] = tmp;
            }
        }
    необходимо переписать цикл с инкремента счетчика от 0 до середины массива на цикл от середины массива
    до 0 (инкремент (k++) заменить на декремент (k--)).
*/
    public static void invert(int[] arr) {
        for (int k = arr.length / 2 - 1; k >= 0; k--) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
    }

 /*lab09
      Отфильтровать массив так, чтобы оставить только четные элементы.
      Для проверки четности можно использовать операцию остаток от деления - % 3 % 2 == 1; 6 % 2 == 0;
      Исходящий массив для простоты, должен быть того же размера, что и входящий.
      Например, для {4, 3, 5, 6, 7, 9} -> {4, 6, 0, 0, 0, 0}
*/
    public static int [] filterEven(int [] nums){
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                result[index++] = nums[i];
            }
        }
        return result;
    }

/* lab10
    Необходимо реализовать слияние сортированных массивов
*/
    public static int[] merge(int[] fst, int[] snd) {
        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;
        int i;
        for (i = 0; i < result.length; i++) {
            if (fstIndex == fst.length || sndIndex == snd.length)  break;
            result[i] = fst[fstIndex] < snd[sndIndex] ? fst[fstIndex++] : snd[sndIndex++];
        }
        for (int j = fstIndex; j < fst.length; j++) {
            result[i++] = fst[j];
        }
        for (int j = sndIndex; j < snd.length; j++) {
            result[i++] = snd[j];
        }

        return result;
    }

    public static void tenMethods() {
        /*0. Объявление массива*/
        String[] aArray = new String[5];
        String[] bArray = {"a","b","c", "d", "e"};
        String[] cArray = new String[]{"a","b","c","d","e"};

        /*1. Вывод массива в Java*/
        int[] intArray = { 1, 2, 3, 4, 5 };
        String intArrayString = Arrays.toString(intArray);
        // print directly will print reference value
        System.out.println(intArray);
// [I@7150bd4d
        System.out.println(intArrayString);
// [1, 2, 3, 4, 5]

        /*2. Создание ArrayList из массива*/
        String[] stringArray = { "a", "b", "c", "d", "e" };
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
        System.out.println(arrayList);
// [a, b, c, d, e]

        /*3. Проверка массива на наличие конкретного значения*/
        String[] stringArray1 = { "a", "b", "c", "d", "e" };
        boolean b = Arrays.asList(stringArray1).contains("a");
        System.out.println(b);
// true

        /*4. Объединение двух массивов*/
        int[] intArray1 = { 1, 2, 3, 4, 5 };
        int[] intArray2 = { 6, 7, 8, 9, 10 };
// Apache Commons Lang library
//        int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);

        /*5. Объявление массива в одной строке*/
        String[] strings = new String[]{"a", "b", "c", "d", "e"};

        /*6. Объединение элементов массива в строку*/
// containing the provided list of elements
// Apache common lang
        //String j = StringUtils.join(new String[] { "a", "b", "c" }, ", ");
        //System.out.println(j);
// a, b, c

        /*7. Преобразование ArrayList в массив*/
        String[] stringArray2 = { "a", "b", "c", "d", "e" };
        ArrayList<String> arrayList1 = new ArrayList<String>(Arrays.asList(stringArray2));
        String[] stringArr = new String[arrayList1.size()];
        arrayList.toArray(stringArr);
        for (String s : stringArr)
            System.out.println(s);

        /*8. Преобразование массива во множество (Set)*/
        Set<String> set = new HashSet<String>(Arrays.asList(stringArray));
        System.out.println(set);
//[d, e, b, c, a]

        /*9. Возврат массива с элементами в обратном порядке*/
        int[] intArray3 = { 1, 2, 3, 4, 5 };
        //ArrayUtils.reverse(intArray3);
        System.out.println(Arrays.toString(intArray3));
//[5, 4, 3, 2, 1]

        /*10. Удаление элемента из массива*/
        int[] intArray4 = { 1, 2, 3, 4, 5 };
        //int[] removed = ArrayUtils.removeElement(intArray4, 3);//create a new array
        //System.out.println(Arrays.toString(removed));

        /*И еще — создание массива типа byte на основе значения типа int
        (прим. берем ByteBuffer, выделяем в нем 4 байта и кладем число int 8, затем все это (0, 0, 0, 8) преобразуем в массив типа byte с помощью вызова array())
*/
        byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();
        for (byte t : bytes) {
            System.out.format("0x%x ", t);
        }
    }

    public static void main(String[] args) {
        int[] arr = {};
 //       int[] arr = {1,0};
 //       int[] arr = {2,1,0};
        invert(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] nums = {4, 3, 5, 6, 7, 9};

        for (int num :  filterEven(nums)) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] fst = {1,3,5,7,9};
        int[] snd = {2,4};
//        int[] fst = {};
//        int[] snd = {1};
        for (int i : merge(fst, snd)) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}