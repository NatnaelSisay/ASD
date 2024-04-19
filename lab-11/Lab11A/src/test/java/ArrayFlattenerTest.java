import org.example.ArrayFlattner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayFlattenerTest {
    ArrayFlattner flatten;

    @BeforeEach
    public void beforeEach() {
        flatten = new ArrayFlattner();
    }

    @AfterEach
    public void afterEach() {
        flatten = null;
    }

    @Test
    public void testEmptyListReturnEmptyList() {
        int[][] empty = new int[0][];
        int[] result = flatten.flattenArray(empty);
        assertArrayEquals(new int[0], result);
    }

    @Test
    public void testValidInputFlattned() {
        int[][] values = {{1}, {3}, {3}};
        int[] result = flatten.flattenArray(values);
        assertArrayEquals(new int[]{1, 3, 3}, result);
    }

    @Test
    public void testValidInputFlattnedForVariableSize() {
        int[][] values = {{1}, {3, 44, 34, 34, 22}, {3}};
        int[] result = flatten.flattenArray(values);
        assertArrayEquals(new int[]{1, 3, 44, 34, 34, 22, 3}, result);
    }
}
