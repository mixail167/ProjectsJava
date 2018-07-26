package com.company;

class ArrayEntry {
    int columnNumber;
    int value;
    ArrayEntry nextEntry;

    public ArrayEntry(int column) {
        columnNumber = column;
    }

    public ArrayEntry(int columnNumber, int value) {
        this.columnNumber = columnNumber;
        this.value = value;
    }
}
