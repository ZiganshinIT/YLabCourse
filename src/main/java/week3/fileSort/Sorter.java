package week3.fileSort;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Sorter {

    /**
     * Считает количество строк в файле
     *
     * @param file Файл, строки которого необходимо посчитать
     * @return long -  количество строк
     */
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


    /**
     * Сортирует элементы файла в порядке возрастания
     *
     * @param dataFile Файл, который необходимо отсортировать
     * @return Отсортированный файл
     */
    public File sortFile(File dataFile) {
        File file = new File(dataFile.toURI());
        String fileURL = dataFile.getAbsolutePath().replaceAll(dataFile.getName(), "");

        final long FILE_LINES_COUNT = fileLinesCount(file); // Количество строк в базовом классе
        final int CHANG_COUNT = 10; // Количество файлов, на которое будет разбиваться базовый файл
        final long COUNT_ELEMENT_IN_CHANG = FILE_LINES_COUNT / CHANG_COUNT; // Количество символов в одном вспомогательном файле

        // Чанг - спомогательный файл
        // Этап 1 - Разбиение на вспомогательные файлы.
        try (FileReader dataFileReader = new FileReader(dataFile);
             BufferedReader dataFileBufferedReader = new BufferedReader(dataFileReader)) {

            String filesRow; // Строка базового файла
            int rowsNumber = 0; // Номер строки
            int changNumber = 1; // Номер чанга

            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(fileURL + "file" + changNumber + ".txt");
                while ((filesRow = dataFileBufferedReader.readLine()) != null) {
                    rowsNumber++;
                    fileWriter.append(filesRow).append("\r\n");

                    if ((rowsNumber % COUNT_ELEMENT_IN_CHANG == 0 && rowsNumber <= FILE_LINES_COUNT)) {
                        fileWriter.close();
                        fileWriter = new FileWriter(fileURL + "file" + ++changNumber + ".txt");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();

            } finally {
                fileWriter.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Этап 2 - Сортировка элементов в вспомогательных файлах
        ArrayList<Long> listOfChangsElement = new ArrayList<>(); // Элменты чанга
        for (int i = 1; i <= CHANG_COUNT; i++) {
            try (FileReader fileReader = new FileReader(fileURL + "file" + i + ".txt");
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String fileRowReader;

                while ((fileRowReader = bufferedReader.readLine()) != null) {
                    long changElement = Long.parseLong(fileRowReader);
                    listOfChangsElement.add(changElement);
                }

                Collections.sort(listOfChangsElement); // отсортирован

                // Запись отсортированных значений в чанг
                try (FileWriter fileWriter = new FileWriter(fileURL + "file" + i + ".txt")) {
                    for (Long k : listOfChangsElement) {
                        fileWriter.write(k.toString());
                        fileWriter.append("\r\n");
                    }
                }
                listOfChangsElement.clear();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Этап 3 - Объединение в результирующий файл отсортированных значений

        // Этап 3.1 - Создать мап потоков чтения и их начальных значений
        Map<BufferedReader, Long> bufferedReaderAndHisCurrentValue = new HashMap<>();
        for (int i = 1; i <= CHANG_COUNT; i++) {
            try {
                FileReader fileReader = new FileReader(fileURL + "file" + i + ".txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String strLine = bufferedReader.readLine();
                if (strLine != null)
                    bufferedReaderAndHisCurrentValue.put(bufferedReader, Long.parseLong(strLine));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Этап 3.2 - Последовательное сравнение значений потоков чтения и запись в результирующий файл
        try (FileWriter fileWriter = new FileWriter(file)) {
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

                // Если поток чтения отработал до последней строки, закрываем.
                String bufferedReaderNextValue = currentBufferedReader.readLine();
                if (bufferedReaderNextValue != null) {
                    long parseToLong = Long.parseLong(bufferedReaderNextValue);
                    bufferedReaderAndHisCurrentValue.put(currentBufferedReader, parseToLong);
                } else {
                    currentBufferedReader.close();
                    bufferedReaderAndHisCurrentValue.remove(currentBufferedReader);
                }

                // Добавление в результирующий файл
                String valueToAdd = minNum.toString();
                fileWriter.append(valueToAdd).append("\r\n");
            }

//            for (BufferedReader bufferedReader : bufferedReaderAndHisCurrentValue.keySet()) {
//                bufferedReader.close();
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Этап 4 - Удаление вспомагательных файлов
        try {
            for (int i = 1; i <= CHANG_COUNT + 1; i++) {
                Files.deleteIfExists(Paths.get(fileURL + "file" + i + ".txt"));
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}



