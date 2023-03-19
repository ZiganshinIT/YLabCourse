package main.java.week2.statsAccumulator;

public class StatsAccumulatorImpl implements StatsAccumulator{

    private int minValue;
    private int maxValue;
    private int count = 0;
    private double sum = 0;
    private Double avg = 0.0;

    @Override
    public void add(int value) {
        if (count == 0) {
            minValue = value;
            maxValue = value;
        } else {
            minValue = Math.min(value, minValue);
            maxValue = Math.max(value, maxValue);
        }
        sum += value;
        count++;
        avg = sum / count;
    }

    @Override
    public int getMin() {
        return minValue;
    }

    @Override
    public int getMax() {
        return maxValue;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        return avg;
    }
}
