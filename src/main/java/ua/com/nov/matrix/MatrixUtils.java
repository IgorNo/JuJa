package ua.com.nov.matrix;

import java.util.Arrays;

public class MatrixUtils {

    public static void main(String[] args) {
        int[][] fst = {{1,2}, {7,8}, {3,4}};
        int[][] snd = {{3,4,5,6}, {9,0,1,2}};

        System.out.println(Arrays.toString(mul(fst,snd)));
    }

    public static int[][] mul(int[][] fst, int[][] snd) {

        if (fst == null || snd == null) throw new IllegalArgumentException();
        if (fst[0] == null || snd[0] == null) throw new IllegalArgumentException();
        if (fst[0].length != snd.length) throw new IllegalArgumentException();
        int fstWidth = fst[0].length;
        for (int i = 1; i < fst.length; i++) {
            if (fst[i] == null || fst[i].length != fstWidth) throw new IllegalArgumentException();
        }
        int sndWidth = snd[0].length;
        for (int i = 1; i < snd.length; i++) {
            if (snd[i] == null || snd[i].length != sndWidth) throw new IllegalArgumentException();
        }

        int[][] result = new int[fst.length][sndWidth];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < fstWidth; k++) {
                    result[i][j] += fst[i][k] * snd[k][j];
                }
            }
        }

        return result;
    }
} 