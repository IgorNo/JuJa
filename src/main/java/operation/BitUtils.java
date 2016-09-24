package operation;

public class BitUtils {

    /**Реализуйте метод swapBits(b, i, j), который производит "рокировку" битов с номерами i и j,
     * то есть swapBits(0b1111_0000, 0, 6) = 0b1011_0001 swapBits(0b0000_1000, 3, 1) = 0b0000_0010
     */
    public static byte swapBits(byte b, int i, int j) {
        int result = b;
        int max = Math.max(i, j);
        int min = Math.min(i, j);
        byte maxMask = (byte) (b & (1 << max));
        byte minMask = (byte)  (b & (1 << min));
        if (maxMask ==  0) {
            maxMask = (byte) ~(1 << min);
            result = result & maxMask;
        } else {
            maxMask = (byte) (1 << min);
            result = result | maxMask;
        }
        if (minMask ==  0) {
            minMask = (byte) ~(1 << max);
            result = result & minMask;
        } else {
            minMask = (byte) (1 << max);
            result = result | minMask;
        }
        return (byte) result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(swapBits((byte) 0b1000_0001, 0, 7)));
        System.out.println(Integer.toBinaryString(swapBits((byte) 0b1111_0000, 0, 6)));
        System.out.println(Integer.toBinaryString(swapBits((byte) 0b0000_1000, 3, 1)));
        System.out.println(Integer.toBinaryString(swapBits((byte) 0b0000_0001, 0, 1)));
    }
}
