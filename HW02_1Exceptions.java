import java.util.Scanner;

public class HW02_1Exceptions {
    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа
    // (типа float), и возвращает введенное значение. Ввод текста вместо числа не
    // должно приводить к падению приложения, вместо этого, необходимо повторно
    // запросить у пользователя ввод данных.

    public static void main(String[] args) {
        float f = -65535;
        try {
            f = askUserAFloatNumber("Enter a float number please:");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        if (f == -65535 || f == -1) {
            System.out.println("no number was entered for some reasons");
        } else {
            System.out.printf("Entered number was %.8f\n",f);
        }
    }

    protected static Scanner sc = new Scanner(System.in);

    private static float askUserAFloatNumber(String message) throws IllegalStateException {
        System.out.println(message);
        boolean inputing = true;
        float a = -1;

        while (inputing) {
            // if (sc.hasNext()) {
            try {
                // sc.close();                  // if Scanner is closed for some reason )))
                String s = sc.nextLine();
                if (s.equals("")) {
                    throw new NullPointerException();
                }
                a = Float.parseFloat(s);
                inputing = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter the FLOAT number not text !");

            } catch (NullPointerException e) {
                System.out.println("Empty input? are you finished? Let's try again! ");

            } catch (IllegalStateException e) { // if Scanner is closed for some reason )))
                // return -1;
                throw new IllegalStateException("Something happened, can't open input source !");
            }
            // }
        }
        return a;
    }

}
