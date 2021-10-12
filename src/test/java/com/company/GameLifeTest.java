package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLifeTest {

    @Test
    public void shouldCountNeigboursAlive() {
        int[][] actual = new int[10][3];
        actual[1][1] = 1;
        actual[2][2] = 1;
        actual[3][0] = 1;
        actual[3][1] = 1;
        actual[3][2] = 1;
        int i = 3;
        int j = 1;
        int exspected = 3;
        assertEquals(exspected, GameLife.countNeigboursAlive(actual, i, j));
    }
    @Test
    public void shouldFirstStateGeneration() {
        int[][] actual = new int[15][10];
        actual[1][1] = 1;
        actual[2][2] = 1;
        actual[3][0] = 1;
        actual[3][1] = 1;
        actual[3][2] = 1;
        int[][] exspected1 = new int[15][10];
        exspected1 [2][0]=1;
        exspected1 [2][2]=1;
        exspected1 [3][1]=1;
        exspected1 [3][2]=1;
        exspected1 [4][1]=1;
        assertArrayEquals(exspected1, GameLife.stateGeneration(actual));
    }
    @Test
    public void shouldSecondStateGeneration() {
        int[][] actual = new int[15][10];
        actual [2][0]=1;
        actual [2][2]=1;
        actual [3][1]=1;
        actual [3][2]=1;
        actual [4][1]=1;
        int[][] exspected2 = new int[15][10];
        exspected2 [2][2]=1;
        exspected2 [3][0]=1;
        exspected2 [3][2]=1;
        exspected2 [4][1]=1;
        exspected2 [4][2]=1;
        assertArrayEquals(exspected2, GameLife.stateGeneration(actual));
    }

}
