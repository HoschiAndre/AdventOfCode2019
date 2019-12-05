package com.hoschiland;

import java.util.List;

public class Day03 {

    private String[][] circuit = new String[5000][5000];
    private static final Integer OFFSET_X = 100;
    private static final Integer OFFSET_Y = 100;
    private Integer posX = OFFSET_X;
    private Integer poxY = OFFSET_X;

    public static void main(String[] args) {

        Day03 day03 = new Day03();
        day03.runAdventofCodeDay03();
    }

    public void runAdventofCodeDay03() {
        System.out.println("Start Day03");

        this.circuit[OFFSET_X][OFFSET_Y] = "X"; // Central Starting Point

        List<String> wire1 = InputString.getPuzzelInputAsString();
        List<String> wire2 = InputString.getPuzzelInput2AsString();

        for (String str : wire1) {

            goOneDirection(str.substring(0,1), Integer.parseInt(str.substring(1)));

        }

        this.posX = OFFSET_X;
        this.poxY = OFFSET_Y;

        for (String str : wire2) {

            goOneDirection(str.substring(0,1), Integer.parseInt(str.substring(1)));

        }

        for (int i = 0; i < circuit.length; i++) {
            for (int j = 0; j < circuit[i].length; j++) {

                if (this.circuit[j][i] == null) {
                    this.circuit[j][i] = " ";
                }

               // System.out.print(this.circuit[j][i]);
            }
            //System.out.print("\n");
        }
        System.out.println("Result: " + this.getDistance());
    }

    private void goOneDirection(String direction, int position) {

        switch (direction) {
            case "U":
                goUp(position);
                break;
            case "D":
                goDown(position);
                break;
            case "R":
                goRight(position);
                break;
            case "L":
                goLeft(position);
                break;
        }

    }

    private void goUp(int position) {
        for (int i = 0; i < position; i++) {
            this.poxY++;

            if (this.circuit[this.posX][this.poxY] == "o") {
                this.circuit[this.posX][this.poxY] = "x";
            } else {
                this.circuit[this.posX][this.poxY] = "o";
            }
        }
    }
    private void goDown(int position) {
        for (int i = 0; i < position; i++) {
            this.poxY--;

            if (this.circuit[this.posX][this.poxY] == "o") {
                this.circuit[this.posX][this.poxY] = "x";
            } else {
                this.circuit[this.posX][this.poxY] = "o";
            }
        }
    }
    private void goLeft(int position) {
        for (int i = 0; i < position; i++) {
            this.posX--;

            if (this.circuit[this.posX][this.poxY] == "o") {
                this.circuit[this.posX][this.poxY] = "x";
            } else {
                this.circuit[this.posX][this.poxY] = "o";
            }
        }
    }
    private void goRight(int position) {
        for (int i = 0; i < position; i++) {
            this.posX++;

            if (this.circuit[this.posX][this.poxY] == "o") {
                this.circuit[this.posX][this.poxY] = "x";
            } else {
                this.circuit[this.posX][this.poxY] = "o";
            }
        }
    }

    private int getDistance() {

        int distanceX = 1000;
        int distanceY = 1000;
        int result = 0;

        for (int i = 0; i < circuit.length; i++) {
            for (int j = 0; j < circuit[i].length; j++) {

                String str = this.circuit[j][i];

                if (str.equals("x")) {

                    if ((j <= distanceX || i <= distanceY) && (result < (distanceX + distanceY))){
                        distanceX = j;
                        distanceY = i;
                        result = distanceX + distanceY;
                    }
                }
             }
        }
        return distanceX - OFFSET_X + distanceY - OFFSET_Y;
    }
}