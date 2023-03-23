package week3.passwordValidator;

import week3.passwordValidator.exceptions.*;

public class PasswordValidator {
    static public boolean signIn(String login, String password, String confirmPassword) {
        boolean isValid = true;
        try {
            if (!(login.matches("^[a-zA-Z0-9_]*$"))) {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            } else if (!(login.length() < 20)) {
                throw new WrongLoginException("Логин слишком длинный");
            } else if (!(password.matches("^[a-zA-Z0-9_]*$"))) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            } else if (!(password.length() < 20)) {
                throw new WrongPasswordException("Пароль слишком длинный");
            } else if(!(password.equals(confirmPassword))) {
                throw new WrongPasswordException("Пароль и подтверждение не совпадают");
            }

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return isValid;
    }
}
