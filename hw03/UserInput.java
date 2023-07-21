import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class UserInput {

    Scanner scanner = new Scanner(System.in);

    private UserData tempData;

    private UserData validateInput(String[] input)
            throws InvalidQuantityException, InvalidDateFormatException, InvalidPhoneException {
        if (input.length != 6) {
            if (input.length > 6) {
                throw new InvalidQuantityException("Многовато данных, аж " + input.length + "\n");
            } else {
                throw new InvalidQuantityException("Слишком мало данных " + input.length + "\n");
            }
        }

            String lastName = input[0];
            String firstName = input[1];
            String middleName = input[2];
            String dateOfBirth = input[3];
            long phone = Long.parseLong(input[4]);
            char gender = input[5].charAt(0);

        if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) { // Проверка на правильный формат даты
            throw new InvalidDateFormatException("Неверный формат. Введите dd.mm.yyyy не " + dateOfBirth);
        }

        if (!String.valueOf(phone).matches("\\d+")) { // Проверка только на цифры
            throw new InvalidPhoneException();
        }
        if (gender != 'm' && gender != 'f') {
            throw new InvalidQuantityException("Неверное значение пола. Ожидается m или f.");
        }
        return new UserData(lastName, firstName, middleName, dateOfBirth, phone, gender);
    }

    public void getData() {
        System.out.printf("%s%n%s%n%s%n",
                "Введите данные: Ф И О дата(рождения) номер(телефона) пол",
                "Всё через пробел, форматы данных:",
                "Ф И О: буквы \t формат даты: dd.mm.yyyy \tтелефон: цифры \t пол: m или f");

        String[] data = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");

        try {
            validateInput(data);

            // String lastName = data[0];
            // String firstName = data[1];
            // String middleName = data[2];
            // String dateOfBirth = data[3];
            // long phone = Long.parseLong(data[4]);
            // char gender = data[5].charAt(0);

            tempData = validateInput(data);
            // new UserData(lastName, firstName, middleName, dateOfBirth, phone, gender);
        } catch (InvalidQuantityException e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
            getData();
        }
    }

    public void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempData.getLastName(), true))) {
            bw.write(tempData.toFile() + "\n");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}