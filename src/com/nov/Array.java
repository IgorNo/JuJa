package com.nov;

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