package org.laboratories.scuirty_lw2_var6;

public class Data {
    String word;
    long inputTime;
    int numberOfChars;

    public Data(String word, long inputTime, int numberOfChars) {

        this.word=word;
        this.inputTime = inputTime;
        this.numberOfChars = numberOfChars;
    }
    public String getWord() {
        return word;
    }

    public double getInputTime() {
        return inputTime;
    }

    public void setInputTime(long inputTime) {
        this.inputTime = inputTime;
    }

    public int getNumberOfChars() {
        return numberOfChars;
    }

    public void setNumberOfChars(int numberOfChars) {
        this.numberOfChars = numberOfChars;
    }
    @Override
    public String toString() {
        return "Data{" + "inputTime=" + inputTime + ", numberOfChars=" + numberOfChars + '}';
    }
}
