class InvalidPhoneException extends InvalidQuantityException {
    public InvalidPhoneException() {
        super("Неверный формат. Вводите только цифры.");
    }
}