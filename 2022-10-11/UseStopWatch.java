package com.codegym;

import java.time.format.DateTimeFormatter;

public class UseStopWatch {
    public static void main(String[] args) {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(watch.getStartTime());
        watch.stop();
        System.out.println(watch.getElapsedTime());

    }
}
