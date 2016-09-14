package com.nov.bit.operation;

import java.util.Arrays;

public class MathUtils {

/*lab11
    Реализовать функцию, которая по целочисленому аргументу c возвращает количество целочисленных решений неравенства
    a*a + b*b <= c a > 0 b > 0
    Например
    lookFor(14) == 8
    поскольку для решения подходят следующие пары значений
            (a=1,b=1), (a=1,b=2), (a=1,b=3), (a=2,b=1), (a=2,b=2), (a=2,b=3), (a=3,b=1), (a=3,b=2)
*/
    public static int lookFor(int max) {
        int result = 0;

        for (int i = 1; i <= Math.sqrt(max); i++) {
            for (int j = 1; j <= Math.sqrt(max); j++) {
                if (i*i + j*j <= max) result++;
            }
        }

        return result;
    }

/*lab12
    На вход подается одномерный массив. Необходимо, найти диапазон максимальной ширины, элементы которого положительные (больше 0)
    В качестве ответа должен быть массив из 2х элементов, где
    - элемент №0 - индекс элемента левой границы отрезка
    - элемент №1 - индекс элемента правой границы отрезка
    Если таких отрезков несколько - вернуть самый левый. Если в массиве отсутствует такой отрезок (все числа отрицательны) - вернуть пустой массив.
            Например
    lookFor([1, 1, 1]) = [0, 2]
    lookFor([0, 1, 1]) = [1, 2]
    lookFor([1, 1, 0]) = [0, 1]
    lookFor([0, -100, 1, 1, 0, -1]) = [2, 3]
    lookFor([1, 1, 0, 1, 1]) = [0, 1] // возвращаем левый
    lookFor([0, -1, 0, -1]) = [] // отсутствуют положительные числа

  *lab13
  * Лабораторная совпадает с предыдущей кроме следующего случая - при наличии 2х отрезков равной длинны, выбрать ПРАВЫЙ, а не левый.
    */
    public static int[] lookFor(int[] array) {
        int[] result = {0,-1};

        int beginIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                beginIndex = i;
                for (; i < array.length; i++) {
                    if (array[i] <= 0) break;
                }
                if (i - 1 - beginIndex > result[1] - result[0]) {
// lab 13               if (i - 1 - beginIndex >= result[1] - result[0]) {
                    result[0] = beginIndex;
                    result[1] = i - 1;
                }
            }
        }

        if (result[1] == -1) {
            return new int[0];
        } else {
            return result;
        }
    }


    public static void main(String[] args) {
        System.out.println(lookFor(2));

        System.out.println(Arrays.toString(lookFor(new int[]{1})));
        System.out.println(Arrays.toString(lookFor(new int[]{0,1})));
        System.out.println(Arrays.toString(lookFor(new int[]{1, 1, 1})));
        System.out.println(Arrays.toString(lookFor(new int[]{0, 1, 1})));
        System.out.println(Arrays.toString(lookFor(new int[]{1, 1, 0})));
        System.out.println(Arrays.toString(lookFor(new int[]{0, -100, 1, 1, 0, -1})));
        System.out.println(Arrays.toString(lookFor(new int[]{1, 1, 0, 1, 1})));
        System.out.println(Arrays.toString(lookFor(new int[]{0, -1, 0, -1})));
    }
} 