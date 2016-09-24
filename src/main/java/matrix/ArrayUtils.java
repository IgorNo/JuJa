package matrix;

public class ArrayUtils {

    public static void main(String[] args) {
        int[][] arg = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotateClockwise2D(arg);

        int[][][] arg3D = {{{10,11,12}, {20,21,22}, {30,31,32}},
                           {{40,41,42}, {50,51,52}, {60,61,62}},
                           {{70,71,72}, {80,81,82}, {90,91,92}}};
        rotateClockwise3D(arg3D);
    }

    public static int[][] rotateClockwise2D(int[][] arg) {

        if (arg == null ) return null;
        int dimension = arg.length;
        if (dimension < 1) return null;
        for (int i = 0; i < dimension; i++) {
            if (arg[i] == null || arg[i].length != dimension) return null;
        }

        int[][] result = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result[j][dimension - 1 - i] = arg[i][j];
            }
        }

        return result;
    }

    public static int[][][] rotateClockwise3D(int[][][] arg) {

        if (arg == null ) return null;
        int dim = arg.length;
        if (dim < 1) return null;
        for (int i = 0; i < dim; i++) {
            if (arg[i] == null || arg[i].length != dim) return null;
            for (int j = 0; j < dim; j++) {
                if (arg[i][j] == null || arg[i][j].length != dim) return null;
            }
        }

        int[][][] result = new int[dim][dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                for (int k = 0; k < dim; k++) {
                    result[j][k][i] = arg[i][j][k];
                }
            }
        }

        return result;
    }
} 