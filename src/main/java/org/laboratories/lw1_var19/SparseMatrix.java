package org.laboratories.lw1_var19;

import java.util.Random;

public class SparseMatrix {

    private int matrixSize;
    private int vectSize;
    private int[][] matrix;
    private int[] vect;

    public SparseMatrix(int n) {

        matrixSize = n;
        matrix = new int[matrixSize][matrixSize];

        vectSize = matrixSize * matrixSize / 2;
        vect = new int[vectSize];
    }

    public int newIndex(int i, int j) {

        return (i * matrixSize + j) / 2;
    }

    public void pack(int i, int j, int value) {

        if ((i + j) % 2 == 1) {

            vect[newIndex(i, j)] = value;
        }
    }

    public int unpack(int i, int j) {

        if ((i + j) % 2 == 1) {

            return vect[newIndex(i, j)];

        } else {

            return 0;
        }
    }

    public void fillMatrix() {

        Random rand = new Random();

        for (int i = 0; i < matrixSize; i++) {

            for (int j = 0; j < matrixSize; j++) {

                if ((i + j) % 2 == 1) {

                    int value = rand.nextInt(1, 100);
                    matrix[i][j] = value;
                    pack(i, j, value);

                } else {

                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void printMatrix() {

        for (int i = 0; i < matrixSize; i++) {

            for (int j = 0; j < matrixSize; j++) {

                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void printVect() {

        for (int i = 0; i < vectSize; i++) {

            System.out.print(vect[i] + "\t");
        }
        System.out.println();
    }

    public int[] getVect() {

        return this.vect;
    }

    public int[][] getMatrix() {

        return this.matrix;
    }
}