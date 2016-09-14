package com.nov.bit.operation;

public class BitIndex {
    private long data;

    public BitIndex(boolean allTrue) {
        data = allTrue ? -1 : 0;
    }

    public boolean get(int index) {
       return (data & (1 << index)) != 0;
    }

    public void set(int index, boolean value) {
        if (value) {
            data = data | (1 << index) ;
        } else {
            data = data & ~(1 << index);
        }
    }
}

class BitIndexTest {
    public static void main(String[] args) {
        BitIndex index = new BitIndex(false);
        index.set(19, true);
        index.set(62, true);
        System.out.println(index.get(29));
        System.out.println(index.get(19));
    }
}
