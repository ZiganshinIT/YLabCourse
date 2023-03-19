package week3.datedMap;

public class DatedMapTest {
    public static void main(String[] args) throws InterruptedException {
        DatedMapImpl datedMap = new DatedMapImpl();
        datedMap.put("A", "a");
        datedMap.put("B", "b");
        datedMap.put("C", "c");

        System.out.println(datedMap.get("B"));
        System.out.println(datedMap.get("F"));

        System.out.println(datedMap.containsKey("C"));
        System.out.println(datedMap.containsKey("Y"));

        System.out.println(datedMap.keySet());

        System.out.println(datedMap.getKeyLastInsertionDate("A"));

        datedMap.remove("A");
        datedMap.remove("D");

        System.out.println(datedMap.getKeyLastInsertionDate("A"));


    }
}
