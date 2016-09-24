package ua.com.nov.recursion;

public class ExchangeMoney {

    private static int[] nominals = {1, 2, 5, 10, 25, 50};

    public static void main(String[] args) {
        System.out.println(exchangeAmountOfCoinsBrutForce(5));
        System.out.println(exchangeAmountOfCoinsBrutForce(10));
        System.out.println(exchangeAmountOfCoinsBrutForce(100));
        System.out.println(exchangeAmountOfCoinsMatrix(5));
        System.out.println(exchangeAmountOfCoinsMatrix(10));
        System.out.println(exchangeAmountOfCoinsMatrix(100));
    }

    public static int exchangeAmountOfCoinsBrutForce(int amountForExchange) {
        if (amountForExchange <= 0) return 0;
        int result = 0;
        int sum;
        for (int i5 = 0; i5 <= amountForExchange / nominals[5] ; i5++) {
            for (int i4 = 0; i4 <= amountForExchange / nominals[4]; i4++) {
                for (int i3 = 0; i3 <= amountForExchange / nominals[3] ; i3++) {
                    for (int i2 = 0; i2 <= amountForExchange / nominals[2]; i2++) {
                        for (int i1 = 0; i1 <= amountForExchange / nominals[1] ; i1++) {
                            for (int i0 = 0; i0 <= amountForExchange / nominals[0]; i0++) {
                                sum = i5 * nominals[5] + i4 * nominals[4] + i3 * nominals[3] +
                                        i2 * nominals[2] + i1 * nominals[1] + i0 * nominals[0];
                                if (sum == amountForExchange) {
                                    result++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static int exchangeAmountOfCoinsMatrix(int amountForExchange) {
        if (amountForExchange <= 0) return 0;

        int numberOfNominals = nominals.length;
        int[][] combinations = new int[amountForExchange + 1][numberOfNominals];

        for (int i = 0; i < numberOfNominals; i++) {
            combinations[0][i] = 1;
        }

        for (int number = 1; number <= amountForExchange; number++) {
            for (int nominalIndex = 0; nominalIndex < numberOfNominals; nominalIndex++) {
                int rest = number - nominals[nominalIndex];
                int current = 0;
                if (rest >= 0) {
                    current = combinations[rest][nominalIndex];
                }

                int previous = 0;
                if (nominalIndex > 0) {
                    previous = combinations[number][nominalIndex - 1];
                }

                combinations[number][nominalIndex] = current + previous;
            }
        }

        return combinations[amountForExchange][numberOfNominals - 1];
    }

} 