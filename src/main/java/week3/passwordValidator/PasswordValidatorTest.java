package week3.passwordValidator;

public class PasswordValidatorTest {
    public static void main(String[] args) {
        boolean isValid = PasswordValidator.signIn("rinat", "1234560000000", "123456");
        System.out.println(isValid);
    }
}
