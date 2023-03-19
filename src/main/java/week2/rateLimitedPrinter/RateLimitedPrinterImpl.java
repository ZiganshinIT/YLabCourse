package main.java.week2.rateLimitedPrinter;

import java.util.Date;

public class RateLimitedPrinterImpl implements RateLimitedPrinter{
    Date initialDate = new Date();
    int interval;
    long millisecond = initialDate.getTime();
    public RateLimitedPrinterImpl(int interval) {
        this.interval = interval;
    }

    @Override
    public void print(String message) {
        Date date = new Date();
        if (date.getTime() >= millisecond + interval) {
            System.out.println(message);
            millisecond = date.getTime();
        }
    }
}
