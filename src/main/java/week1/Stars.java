package week1;

import java.util.Scanner;

public class Stars {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int columnsCount = scanner.nextInt();
            int rowsCount = scanner.nextInt();
            char template = scanner.next().charAt(0);

            for(int columns = 0; columns < columnsCount; columns++) {
                for(int rows = 0; rows < rowsCount; rows++) {
                    System.out.print(template + " ");
                }
                System.out.println();
            }
        }
    }
}
