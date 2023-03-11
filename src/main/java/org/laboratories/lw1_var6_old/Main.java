package org.laboratories.lw1_var6_old;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        SparseMatrix sm = new SparseMatrix(10);
        sm.fillMatrix();
        sm.printMatrix();

        System.out.println();
        sm.printVect();
        System.out.println("matrix[3][6]: " + sm.unpack(3, 6));

        int[] tempVector = sm.getVect();
        int[][] tempMatrix = sm.getMatrix();

        // Считывание

        long startTime = System.nanoTime();

        for (int i = 0; i < tempVector.length; i++) {

            int value = tempVector[i];
        }

        long endTime = System.nanoTime();

        System.out.println("Reading time of compressed table: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < tempMatrix.length; i++) {

            for (int j = 0; j < tempMatrix[i].length; j++) {

                int value = tempMatrix[i][j];
            }
        }

        endTime = System.nanoTime();
        System.out.println("Reading time of original table: " + (endTime - startTime) + " ns");

        System.out.println();
        // Запись

        startTime = System.nanoTime();
        for (int i = 0; i < tempMatrix.length; i++) {

            for (int j = 0; j < tempMatrix[i].length; j++) {

                tempMatrix[i][j] = rand.nextInt(100);
            }
        }

        endTime = System.nanoTime();
        System.out.println("Writing time of original table: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();

        for (int i = 0; i < tempVector.length; i++) {

            tempVector[i]=rand.nextInt(100);
        }

        endTime = System.nanoTime();

        System.out.println("Writing time of compressed table: " + (endTime - startTime) + " ns");

        System.exit(0);

    }
}
