package week2.snilsValidator;

public class SnilsValidatorImpl implements SnilsValidator {
    @Override
    public boolean validate(String snils) {

        if (snils.length() == 11 && snils.matches("[0-9]+")) {

            String snilsNumber = snils.substring(0, 9);
            int controlNumber = Integer.parseInt(snils.substring(9));
            int checkSum = 0;

            for (int index = 0, factor = 9; index < snilsNumber.length(); index++, factor--) {
                checkSum += Character.digit(snilsNumber.charAt(index), 10) * factor;
            }

            if (checkSum < 100 && checkSum == controlNumber) {
                return true;
            } else if (checkSum == 100 && controlNumber == 0) {
                return true;
            } else {
                int remains = checkSum % 101;
                return ((remains / 100 == 1) && (controlNumber == 0)) || (remains == controlNumber);
            }
        }
        return false;
    }
}
