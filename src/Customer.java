public record Customer(String lastName, String firstName, String phone, double balance) implements Comparable<Customer> {

    public Customer {
        checkNullOrEmpty(lastName, "lastName");
        checkNullOrEmpty(firstName, "firstName");
        checkNullOrEmpty(phone, "phone");
    }

    @Override
    public int compareTo(Customer other) {
        int minLength = Math.min(lastName().length(), other.lastName().length());
        char[] thisWordChars = new char[lastName().length()];
        char[] otherWordChars = new char[other.lastName().length()];

        for (int index = 0; index < lastName().length(); index++) {
            thisWordChars[index] = lastName().charAt(index);
        }
        for (int index = 0; index < other.lastName().length(); index++) {
            otherWordChars[index] = other.lastName.charAt(index);
        }

        int charIndex = 0;
        while (charIndex < minLength) {
            char thisChar = thisWordChars[charIndex];
            char otherChar = otherWordChars[charIndex];
            if (thisChar != otherChar) {
                return thisChar - otherChar;
            }
            charIndex++;
        }
        return this.lastName().length() - other.lastName().length();
    }

    public String toString() {
        return lastName + ", " + firstName + ", " + phone + ", " + balance;
    }

    private void checkNullOrEmpty(String target, String varName) {
        if (target == null || target.isEmpty()) {
            throw new IllegalArgumentException(varName + "must not be null or empty.");
        }
    }
}
