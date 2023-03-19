package main.java.week1;;

import java.util.Scanner;

public class Pell {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            int num = scanner.nextInt();
            int lastElem = 1;
            int penultimateElem = 0;
            for (int i = 2; i <= num; i++) {
                int interimValue = lastElem;
                lastElem = 2 * lastElem + penultimateElem;
                penultimateElem = interimValue;
            }
            System.out.println(lastElem);
        }
    }
}
