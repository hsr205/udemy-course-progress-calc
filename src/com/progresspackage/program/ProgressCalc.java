package com.progresspackage;

import java.text.DecimalFormat;
import java.util.*;

public class ProgressCalc {

    public ProgressCalc() {
    }

    public void percentageOfVideosToComplete() {

        DecimalFormat decimalFormat = new DecimalFormat("##.##%");
        DecimalFormat numberFormat = new DecimalFormat("##.##");
        Scanner scanner = new Scanner(System.in);


        double totalVideos = 453.0;
        double videosCompleted = 0.0;
        System.out.print("Please Enter a Percentage Step: ");
        double percentageCompleted = 0.0;
        int percentageStartStep =  scanner.nextInt();
        System.out.print("Please Enter Number of Videos Completed: ");
        int currentVideosCompleted = scanner.nextInt();
        double currentPercentage = currentVideosCompleted / totalVideos;
        System.out.print("Please Enter a Percentage Goal: ");
        int percentageGoal = scanner.nextInt();
        Map<String, Double> percentageMap = new LinkedHashMap<>();

        System.out.println("Completion Progress:");
        System.out.println("====================");

        for (int i = 0; i < totalVideos; i++) {
            videosCompleted = (percentageCompleted * totalVideos) / 100;
            System.out.println(percentageCompleted + "% = " + videosCompleted + " videos");
            percentageMap.put(String.valueOf(percentageCompleted).replace(".0",""), videosCompleted);
            percentageCompleted += percentageStartStep;
            if (percentageCompleted > 100.00) {
                break;
            }
        }

        System.out.println("=========================================");
        System.out.println("Current Percentage = " + decimalFormat.format(currentPercentage));


        if (Double.parseDouble(numberFormat.format((percentageMap.get(String.valueOf(percentageGoal)) - currentVideosCompleted))) > 0) {
            System.out.println("Videos to Complete to Reach " + percentageGoal + "% = " + numberFormat.format((percentageMap.get(String.valueOf(percentageGoal)) - currentVideosCompleted)) + " videos");
        }
        else {
            System.out.println("Videos to Complete to Reach " + percentageGoal + "% = Goal Reached " + numberFormat.format((currentVideosCompleted - percentageMap.get(String.valueOf(percentageGoal)))) + " videos ago");
        }

    }
}
