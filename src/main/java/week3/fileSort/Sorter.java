package week3.fileSort;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Sorter {
    public File sortFile(File dataFile) throws IOException {
        File file = new File(dataFile.toURI());

        // Подсчет количества строк в файле
        int fileLineCount = 0;
//        Scanner dataFileReader = null;
        try (Scanner dataFileReader = new Scanner(new FileReader(file))){

            while ( dataFileReader.hasNext() ){
                dataFileReader.next();
                fileLineCount++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }






        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String fileRow;
            int rowNumber = 1;
            int fileNumber = 1;
            FileWriter fileWriter = new FileWriter("src/main/java/week3/fileSort/file" + fileNumber + ".txt");
            while ((fileRow = bufferedReader.readLine()) != null) {

                rowNumber++;
                fileWriter.append(fileRow);
                fileWriter.append("\r\n");

                if ((rowNumber / 10) > (fileNumber - 1) && rowNumber < 100) {
                    fileWriter.close();
                    fileNumber++;
                    fileWriter = new FileWriter("src/main/java/week3/fileSort/file" + fileNumber + ".txt");
                }
            }

            fileReader.close();
            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            for (int i = 1; i <= 10; i++) {
                ArrayList<Long> list = new ArrayList<>();
                FileReader fileReader = new FileReader("src/main/java/week3/fileSort/file" + i + ".txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String fileRowRider;

                while ((fileRowRider = bufferedReader.readLine()) != null) {
                    list.add(Long.parseLong(fileRowRider));
                }

                Collections.sort(list); // отсортирован

                try (FileWriter fileWriter = new FileWriter("src/main/java/week3/fileSort/file" + i + ".txt")) {
                    for (Long k : list) {
                        fileWriter.write(k.toString());
                        fileWriter.append("\r\n");
                    }

                }
                fileReader.close();
            }

            try {
                Map<BufferedReader, Long> map = new HashMap<>();
                for (int i = 1; i <= 10; i++) {
                    try {
                        FileReader fileReader = new FileReader("src/main/java/week3/fileSort/file" + i + ".txt");
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String strLine = bufferedReader.readLine();
                        if (strLine != null)
                            map.put(bufferedReader, Long.parseLong(strLine));

                    } catch (IOException e) {} // ИСРАВИТЬ
                }

                try (FileWriter fileWriter = new FileWriter("src/main/java/week3/fileSort/data.txt")) {
                    for (int i = 0; i < 100; i++) {
                        BufferedReader br = null;
                        Long minNum = Long.MAX_VALUE;
                        for (BufferedReader bufferedReader : map.keySet()) {
                            if (map.get(bufferedReader) < minNum) {
                                minNum = map.get(bufferedReader);
                                br = bufferedReader;
                            }
                        }
                        String some = br.readLine();
                        if (some != null) {
                            map.put(br, Long.parseLong(some));
                        } else {
                            br.close();
                            map.remove(br);
                        }
                        fileWriter.append(minNum.toString());
                        fileWriter.append("\r\n");
                    }

                    for (BufferedReader br : map.keySet()) {
                        br.close();
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 1; i <= 10; i++) {
                Files.deleteIfExists(Paths.get("src/main/java/week3/fileSort/file" + i + ".txt"));
            }
        } catch (NoSuchFileException e) {
            System.out.println(
                    "No such file/directory exists");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Invalid permissions.");
        }

        return file;
    }
}



