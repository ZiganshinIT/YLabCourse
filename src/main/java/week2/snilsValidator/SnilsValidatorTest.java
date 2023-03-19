package main.java.week2.snilsValidator;

public class SnilsValidatorTest {
    public static void main(String[] args) {
        System.out.println(new SnilsValidatorImpl().validate("01468870570"));
        System.out.println(new SnilsValidatorImpl().validate("90114404441"));
        System.out.println(new SnilsValidatorImpl().validate("16675209900"));
        System.out.println(new SnilsValidatorImpl().validate("21322222222"));
    }
}
