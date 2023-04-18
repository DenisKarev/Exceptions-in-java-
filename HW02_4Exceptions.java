import java.util.Scanner;

public class HW02_4Exceptions {
    // Разработайте программу, которая выбросит Exception, когда пользователь вводит
    // пустую строку. Пользователю должно показаться сообщение, что пустые строки
    // вводить нельзя.

    public static void main(String[] args) {
        // float f = -65535;
        String inp = "";
        try {
            inp = askUserEnterSomething("Enter something/anything(nothing?)) :");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        if (inp.equals("")) {
            System.out.println("Nothing was entered for some reasons. Really strange )");
        } else {
            System.out.printf("You have entered %s\n", inp);
        }
    }

    protected static Scanner sc = new Scanner(System.in);

    private static String askUserEnterSomething(String message) throws IllegalStateException {
        System.out.println(message);
        boolean inputing = true;
        // float a = -1;
        String s = "";

        while (inputing) {
            // if (sc.hasNext()) {
            try {
                // sc.close(); // emulating if Scanner is closed for some reason )))
                s = sc.nextLine();
                if (s.equals("")) {
                    throw new NullPointerException();
                }
                // a = Float.parseFloat(s);
                inputing = false;
            } catch (NumberFormatException e) {
                System.out.println("Enter the FLOAT number not text !");

            } catch (NullPointerException e) {
                System.out.println("Empty input? No you cannot enter nothing %)))");

            } catch (IllegalStateException e) { // if Scanner is closed for some reason )))
                // return -1;
                throw new IllegalStateException("Something happened, can't open input source !");
            }
            // }
        }
        return s;
    }

}
