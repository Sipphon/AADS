package org.laboratories.lw1_var6_new;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[100][100];
        SparseTables sparseTables = new SparseTables();

        generateArray(arr);
        printArr(arr);
        sparseTables.addToArray(arr);
        System.out.println(sparseTables);
        System.out.println();
        System.out.println(sparseTables.findElement(9));
        System.out.println( find(arr,2));
    }

    public static void generateArray(int[][] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[i].length - i; j++) {
                arr[i][j] = random.nextInt(1, 100);
            }
        }
    }

    public static void printArr(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static long find(int[][] array, int index1, int index2) {
        long start = System.nanoTime();
        System.out.println(array[index1][index2]);
        long end=System.nanoTime();
        return end;
    }

    public static long find(int[][] array, int value) {
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == value) {
                }
            }
        }
        long end = System.nanoTime() - start;
        return end;
    }
}
