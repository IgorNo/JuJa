package ua.com.nov.string;

/*
* Реализовать функцию, которая делает циклический сдвиг букв вправо, то есть
* rightShift("ABCDE", 1) = "EABCD" rightShift("ABCDE", 2) = "DEABC" rightShift("ABCDE", 3) = "CDEAB" rightShift("ABCDE", 4) = "BCDEA"
* Допустимо сдвигать на расстояние больше длины строки
* rightShift("ABCDE", 5) = "ABCDE" rightShift("ABCDE", 6) = "EABCD" rightShift("ABCDE", 7) = "DEABC"
* Допустимо сдвигать на отрицательное расстояние (выходит сдвиг влево)
* rightShift("ABCDE", -1) = "BCDEA" rightShift("ABCDE", -2) = "CDEAB" rightShift("ABCDE", -7) = "CDEAB".
* Сдвиг на расстояние 0 и сдвиги строк длиной 0 и 1 символ - разрешены.
* */
public class StringUtils {
    public static String rightShift(String arg, int delta) {
        int deltaNorm;
        if (arg.length() > 0) {
            long temp = Math.abs((long) delta) % arg.length();
            deltaNorm = (int) temp;
        } else {
            return "";
        }

        if (delta > 0) {
            return arg.substring(arg.length() - deltaNorm) + arg.substring(0, arg.length() - deltaNorm);
        } else {
            return arg.substring(deltaNorm) + arg.substring(0,deltaNorm);
        }

    }

    public static void main(String[] args) {
        System.out.println(rightShift("ABCDE", 1));
        System.out.println(rightShift("ABCDE", 2));
        System.out.println(rightShift("ABCDE", 3));
        System.out.println(rightShift("ABCDE", 4));
        System.out.println(rightShift("ABCDE", 5));
        System.out.println(rightShift("ABCDE", -1));
        System.out.println(rightShift("ABCDE", -2));
        System.out.println(rightShift("ABCDE", -3));
        System.out.println(rightShift("ABCDE", -4));
        System.out.println(rightShift("ABCDE", -5));
        System.out.println(rightShift("ABCDE", Integer.MIN_VALUE));
    }
} 