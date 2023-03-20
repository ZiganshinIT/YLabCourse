package week3.orgStructure;

import java.io.File;
import java.io.IOException;

public class OrgStructureParserTest {

    public static void abc(Employee e) { //boss
        System.out.println(e.getName() + " -> " + e.getSubordinate());
        for(Employee emp: e.getSubordinate()) {
            abc(emp);
        }
    }

    public static void main(String[] args) throws IOException {
        OrgStructureParserImpl orgStructureParser = new OrgStructureParserImpl();
        File f = new File("src/main/java/week3/orgStructure/OrgStructure.csv");
        Employee boss = orgStructureParser.parseStructure(f);
        abc(boss);
    }
}
