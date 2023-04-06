package org.laboratories.scuirty_lw3_var6;

public class TextEncryption {

    private final char[][] chars;

    private static final int SIZE = 100;

    private final int sideSize;

    private final String algorithm;

    public TextEncryption() {
        sideSize = (int) Math.sqrt(SIZE);
        chars = new char[sideSize][sideSize];
        algorithm = "brtrbrtrbrtrbrtrbbbltlbltlbltlbltlbbbrtrbrtrbrtrbrtrbbbltlbltlbltlbltlbbbrtrbrtrbrtrbrtrbrttttttttt";
    }

    public void initMatrix(String text) {
        for (int i = 0; i < sideSize; i++) {
            for (int j = 0; j < sideSize; j++) {
                chars[i][j] = text.charAt(i * 10 + j);
            }
        }
    }

    public String readArray(char[][] chars) {
        StringBuilder results = new StringBuilder();
        for (int i = 0; i < sideSize; i++) {
            for (int j = 0; j < sideSize; j++) {
                results.append(chars[i][j]);
            }
        }
        return results.toString();
    }

    public String encryption(){
        StringBuilder results = new StringBuilder();
        int x=0, y=0;
        results.append(chars[y][x]);
        for (int i = 0; i < algorithm.length(); i++) {
            if (algorithm.charAt(i) == 'b') y++;
            if (algorithm.charAt(i) == 't') y--;
            if (algorithm.charAt(i) == 'r') x++;
            if (algorithm.charAt(i) == 'l') x--;
            results.append(chars[y][x]);
        }
        return results.toString();
    }

    public String decryption(String encryptedText) {
        if (encryptedText.length() == SIZE) {
            StringBuilder results = new StringBuilder();
            int x = 0;
            int y = 0;
            char[][] tempChars = new char[sideSize][sideSize];
            tempChars[y][x] = encryptedText.charAt(0);
            for (int i = 0; i < algorithm.length(); i++) {
                if (algorithm.charAt(i) == 'b') y++;
                if (algorithm.charAt(i) == 't') y--;
                if (algorithm.charAt(i) == 'r') x++;
                if (algorithm.charAt(i) == 'l') x--;
                tempChars[y][x] = encryptedText.charAt(i + 1);
            }
            return results.append(readArray(tempChars)).toString();
        } else return null;
    }
}
