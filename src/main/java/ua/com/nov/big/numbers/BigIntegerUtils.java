package ua.com.nov.big.numbers;

import java.math.BigInteger;

/*
* Реализовать метод, который преобразует BigInteger в битовую строку (String из '0' и '1') toBitStr(new BigInteger("2")) = "10"
* toBitStr(new BigInteger("8")) = "1000" toBitStr(new BigInteger("10")) = "1010" toBitStr(new BigInteger("140")) = "10001100"*/
public class BigIntegerUtils {
    public static String toBitStr(BigInteger arg) {
//        return arg.toString(2); // самое простое решение

        final int BYTE_LENGTH = 8;

        StringBuilder result = new StringBuilder();
        byte[] twoComplement = arg.toByteArray();
        for (int i = twoComplement.length - 1; i >= 0 ; i--) {
            byte mask = 1;
            for (int j = 0; j < BYTE_LENGTH; j++) {
                if ((twoComplement[i] & mask) == 0)
                    result.insert(0, '0');
                else
                    result.insert(0, '1');
                mask <<= 1;
            }
        }


        while (true){
            if (result.length() == 1 || result.substring(0, 1).equals("1")) {
                break;
            } else {
                result.deleteCharAt(0);
            }
        }


        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(toBitStr(BigInteger.valueOf(1)));
    }
} 