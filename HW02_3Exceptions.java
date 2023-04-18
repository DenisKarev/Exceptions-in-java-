
public class HW02_3Exceptions {
    // Задание 3. Дан следующий код, исправьте его там, где требуется
    //
    // и опятьне совсем понятно в какую сторону исправлять ))
    // то ли убрать исключения лишние (возникновение которых сомнительно ))
    // то ли предполагать худшее и добавить даже обработку деления на ноль
    // бо вдруг оно там а памяти обнулится и вылетит прога 
    // в общем загадочное задание )

    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
    
        // may be do not needed this exception handling ???   
        // } catch (NullPointerException ex) {
            // System.out.println("Указатель не может указывать на null!");
        } catch (ArrayIndexOutOfBoundsException ex) {    // changed from IndexOutOfBoundsException
            System.out.println("Массив выходит за пределы своего размера!");

        }
        //  catch (Exception ex) {
        // change Throwable to Exception to correspond method's main "throws Exception"
        // and moved to bottom because Exception is on top of hierarchy 
            // System.out.println("Что-то пошло не так...");
        // }
    }

    // method cannot trow FileNotFoundException ther is no IO operations so removed
    public static void printSum(Integer a, Integer b) { // removed throws FileNotFoundException
        System.out.println(a + b);
    }
}