package ua.com.nov.big.numbers;

import java.math.BigInteger;
import java.util.Arrays;

/*
    *Предположим, что мы работаем с полиномами и храним их в виде последовательности коэффициентов.
    * То есть полином f = 1 * x*x*x + 2*x*x + 3*x + 4 представляем в виде [1, 2, 3, 4]

    Полином f = 10 * x*x - 100 представляем в виде [10, 0, -100]

* */
public class PolyUtils {
    /*
    Реализовать вычисление полинома в точке, то есть нам, скажем,
    дают полином f = 2*x*x*x - 3*x в виде [2, 0, -3, 0] и точку 100,
    а мы должны вычислить 2*100*100*100 - 3*100 = 2000000 - 300 = 1999700
    * */
    public static BigInteger eval(BigInteger[] poly, BigInteger arg) {
        BigInteger result = BigInteger.ZERO;
        BigInteger multArg = BigInteger.ONE;

        for (int i = 0; i < poly.length; i++) {
            result = result.add(poly[poly.length - 1 - i].multiply(multArg));
            multArg = multArg.multiply(arg);
        }

        return result;
    }

    /*
    Реализовать произведение полиномов,
    то есть нам дают полиномы f1 = x + 1 в виде [1, 1] и f2 = x + 1 в виде [1, 1]
    то мы должны вычислить (x + 1) * (x + 1) = x*x + 2*x + 1 в виде [1, 2, 1]
    Есть нам дают полиномы f1 = 10*x*x + 1 в виде [10, 0, 1] и f2 = -x в виде [-1, 0]
     то мы должны вычислить (10*x*x + 1) * (-x) = -10*x*x*x -x в виде [-10, 0, -1, 0]
    * */
    public static BigInteger[] mul(BigInteger[] x, BigInteger[] y) {
        BigInteger[] result = new BigInteger[x.length + y.length - 1];
        Arrays.fill(result, BigInteger.ZERO);

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                result[i + j] = result[i + j].add(x[i].multiply(y[j]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BigInteger[] poly = {
                new BigInteger("2"),
                new BigInteger("0"),
                new BigInteger("-3"),
                new BigInteger("0"),
        };

        System.out.println(eval(poly, BigInteger.valueOf(100)));

        BigInteger[] poly1 = {
                new BigInteger("10"),
                new BigInteger("0"),
                new BigInteger("1"),
        };
        BigInteger[] poly2 = {
                new BigInteger("-1"),
                new BigInteger("0"),
        };

        System.out.println(Arrays.toString(mul(poly1, poly2)));
    }
}
