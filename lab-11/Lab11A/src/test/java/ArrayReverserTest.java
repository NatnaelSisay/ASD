import org.example.ArrayFlattner;
import org.example.ArrayReverser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ArrayReverserTest {
    @Mock
    ArrayFlattner arrayFlattner;
    ArrayReverser reverser;

    @BeforeEach
    public void beforeEach() {
        reverser = new ArrayReverser();
    }

    @AfterEach
    public void afterEach() {
        reverser = null;
    }

    @Test
    public void testNullArrayReturnEmpty() {
        int[] result = reverser.reverseArray(null);
        assertArrayEquals(new int[0], result);
    }

    @Test
    public void testEmptyArrayReturnEmpty() {
        int[][] empty = new int[0][];
        int[] result = reverser.reverseArray(empty);
        assertArrayEquals(new int[0], result);
    }

    @Test
    public void testValidArrayInput() {
        int[][] values = {{1}, {3}, {3}};

        lenient().when(arrayFlattner.flattenArray(values)).thenReturn(new int[]{1, 3, 3});

        int[] result = reverser.reverseArray(values);
        int[] expected = {1, 3, 3};

        assertArrayEquals(expected, result);

        verify(arrayFlattner, atMostOnce()).flattenArray(values);
    }
}
