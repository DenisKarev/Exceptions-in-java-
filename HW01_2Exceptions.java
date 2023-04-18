import java.util.Arrays;
import java.util.Random;

public class HW01_2Exceptions {
    public static Random rnd = new Random();

    public static void main(String[] args) {
        // int[] a1 = null; // for NullPointerException
        // int[] a2 = null; // for NullPointerException
        try {
            // sumTwoArrays(a1, a2); // for NullPointerException

            int[] res = divideTwoArrays(genArray(19), genArray(19));
            System.out.printf("Resulting array %s\n", Arrays.toString(res));
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    // Реализуйте метод, принимающий в качестве аргументов два целочисленных
    // массива,
    // и возвращающий новый массив, каждый элемент которого равен частному элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны,
    // необходимо
    // как-то оповестить пользователя.
    // Важно: При выполнении метода единственное исключение, которое пользователь
    // может
    // увидеть - RuntimeException, т.е. ваше.

    /**
     * @param arr1 first array
     * @param arr2 second array
     * @return array of same size
     * @throws NullPointerException if one of arrays (or both) are null
     * @throws RuntimeException     if array sizes does not equal
     * @throws ArithmeticException  if division by 0
     */
    private static int[] divideTwoArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Array(s) should not be null");
        if (arr1.length == arr2.length) {
            System.out.printf("First  array %s\n", Arrays.toString(arr1));
            System.out.printf("Second array %s\n", Arrays.toString(arr2));
            int resarr[] = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                if (arr2[i] == 0) {
                    throw new ArithmeticException(String.format(
                        "Cannot divide by zero. Element at index %d is zero!", i));
                } else {
                    resarr[i] = arr1[i] / arr2[i];
                }
            }
            return resarr;
        } else {
            throw new RuntimeException(String.format(
                "Arrays have different sizes. %d and %d accordingly", arr1.length, arr2.length));
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