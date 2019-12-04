package com.hoschiland;

import java.util.List;
import java.util.stream.Stream;

public class Day01 {

    public static void main(String[] args) {

        Day01 day01 = new Day01();
        day01.runAdventofCodeDay01();
    }

    public void runAdventofCodeDay01() {
        System.out.println("Start Day01");

        List<String> inputList = InputString.getPuzzelInputAsString();

        Integer sum = 0;

        for (String str : inputList) {

            Integer i = Integer.valueOf(str);

            while (i > 5) {

                i = i / 3 - 2;

                sum = sum + i;

            }

        }


        // 3.330.521
        System.out.println(sum);

    }

}
