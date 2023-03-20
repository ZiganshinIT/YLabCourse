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

                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                if (csvLine.isBlank()) {
                    continue;
                }

                String[] strArray = csvLine.split(";");

                Employee employee = new Employee();

                employee.setId(Long.parseLong(strArray[0]));
                employee.setBossId(strArray[1].equals("") ? null : Long.parseLong(strArray[1]));
                employee.setName(strArray[2]);
                employee.setPosition(strArray[3]);

                if (employee.getBossId() == null) {
                    generalBossObj = employee;
                }

                employees.add(employee);

                if (employee.getBossId() == null) {
                    continue;
                }

                long bossId = employee.getBossId();

                if (bossIDAndHisSubordinate.containsKey(bossId)) {
                    ArrayList<Employee> subordinates = bossIDAndHisSubordinate.get(bossId);
                    subordinates.add(employee);
                } else {
                    ArrayList<Employee> arrayList = new ArrayList<>();
                    arrayList.add(employee);
                    bossIDAndHisSubordinate.put(bossId, arrayList);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (employees.isEmpty()) {
            throw new RuntimeException("CSV не содердит элементов");
        }

        employees.sort((o1, o2) -> (int) (o1.getId() - o2.getId()));

        for (Employee e : employees) {
            if (bossIDAndHisSubordinate.get(e.getId()) != null) {
                e.getSubordinate().addAll(bossIDAndHisSubordinate.get(e.getId()));
            }

            if (e.getBossId() == null) {
                continue;
            }

            e.setBoss(employees.get(Math.toIntExact(e.getBossId())));
        }

        return generalBossObj;
    }
}

