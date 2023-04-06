package org.laboratories.scuirty_lw3_var6;

public class Main {
    private String text = "The quick brown fox jumps over the lazy dog. Crazy Frederick bought many very exquisite opal jewels.";
    public static void main(String[] args) {
        Main prog = new Main();
        prog.run();
    }
    private void run() {
        MatrixEncryption mE = new MatrixEncryption();
        if(!mE.initMatrix(text) || !mE.checkAlgorithm()) System.out.println("Error");
        else{
            String encripted = mE.encryption();
            System.out.println("Encrypted text:");
            System.out.println(encripted);
            System.out.println("Decrypted text:");
            System.out.println(mE.decryption(encripted));
            System.out.println("Begin text:");
            System.out.println(text);
        }
    }
}
