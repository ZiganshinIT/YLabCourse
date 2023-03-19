package main.java.week2.statsAccumulator;

public class StatsAccumulatorTest {
    public static void main(String[] args) {
        StatsAccumulatorImpl s = new StatsAccumulatorImpl();
        s.add(1);
        s.add(2);
        System.out.println(s.getAvg()); // 1.5 - среднее арифметическоеэлементов
        s.add(0);
        System.out.println(s.getMin()); // 0 - минимальное из переданныхзначений
        s.add(3);
        s.add(8);
        System.out.println(s.getMax()); // 8 - максимальный из переданных
        System.out.println(s.getCount()); // 5 - количество переданных элементов
    }
}
