package org.example;

import java.util.Arrays;

public class ArrayReverser {
    ArrayFlattner flattner;

    public ArrayReverser() {
        this.flattner = new ArrayFlattner();
    }

    public int[] reverseArray(int[][] values) {
        if (values == null || values.length == 0) {
            return new int[0];
        }

        int[] flat = this.flattner.flattenArray(values);
        int[] result = Arrays.stream(flat).sorted().toArray();

        return result;
    }
}
