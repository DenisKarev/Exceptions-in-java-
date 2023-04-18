import java.util.Arrays;
import java.util.Random;

public class HW01_1Exceptions {
    public static Random rnd = new Random();

    public static void main(String[] args) {
        // int[] a1 = null; // for NullPointerException
        // int[] a2 = null; // for NullPointerException
        try {
            // sumTwoArrays(a1, a2); // for NullPointerException

            int[] res = diffTwoArrays(genArray(12), genArray(12));
            System.out.printf("Resulting array %s\n", Arrays.toString(res));
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    // Реализуйте метод, принимающий в качестве аргументов два целочисленных
    // массива,
    // и возвращающий новый массив, каждый элемент которого равен разности элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны,
    // необходимо как-то оповестить пользователя.

    /**
     * @param arr1 first array
     * @param arr2 second array
     * @return array of same size
     * @throws NullPointerException if one of arrays (or both) are null
     * @throws RuntimeException     if array sizes does not equal
     */
    private static int[] diffTwoArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Array(s) should not be null");
        if (arr1.length == arr2.length) {
            int resarr[] = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                resarr[i] = arr1[i] - arr2[i];
            }
            return resarr;
        } else {
            throw new RuntimeException("Arrays have different sizes");
        }
    }

    private static int[] genArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(51);
        }
        return arr;
    }
}