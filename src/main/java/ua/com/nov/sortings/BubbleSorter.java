package ua.com.nov.sortings;

import java.util.Arrays;

/**
 * Перепишите алгоритм на такой, при котором "тонет" самый маленький элемент.
 * Порядок сортировки должен сохраниться - по возрастанию.
 * Элементы должны перебираться справа - налево.
 * Всплывал - вправо, тонет - влево. Цикл не доходил до правого конца, теперь - не доходит до левого.
 * В массиве из 6 элементов должны сравниваться (и в случае инверсии переставляться)
 * пары 4-5 3-4 2-3 1-2 0-1 4-5 3-4 2-3 1-2 4-5 3-4 2-3 4-5 3-4 4-5
 * */

public class BubbleSorter {
    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length; barrier++) {
            for (int index = arr.length - 1; index >= barrier + 1; index--) {
                if (arr[index] < arr[index - 1]) {
                    int tmp = arr[index];
                    arr[index] = arr[index - 1];
                    arr[index - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,6,5,3,2,0};
        int[] arr = {};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}