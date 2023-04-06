package org.laboratories.scuirty_lw3_var6;

public class MatrixEncryption {

    private char[][] matrix;

    private final int size = 100;

    private int sideSize;

    private String algorithm;

    public MatrixEncryption(){
        sideSize = (int)Math.sqrt(size);
        matrix = new char[sideSize][sideSize];
        algorithm = "brtrbrtrbrtrbrtrbbbltlbltlbltlbltlbbbrtrbrtrbrtrbrtrbbbltlbltlbltlbltlbbbrtrbrtrbrtrbrtrbrttttttttt";
    }
    public boolean initMatrix(String line){
        boolean correctWork = true;
        if(line.length() != size) correctWork = false;
        else{
            for(int i=0; i<sideSize; i++){
                for(int j=0; j<sideSize; j++){
                    matrix[i][j] = line.charAt(i*10+j);
                }
            }
        }
        return correctWork;
    }

    public String readMatrix(char[][] matrix){
        StringBuilder results = new StringBuilder();
        for (char[] chars : matrix) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                results.append(chars[j]);
            }
        }
        return results.toString();
    }
    public boolean checkAlgorithm() {
        return algorithm.length() == size-1;
    }

    public String encryption(){
        StringBuilder results = new StringBuilder();
        int x=0, y=0;
        results.append(matrix[y][x]);
        for(int i=0; i<algorithm.length(); i++){
            if(algorithm.charAt(i) == 'b') y++;
            if(algorithm.charAt(i) == 't') y--;
            if(algorithm.charAt(i) == 'r') x++;
            if(algorithm.charAt(i) == 'l') x--;
            results.append(matrix[y][x]);
        }
        return results.toString();
    }

    public String decryption(String enc){
        if(enc.length() == size) {
            StringBuilder resutls = new StringBuilder();
            int x = 0, y = 0;
            char[][] mmatrix = new char[sideSize][sideSize];
            mmatrix[y][x] = enc.charAt(0);
            for (int i = 0; i < algorithm.length(); i++) {
                if(algorithm.charAt(i) == 'b') y++;
                if(algorithm.charAt(i) == 't') y--;
                if(algorithm.charAt(i) == 'r') x++;
                if(algorithm.charAt(i) == 'l') x--;
                mmatrix[y][x] = enc.charAt(i+1);
            }
            return resutls.append(readMatrix(mmatrix)).toString();
        }
        else return null;
    }
}
