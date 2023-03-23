package week3.orgStructure;

import java.io.File;
import java.io.IOException;

public interface OrgStructureParser {
    /**
     * Формирует структуру организации из CSV файла
     * @param csvFile CSV файд
     * @return Объект гененрального директора
     */
    Employee parseStructure(File csvFile) throws IOException;
}
