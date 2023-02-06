package org.laboratories.lw1_var6_old;

import java.util.Random;

public class SparseMatrix {

    private int matrixSize;
    private int vectSize;
    private int[][] matrix;
    private int[] vect;

    public SparseMatrix(int n) {

        matrixSize = n;
        matrix = new int[matrixSize][matrixSize];
        if (matrixSize % 2 == 0) vectSize = (1+(1+(matrixSize/2-1)))*matrixSize/2;
        else vectSize = (((1+(1+((matrixSize-1)/2-1)))*(matrixSize-1)/2)/2)+(((1+(1+((matrixSize+1)/2-1)))*(matrixSize+1)/2)/2);
        vect = new int[vectSize];
    }

    public int newIndex(int i, int j) {
        int l;
            l = matrixSize * i - i * i + j;
            return l;
    }

    public int pack(int i, int j, int value) {
        vect[newIndex(i, j)] = value;
        return value;
    }

    public int unpack(int i, int j) {
        if(i<=j){
        return vect[newIndex(i, j)];}
        else return 0;
    }

    public void fillMatrix() {
        int k = 1;
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length - i; j++) {
                matrix[i][j] = k++;
                pack(i, j, matrix[i][j]);
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
