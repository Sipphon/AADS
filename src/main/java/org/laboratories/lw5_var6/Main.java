package org.laboratories.lw5_var6;

import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable(3083);
        testInsertAndSearch(table, 0.2);
        testInsertAndSearch(table, 0.4);
        testInsertAndSearch(table, 0.6);
        testInsertAndSearch(table, 0.8);
        testInsertAndSearch(table, 1.0);
    }

    private static void testInsertAndSearch(HashTable table, double fillFactor) {
        int[] keys = generateKeys((int) (table.getSize() * fillFactor));
        String[] values = generateValues((int) (table.getSize() * fillFactor));
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < keys.length; i++) {
            table.insert(keys[i], values[i]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Insertion time for fill factor " + fillFactor + ": " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < keys.length; i++) {
            String value = table.find(keys[i]);
            if (value == null || !value.equals(values[i])) {
                System.out.println("Search failed for key " + keys[i] + " and fill factor " + fillFactor);
                break;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Search time for fill factor " + fillFactor + ": " + (endTime - startTime) + " ms");
        }
    }
    private static int[] generateKeys(int size) {
        Random random = new Random();
        int[] keys = new int[size];
        for (int i = 0; i < size; i++) {
            keys[i] = random.nextInt();
        }
        return keys;
    }

    private static String[] generateValues(int size) {
        String[] values = new String[size];
        for (int i = 0; i < size; i++) {
            values[i] = UUID.randomUUID().toString();
        }
        return values;
    }
    }

