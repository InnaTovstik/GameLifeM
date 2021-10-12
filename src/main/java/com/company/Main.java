package com.company;

public class Main {

    private static int state = 0;

    public static void main(String[] args) {
        int m = 15;
        int n = 10;
        int[][] tab = new int[m][n];
        //Планёр
        tab[1][1] = 1;
        tab[2][2] = 1;
        tab[3][0] = 1;
        tab[3][1] = 1;
        tab[3][2] = 1;
        do {
            printTab(tab);
            state++;
            tab = GameLife.stateGeneration(tab);
        }
        while (state < 20);
    }

    public static void printTab(int[][] tab) {
        System.out.println(" Состояние " + state);
        for (int[] cell : tab) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.printf("%1d ", cell[j]);
            }
            System.out.println();
        }
    }
}