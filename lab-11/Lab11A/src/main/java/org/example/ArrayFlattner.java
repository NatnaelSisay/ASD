package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattner {
    public int[] flattenArray(int[][] empty) {
        if (empty.length == 0) return new int[0];

        List<Integer> values = new ArrayList<>();

        for (int[] val : empty) {
            for (int n : val) {
                values.add(n);
            }
        }

        int[] result = values.stream().mapToInt(n -> n.intValue()).toArray();
        return result;
    }
}
