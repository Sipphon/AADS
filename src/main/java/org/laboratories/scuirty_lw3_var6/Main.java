package org.laboratories.scuirty_lw3_var6;

public class Main {
    private static final String TEXT = "Сьогодні хмарно, але не дощить. Листя на деревах починає з'являтися, і вже можна відчути запах весни";
    public static void main(String[] args) {
        Main programme = new Main();
        programme.run();
    }
    private void run() {
        TextEncryption textEncryption = new TextEncryption();
        textEncryption.initMatrix(TEXT);

        System.out.println("Початковий текст:");
        System.out.println(TEXT);

        String encrypted = textEncryption.encryption();
        System.out.println("Зашифрований текст:");
        System.out.println(encrypted);
        System.out.println("Розшифрований текст:");
        System.out.println(textEncryption.decryption(encrypted));

    }
    }

