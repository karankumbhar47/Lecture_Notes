package com.core_java.runner_classes.utils;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.time.Duration;
import java.time.LocalTime;

public class TimeDatePractice implements CodeRunnerInterface {

    @Override
    public void runCode() {
        LocalTime startTime = LocalTime.parse("04:37:07");
        LocalTime endTime = LocalTime.parse("04:21:05");
        LocalTime finishTime = LocalTime.parse("07:49:15");
        Duration duration = Duration.between(finishTime,startTime);
        System.out.println(duration);
    }
}
