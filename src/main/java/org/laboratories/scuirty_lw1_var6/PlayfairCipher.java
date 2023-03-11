package org.laboratories.scuirty_lw1_var6;

public class PlayfairCipher {
    private final String alphabets = "абвгдеєжзиіїйклмнопрстуфхцчшщьюя’._";
    private final char placeholder = '\'';
    private final int N = 7;
    private final int K = 5;

    public String removeDuplicates(String keyword) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < keyword.length(); i++) {

            if (!result.toString().contains(keyword.charAt(i) + "")) {

                result.append(keyword.charAt(i));
            }
        }

        return result.toString();
    }

    public String insertPlaceholder(String word) {

        StringBuilder result = new StringBuilder(word);

        for (int i = 0; i < result.length() - 1; i += 2) {

            if (result.charAt(i) == result.charAt(i + 1)) {

                result.insert(i + 1, placeholder);
            }
        }

        if (result.length() % 2 != 0) {

            result.append(placeholder);
        }
        return result.toString();
    }

    public char[][] generateMatrix(String keyword) {

        char[][] matrix = new char[N][K];
        StringBuilder result = new StringBuilder(keyword);

        for (int i = 0; i < alphabets.length(); i++) {

            char c = alphabets.charAt(i);

            if (result.indexOf("" + c) == -1) {

                result.append(c);
            }

        }


        int index = 0;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = result.charAt(index++);
            }

        }


        return matrix;
    }

    public int[] getIndex(char[][] matrix, char a) {

        int[] index = new int[2];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == a) {

                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }

        return index;
    }

    public String encryptPassword(char[][] matrix, String word) {

        StringBuilder encryptedPassword = new StringBuilder();

        final int matrixRows = matrix.length;
        final int matrixCols = matrix[0].length;

        char a;
        char b;
        int[] aIndex;
        int[] bIndex;

        for (int i = 0; i < word.length() - 1; i += 2) {

            a = word.charAt(i);
            b = word.charAt(i + 1);

            aIndex = getIndex(matrix, a);
            bIndex = getIndex(matrix, b);

            // В одинаковой строке, смещение вправо
            if (aIndex[0] == bIndex[0]) {
                encryptedPassword.append(matrix[aIndex[0]][(aIndex[1] + 1) % matrixCols]);
                encryptedPassword.append(matrix[bIndex[0]][(bIndex[1] + 1) % matrixCols]);
            } else if (aIndex[1] == bIndex[1]) {

                encryptedPassword.append(matrix[(aIndex[0] + 1) % matrixRows][aIndex[1]]);
                encryptedPassword.append(matrix[(bIndex[0] + 1) % matrixRows][bIndex[1]]);
            } else {

                encryptedPassword.append(matrix[aIndex[0]][bIndex[1]]);
                encryptedPassword.append(matrix[bIndex[0]][aIndex[1]]);
            }
        }

        return encryptedPassword.toString();
    }

    public String decryptPassword(char[][] matrix, String encryptedPassword) {

        StringBuilder decryptedPassword = new StringBuilder();

        final int matrixRows = matrix.length;
        final int matrixCols = matrix[0].length;
        char a;
        char b;
        int[] aIndex;
        int[] bIndex;

        for (int i = 0; i < encryptedPassword.length() - 1; i += 2) {

            a = encryptedPassword.charAt(i);
            b = encryptedPassword.charAt(i + 1);

            aIndex = getIndex(matrix, a);
            bIndex = getIndex(matrix, b);

            if (aIndex[0] == bIndex[0]) {

                decryptedPassword.append(matrix[aIndex[0]][(aIndex[1] - 1 + matrixCols) % matrixCols]);
                decryptedPassword.append(matrix[bIndex[0]][(bIndex[1] - 1 + matrixCols) % matrixCols]);

            } else if (aIndex[1] == bIndex[1]) {

                decryptedPassword.append(matrix[(aIndex[0] - 1 + matrixRows) % matrixRows][aIndex[1]]);
                decryptedPassword.append(matrix[(bIndex[0] - 1 + matrixRows) % matrixRows][bIndex[1]]);

            } else {
                decryptedPassword.append(matrix[aIndex[0]][bIndex[1]]);
                decryptedPassword.append(matrix[bIndex[0]][aIndex[1]]);

            }
        }

        decryptedPassword = new StringBuilder(decryptedPassword.toString().replace(placeholder + "", ""));

        return decryptedPassword.toString();
    }
}


