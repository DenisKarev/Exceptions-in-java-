class UserData {
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private long phoneNumber;
    private char gender;

    public UserData(String lastName, String firstName, String middleName, String dateOfBirth, long phoneNumber,
            char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName.toString();
    }

    public String toString() {
        return lastName + " " + firstName + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender;
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder()
                .append("<").append(lastName).append(">")
                .append("<").append(firstName).append(">")
                .append("<").append(middleName).append(">")
                .append("<").append(dateOfBirth).append(">")
                .append("<").append(phoneNumber).append(">")
                .append("<").append(gender).append(">");
        return sb.toString();
    }
}