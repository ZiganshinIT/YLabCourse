package week3.fileSort;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        File dataFile = new Generator().generate("src/main/java/week3/fileSort/data.txt", 375_000_000);
        System.out.println(new Validator(dataFile).isSorted()); // false
        File sortedFile = new Sorter().sortFile(dataFile);
        System.out.println(new Validator(sortedFile).isSorted()); // true
    }
}
