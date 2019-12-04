package com.hoschiland;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Day02 {

    public static void main(String[] args) {

        Day02 day01 = new Day02();
        day01.runAdventofCodeDay02();
    }

    public void runAdventofCodeDay02() {
        System.out.println("Start Day02");


        Integer output = 0;

        // while (output == 19690720)

        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {

                List<Integer> inputList = InputString.getPuzzelInputAsInteger();

                inputList.set(1, noun);
                inputList.set(2, verb);

                output = getOutput(inputList);

                if (output == 19690720) {

                    System.out.println("noun: " + noun + " - verb: " + verb);
                    Integer total = 100 * noun + verb;
                    System.out.println(("Total: " + total));

                }
            }
        }
    }


    private Integer getOutput(List<Integer> inputList) {
        Integer result = 0;

        for (int i = 0; i < inputList.size(); i++) {

            Integer x = Integer.valueOf(inputList.get(i));

            if (x == 1) {
                Integer a = inputList.get(i + 1);
                Integer b = inputList.get(i + 2);

                Integer c = inputList.get(a) + inputList.get(b);

                inputList.set(inputList.get(i + 3), c);

                i = i + 3;
            }

            if (x == 2) {
                Integer a = inputList.get(i + 1);
                Integer b = inputList.get(i + 2);

                Integer c = inputList.get(a) * inputList.get(b);

                inputList.set(inputList.get(i + 3), c);

                i = i + 3;
            }

            if (x == 99) {

                result = inputList.get(0);
                break;


            }
        }
        return result;
    }

}