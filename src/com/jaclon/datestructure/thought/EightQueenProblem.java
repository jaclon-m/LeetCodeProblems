/**
 * Juzifenqi.com Inc.
 * Copyright (c) 2019-2029 All Rights Reserved.
 */
package com.jaclon.datestructure.thought;

/**
 * @author jaclon
 * @Classname EightQueenProblem
 * @Description TODO
 * @date 2020/2/29
 */
public class EightQueenProblem {

    static int[] result = new int[8];

    static int num = 0;

    public static void main(String[] args) {
        cal8Queen(0);
    }

    public static void cal8Queen(int row) {

        if (row >= 8) {
            printQueen();
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queen(row+1);
            }
        }
    }

    private static void printQueen() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (result[i] == j) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(++num);
    }

    private static boolean isOk(int row, int column) {

        int leftCol = column - 1;
        int rigthCol = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }

            if (leftCol >= 0) {
                if (result[i] == leftCol) return false;
            }
            if (rigthCol < 8) {
                if (result[i] == rigthCol) return false;
            }
            leftCol--;
            rigthCol++;
        }
        return true;
    }
}
