package week1;

import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = new Random().nextInt(100);
        int maxAttempts = 10;
        System.out.println("Я загадал число. У тебя " + maxAttempts + " попыток угадать.");
        for (int i = maxAttempts; i >= 0; i--) {
            int userNum = scanner.nextInt();
            if (i != 0) {
                if (number > userNum) {
                    System.out.println("Мое число больше! Осталось " + i + " попыток");
                } else if (number < userNum) {
                    System.out.println("Мое число меньше! Осталось " + i + " попыток");
                } else {
                    System.out.println("Ты угадал с " + (maxAttempts - i) + " попытки");
                    break;
                }
            } else {
                System.out.println("Ты не угадал");
            }
        }
    }
}
