package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLifeTest {

    private int m = 15;
    private int n = 10;

    //При использовании "планера" есть четыре формы, которые повторяются
    int[][] actualStart = new int[m][n];//стартовая форма
    int[][] actualFirst = new int[m][n];// форма после 1-й генерации
    int[][] actualSecond = new int[m][n];// форма после 2-й генерации
    int[][] actualThird = new int[m][n];// форма после 3-й генерации
    private int s = 1; //

    @BeforeEach
    public void setActualStart() {
        actualStart[1][1] = 1;
        actualStart[2][2] = 1;
        actualStart[3][0] = 1;
        actualStart[3][1] = 1;
        actualStart[3][2] = 1;
    }
    @BeforeEach
    public void setActualFirst() {
        actualFirst[2][2] = 1;
        actualFirst[3][1] = 1;
        actualFirst[3][2] = 1;
        actualFirst[4][1] = 1;
    }
    @BeforeEach
    public void setActualSecond() {
        actualSecond[2][2] = 1;
        actualSecond[3][0] = 1;
        actualSecond[3][2] = 1;
        actualSecond[4][1] = 1;
        actualSecond[4][2] = 1;
    }
    @BeforeEach
    public void setActualThird() {
        actualThird[2][1] = 1;
        actualThird[3][2] = 1;
        actualThird[3][3] = 1;
        actualThird[4][1] = 1;
        actualThird[4][2] = 1;
    }

    @Test
    public void shouldCountNeigboursAlive() {
        int i = 3;
        int j = 1;
        int exspected = 3;
        assertEquals(exspected, GameLife.countNeigboursAlive(actualStart, i, j));
    }

    @Test
    public void shouldFirstStateGeneration() {

        assertArrayEquals(actualFirst, GameLife.stateGeneration(actualStart));
    }

    @Test
    public void shouldSecondStateGeneration() {
        assertArrayEquals(actualSecond, GameLife.stateGeneration(actualFirst));
    }

    @Test
    public void shouldThirdStateGeneration() {
        assertArrayEquals(actualThird, GameLife.stateGeneration(actualSecond));
    }

    @Test
    public void shouldFourthStateGeneration() {
        int[][] actual = new int[m][n];
        for (int i = 0; i < actualThird.length; i++) {
            for (int j = 0; j < actualThird[0].length; j++) {
                if (actualThird[i][j] == 1)
                    actual[i + s][j + s] = 1;
                actual[i][j] = 0;
            }
        }
        int[][] expected = new int[m][n];
        for (int m = 0; m < actualStart.length; m++) {
            for (int n = 0; n < actualStart[0].length; n++) {
                if (actualStart[m][n] == 1) actual[m + s][n + s] = 1;
                actual[m][n] = 0;
            }
        }
        assertArrayEquals(expected, GameLife.stateGeneration(actual));
    }

    @Test
    public void shouldFifthStateGeneration() {
        int[][] actual = new int[m][n];
        for (int i = 0; i < actualStart.length; i++) {
            for (int j = 0; j < actualStart[0].length; j++) {
                if (actualStart[i][j] == 1)
                    actual[i + s][j + s] = 1;
                actual[i][j] = 0;
            }
        }
        int[][] expected = new int[m][n];
        for (int m = 0; m < actualFirst.length; m++) {
            for (int n = 0; n < actualFirst[0].length; n++) {
                if (actualFirst[m][n] == 1) actual[m + s][n + s] = 1;
                actual[m][n] = 0;
            }
        }
        assertArrayEquals(expected, GameLife.stateGeneration(actual));
    }

    @Test
    public void shouldSixthStateGeneration() {
        int[][] actual = new int[m][n];
        for (int i = 0; i < actualFirst.length; i++) {
            for (int j = 0; j < actualFirst[0].length; j++) {
                if (actualFirst[i][j] == 1) actual[i + s][j + s] = 1;
                actual[i][j] = 0;
            }
        }
        int[][] expected = new int[m][n];
        for (int m = 0; m < actualSecond.length; m++) {
            for (int n = 0; n < actualSecond[0].length; n++) {
                if (actualSecond[m][n] == 1) actual[m + s][n + s] = 1;
                actual[m][n] = 0;
            }
        }
        assertArrayEquals(expected, GameLife.stateGeneration(actual));
    }
    @Test
    public void shouldSeventhStateGeneration() {
        int[][] actual = new int[m][n];
        for (int i = 0; i < actualSecond.length; i++) {
            for (int j = 0; j < actualSecond[0].length; j++) {
                if (actualSecond[i][j] == 1) actual[i + s][j + s] = 1;
                actual[i][j] = 0;
            }
        }
        int[][] expected = new int[m][n];
        for (int m = 0; m < actualThird.length; m++) {
            for (int n = 0; n < actualThird[0].length; n++) {
                if (actualThird[m][n] == 1) actual[m + s][n + s] = 1;
                actual[m][n] = 0;
            }
        }
        assertArrayEquals(expected, GameLife.stateGeneration(actual));
    }

}
