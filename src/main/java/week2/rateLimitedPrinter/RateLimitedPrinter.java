package main.java.week2.rateLimitedPrinter;

public interface RateLimitedPrinter {
    void print(String message) throws InterruptedException;
}
