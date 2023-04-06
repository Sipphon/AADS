package org.laboratories.lw5_var6;

public class HashTable {
    private int size;
    private HashTableEntry[] table;

    public int getSize() {
        return size;
    }

    public HashTable(int size) {
        this.size = size;
        this.table = new HashTableEntry[size];
    }

//    public void insert(int key, String value) {
//        int hash = (int) (size * (key * 0.618 % 1));
//        while (table[hash] != null && table[hash].getKey() != key) {
//            hash = (hash + 1) % size;
//        }
//        table[hash] = new HashTableEntry(key, value);
//    }
private static int linearProbing(int hash, int i, int size) {
    return (hash + i) % size;
}

    private static int hash(int key, int size) {
        double A = 0.618;
        return (int) (size * ((key * A) % 1));
    }

    public void insert(int key, String value) {
        int hash = hash(key, size);
        int i = 0;
        while (table[hash] != null) {
            i++;
            hash = linearProbing(hash, i, size);
        }
        table[hash] = new HashTableEntry(key, value);
    }

    public String find(int key) {
        int hash = hash(key, size);
        int i = 0;
        while (table[hash] != null && table[hash].getKey() != key) {
            i++;
            hash = linearProbing(hash, i, size);
        }
        if (table[hash] == null) {
            return null;
        } else {
            return table[hash].getValue();
        }
    }
//    public String find(int key) {
//        int hash = (int) (size * (key * 0.618 % 1));
//        while (table[hash] != null && table[hash].getKey() != key) {
//            hash = (hash + 1) % size;
//        }
//        if (table[hash] == null) {
//            return null;
//        } else {
//            return table[hash].getValue();
//        }
//    }

    private static class HashTableEntry {
        private int key;
        private String value;

        public HashTableEntry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }
}