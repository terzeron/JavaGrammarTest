package commons_lang3;

import org.apache.commons.lang3.ArrayUtils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayUtilsTest {
    public static void addTest() {
        int[] oldArray = {2, 3, 4, 5};
        int[] expectedArray1 = {2, 3, 4, 5, 1};
        int[] expectedArray2 = {1, 2, 3, 4, 5};
        int[] expectedArray3 = {2, 3, 4, 5, 3, 4, 5};

        // append an item
        int[] newArray = ArrayUtils.add(oldArray, 1);
        assertArrayEquals(expectedArray1, newArray);

        // insert an array to another array at the specific position
        newArray = ArrayUtils.insert(0, oldArray, 1);
        assertArrayEquals(expectedArray2, newArray);

        // array + array
        newArray = ArrayUtils.addAll(oldArray, 3, 4, 5);
        assertArrayEquals(expectedArray3, newArray);
    }

    public static void removeTest() {
        int[] oldArray = {1, 2, 3, 3, 4};
        int[] expectedArray1 = {1, 2, 3, 4};
        int[] expectedArray2 = {1, 3, 4};
        int[] expectedArray3 = {1, 2, 4};

        // 3이 한 번만 지워짐
        int[] newArray = ArrayUtils.removeElement(oldArray, 3);
        assertArrayEquals(expectedArray1, newArray);

        newArray = ArrayUtils.removeElements(oldArray, 2, 3, 5);
        assertArrayEquals(expectedArray2, newArray);

        newArray = ArrayUtils.removeAllOccurences(oldArray, 3);
        assertArrayEquals(expectedArray3, newArray);
    }

    public static void reverseTest() {
        int[] originalArray1 = {1, 2, 3, 4, 5};
        int[] originalArray2 = {1, 2, 3, 4, 5};
        int[] expectedArray1 = {1, 4, 3, 2, 5};
        int[] expectedArray2 = {5, 4, 3, 2, 1};

        ArrayUtils.reverse(originalArray1, 1, 4);
        assertArrayEquals(expectedArray1, originalArray1);

        ArrayUtils.reverse(originalArray2);
        assertArrayEquals(expectedArray2, originalArray2);
    }

    public static void shiftTest() {
        int[] originalArray1 = {1, 2, 3, 4, 5};
        int[] originalArray2 = {1, 2, 3, 4, 5};
        int[] expectedArray1 = {1, 4, 2, 3, 5};
        int[] expectedArray2 = {5, 1, 2, 3, 4};

        // right shift
        ArrayUtils.shift(originalArray1, 1, 4, 1);
        assertArrayEquals(expectedArray1, originalArray1);

        ArrayUtils.shift(originalArray2, 1);
        assertArrayEquals(expectedArray2, originalArray2);
    }

    public static void subArrayTest() {
        int[] oldArray = {1, 2, 3, 4, 5};
        int[] expectedArray = {3, 4, 5};
        int[] newArray = ArrayUtils.subarray(oldArray, 2, 7);
        assertArrayEquals(expectedArray, newArray);
    }

    public static void swapTest() {
        int[] originalArray1 = {1,2,3,4,5};
        int[] originalArray2 = {1,2,3,4,5};
        int[] expectedArray1 = {4,5,3,1,2};
        int[] expectedArray2 = {4,2,3,1,5};

        ArrayUtils.swap(originalArray1, 0, 3, 2);
        assertArrayEquals(expectedArray1, originalArray1);
        ArrayUtils.swap(originalArray2, 0, 3);
        assertArrayEquals(expectedArray2, originalArray2);
    }

    public static void main(String[] args) {
        addTest();
        removeTest();
        reverseTest();
        shiftTest();
        subArrayTest();
        swapTest();
    }
}
