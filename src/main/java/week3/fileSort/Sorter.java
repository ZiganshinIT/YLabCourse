package week3.fileSort;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Sorter {

    public static long fileLinesCount(File file) {
        long fileLinesCount = 0;

        try (FileReader fileReader = new FileReader(file); Scanner dataFileReader = new Scanner(fileReader)) {
            while (dataFileReader.hasNextLine()) {
                dataFileReader.nextLine();
                fileLinesCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileLinesCount;
    }


    public File sortFile(File dataFile) throws IOException {

        File file = new File(dataFile.toURI());

        final long FILE_LINES_COUNT = fileLinesCount(file);
        final int SUPPORT_FILE_COUNT = 10;
        final long COUNT_ELEMENT_IN_CHANG = FILE_LINES_COUNT / SUPPORT_FILE_COUNT;

        try (FileReader dataFileReader = new FileReader(dataFile);
             BufferedReader dataFileBufferedReader = new BufferedReader(dataFileReader)) {

            String filesRow;
            int rowsNumber = 1;
            int changNumber = 1;

            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("src/main/java/week3/fileSort/file" + changNumber + ".txt");
                while ((filesRow = dataFileBufferedReader.readLine()) != null) {
                    rowsNumber++;
                    fileWriter.append(filesRow).append("\r\n");

                    if ((rowsNumber % COUNT_ELEMENT_IN_CHANG == 0 && rowsNumber < FILE_LINES_COUNT)) {
                        fileWriter.close();
                        fileWriter = new FileWriter("src/main/java/week3/fileSort/file" + ++changNumber + ".txt");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                fileWriter.close();
            }
        }

        ArrayList<Long> listOfChangsElement = new ArrayList<>();

        for (int i = 1; i <= SUPPORT_FILE_COUNT; i++) {
            try (FileReader fileReader = new FileReader("src/main/java/week3/fileSort/file" + i + ".txt");
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String fileRowReader;

                while ((fileRowReader = bufferedReader.readLine()) != null) {
                    long changElement = Long.parseLong(fileRowReader);
                    listOfChangsElement.add(changElement);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        Collections.sort(listOfChangsElement); // отсортирован

        for (int i = 1; i <= SUPPORT_FILE_COUNT; i++) {
            try (FileWriter fileWriter = new FileWriter("src/main/java/week3/fileSort/file" + i + ".txt")) {
                for (Long k : listOfChangsElement) {
                    fileWriter.write(k.toString());
                    fileWriter.append("\r\n");
                }
            }
        }

        {
            Map<BufferedReader, Long> bufferedReaderAndHisCurrentValue = new HashMap<>();
            for (int i = 1; i <= SUPPORT_FILE_COUNT; i++) {
                try {
                    FileReader fileReader = new FileReader("src/main/java/week3/fileSort/file" + i + ".txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String bufferedReaderCurrentValue = bufferedReader.readLine();
                    if (bufferedReaderCurrentValue != null) {
                        long parseToLong = Long.parseLong(bufferedReaderCurrentValue);
                        bufferedReaderAndHisCurrentValue.put(bufferedReader, parseToLong);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try (FileWriter fileWriter = new FileWriter("src/main/java/week3/fileSort/data.txt")) {
                for (int i = 0; i < FILE_LINES_COUNT; i++) {
                    BufferedReader currentBufferedReader = null;
                    Long minNum = Long.MAX_VALUE;
                    for (BufferedReader bufferedReader : bufferedReaderAndHisCurrentValue.keySet()) {
                        long bufferedReaderCurrentValue = bufferedReaderAndHisCurrentValue.get(bufferedReader);
                        if (bufferedReaderCurrentValue < minNum) {
                            minNum = bufferedReaderCurrentValue;
                            currentBufferedReader = bufferedReader;
                        }
                    }

                    String bufferedReaderNextValue = currentBufferedReader.readLine();
                    if (bufferedReaderNextValue != null) {
                        long parseToLong = Long.parseLong(bufferedReaderNextValue);
                        bufferedReaderAndHisCurrentValue.put(currentBufferedReader, parseToLong);
                    } else {
                        currentBufferedReader.close();
                        bufferedReaderAndHisCurrentValue.remove(currentBufferedReader);
                    }

                    String valueToAdd = minNum.toString();
                    fileWriter.append(valueToAdd).append("\r\n");;
                }

                for (BufferedReader bufferedReader : bufferedReaderAndHisCurrentValue.keySet()) {
                    bufferedReader.close();
                }
            }
        }

        try {
            for (int i = 1; i <= SUPPORT_FILE_COUNT; i++) {
                Files.deleteIfExists(Paths.get("src/main/java/week3/fileSort/file" + i + ".txt"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}



