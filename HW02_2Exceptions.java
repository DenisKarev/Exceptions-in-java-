import java.lang.reflect.Array;

public class HW02_2Exceptions {
    // Задание 2. Если необходимо, исправьте данный код
    //
    // не совсем понятно в какую сторону исправлять ))
    // добавлять обработку возможных исключений или еще как ))
    // оставил в варианте обработки того что может случиться
    // из расчета что мы не знаем какой массив придет

    public static void main(String[] args) {
        // normal case ( / by zero ) ArithmeticException
        // int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        
        // case 2
        // ArrayIndexOutOfBoundsException
        // int[] intArray = new int[] { 1, 2, 3, 4, 5};
        
        // case 3 NullPointerException
        int[] intArray = null;

        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d; // here is warning in case 3 but java still compiles
            // double catchedRes1 = intArray[8] / (double) d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {   // если привести intArray[8] / (double) d
            // то это исключение как раз не нужно ))
            System.out.println("Catching exception: " + e);

        //case 2 array may be smaller than [8]
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);

        //case 3 array may be null
        } catch (NullPointerException e) {
            System.out.println("Catching exception: " + e);
        }
        // try_method(1);
    }

    protected static void try_method(Object a) {
        try {
            int d = 0;
            double catchedRes1 = Array.getInt(a, 8) / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
