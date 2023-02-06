package org.laboratories.lw1_var6_new;

import java.util.ArrayList;
import java.util.List;

public class SparseTables {
    private List<Element> arr = new ArrayList<>();


    public List<Element> addToArray(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array[i].length - i; j++) {
                arr.add(new Element(i, j, array[i][j]));
            }
        }
        return arr;
    }


    public long findElement(int index1, int index2) {
        long start = System.nanoTime();
        arr.stream()
                .filter((Element el) -> el.getIndex1() == index1 && el.getIndex2() == index2);
        long end = System.nanoTime() - start;
        return end;
    }

    public long findElement(int value) {
        long start = System.nanoTime();
        arr.stream()
                .filter((Element el) -> el.getValue() == value);
        long end = System.nanoTime() - start;
        return end;
    }

    @Override
    public String toString() {
        return "SparseTables{" +
                "arr=" + arr +
                '}';
    }
}
