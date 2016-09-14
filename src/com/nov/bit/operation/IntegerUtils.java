package com.nov.bit.operation;


public class IntegerUtils {

    /** Реализовать метод leftShift(int) класса IntegerUtils,
     *  который осуществляет ЦИКЛИЧЕСКИЙ СДВИГ (биты, которые “выталкивают” с одного конца – появляются на втором конце) битов влево.
     *  То есть leftShift(int) получив число 0b00000000_00000000_00000000_00000001
     *                            возвращает 0b00000000_00000000_00000000_00000010
     *                         получив число 0b10000000_00000000_00000000_00000000
     *                            возвращает 0b00000000_00000000_00000000_00000001
     *                         получив число 0b00111000_11111111_00000000_10101010
     *                            возвращает 0b01110001_11111110_00000001_01010100
     */
    public static int leftShift(int arg) {
        int result = arg << 1;
        if ((arg & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            result = result | 1;
        }
        return result;
    }

    /**Реализовать метод rightShift(int) класса IntegerUtils,
     * который осуществляет ЦИКЛИЧЕСКИЙ СДВИГ (биты, которые “выталкивают” с одного конца – появляются на втором конце) битов вправо.
     * То есть rightShift(int) получив число 0b00000000_00000000_00000000_00000001
     *                            возвращает 0b10000000_00000000_00000000_00000000
     *                         получив число 0b10000000_00000000_00000000_00000000
     *                            возвращает 0b01000000_00000000_00000000_00000000
     *                         получив число 0b00111000_11111111_00000000_10101010
     *                            возвращает 0b00011100_01111111_10000000_01010101
     */
    public static int rightShift(int arg) {
        int result = arg >>> 1;
        if ((arg & 1) == 1) {
            result = result | Integer.MIN_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(rightShift(Integer.MIN_VALUE)));
    }
}
