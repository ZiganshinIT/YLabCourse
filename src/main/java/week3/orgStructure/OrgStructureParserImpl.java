package week3.orgStructure;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;


public class OrgStructureParserImpl implements OrgStructureParser {

    @Override
    public Employee parseStructure(File csvFile) {

        List<Employee> employees = new ArrayList<>();
        Map<Long, ArrayList<Employee>> bossIDAndHisSubordinate = new HashMap<>();
        Employee generalBossObj = null;
        boolean isFirstLine = true;

        try (Scanner scanner = new Scanner(Paths.get(csvFile.toURI()).toFile())) {
            scanner.useDelimiter("\n");

            while (scanner.hasNext()) {
                String csvLine = scanner.next();

                // пропуск первой строки
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // пропуск пустых строк
                if (csvLine.isBlank()) {
                    continue;
                }

                // строка файла разбитая на элементы массива
                String[] strArray = csvLine.split(";");

                // Создание работника
                Employee employee = new Employee();
                employee.setId(Long.parseLong(strArray[0]));
                employee.setBossId(strArray[1].equals("") ? null : Long.parseLong(strArray[1]));
                employee.setName(strArray[2]);
                employee.setPosition(strArray[3]);

                employees.add(employee);

                // определение ген. директора
                if (employee.getBossId() == null) {
                    generalBossObj = employee;
                    continue;
                }

                // создание ArrayList с подчиненными
                long bossId = employee.getBossId();
                if (bossIDAndHisSubordinate.containsKey(bossId)) {
                    ArrayList<Employee> subordinates = bossIDAndHisSubordinate.get(bossId);
                    subordinates.add(employee);
                } else {
                    ArrayList<Employee> subordinates = new ArrayList<>();
                    subordinates.add(employee);
                    bossIDAndHisSubordinate.put(bossId, subordinates);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (employees.isEmpty()) {
            throw new RuntimeException("CSV не содердит элементов");
        }

        employees.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));

        // задание всем работникам лист с подчиненными
        for (Employee e : employees) {
            long employeesID = e.getId();
            if (bossIDAndHisSubordinate.get(employeesID) != null) {
                e.getSubordinate().addAll(bossIDAndHisSubordinate.get(e.getId()));
            }

            if (e.getBossId() != null) {
                e.setBoss(employees.get(Math.toIntExact(e.getBossId())));
            }
        }
        return generalBossObj;
    }
}

