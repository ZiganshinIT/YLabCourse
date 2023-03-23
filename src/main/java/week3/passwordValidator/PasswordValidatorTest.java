package week3.passwordValidator;

public class PasswordValidatorTest {
    public static void main(String[] args) {
        boolean isValid = PasswordValidator.signIn("rinat", "123456", "123456");
        System.out.println(isValid);
    }
}
