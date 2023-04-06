package org.laboratories.scuirty_lw2_var6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class KeyboardAuthentication {
    private static final double ALLOWED_DEVIATION = 0.1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KeyboardAuthentication authenticator = new KeyboardAuthentication();

        // Get user characteristics for reference
        System.out.println("Please enter your characteristics for reference:");
        double referenceCharacteristics = authenticator.getCharacteristics(scanner);

        // Get user characteristics for authentication
        System.out.println("Please type the test text to authenticate:");
        double authenticationCharacteristics = authenticator.getCharacteristics(scanner);

        // Compare characteristics with allowed deviation
        boolean authenticated = true;

            double deviation = Math.abs(referenceCharacteristics - authenticationCharacteristics) / referenceCharacteristics;
            if (deviation > ALLOWED_DEVIATION) {
                authenticated = false;
            }


        // Print authentication result
        if (authenticated) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed.");
        }

        scanner.close();
    }

    public List<Data> getData(Scanner scanner) {
        List<Data> dataList = new ArrayList<>();
        while (true) {
            long startTime = System.currentTimeMillis(); // время начала ввода слова
            String word = scanner.next();
            long endTime = System.currentTimeMillis(); // время окончания ввода слова
            long time=endTime-startTime;
            if (word.equals("q")) break;
            dataList.add(new Data(word,time,word.length()));
        }
        return dataList;
    }

    public double getCharacteristics(Scanner scanner) {
        // Get user input for test text
        System.out.print("Enter test text: ");
        List<Data> testText = getData(scanner);

        // Get user input for typing the test text
        System.out.println("Type the following text:");
        System.out.println(testText);

        List<Data> typedText = getData(scanner);

        // Calculate typing characteristics
        int numErrors = getNumErrors(testText, typedText);
        List<Double> typingSpeed = getTypingSpeed(testText);

        // Return typing characteristics as array
        return numErrors;
    }

    private int getNumErrors(List<Data> testText, List<Data> typedText) {
        int numErrors = 0;
        Object[] forTest = testText.stream()
                .map(Data::getWord)
                .map(String::chars)
                .toArray();
        Object[] forTyped = typedText.stream()
                .map(Data::getWord)
                .map(String::chars)
                .toArray();
        for (int i = 0; i < forTest.length; i++) {
            if(!forTest[i].equals(forTyped[i])) numErrors++;
        }

        return numErrors;
    }

    private List<Double> getTypingSpeed(List<Data> dataList) {
     return dataList.stream()
             .map(data -> data.getInputTime()/data.getNumberOfChars())
             .toList();
    }
}


