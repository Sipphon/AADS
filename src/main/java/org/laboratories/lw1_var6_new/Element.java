package org.laboratories.lw1_var6_new;

import java.util.Objects;

public class Element {
    private int index1;
    private int index2;
    private int value;

    public Element(int index1, int index2, int value) {
        this.index1 = index1;
        this.index2 = index2;
        this.value = value;
    }

    public int getIndex1() {
        return index1;
    }

    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    public int getIndex2() {
        return index2;
    }

    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return "SparseTable{" +
                "index1=" + index1 +
                ", index2=" + index2 +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return index1 == element.index1 && index2 == element.index2 && value == element.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index1, index2, value);
    }
}
