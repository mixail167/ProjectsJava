package com.company;

class ArrayEntry {
    int columnNumber;
    int value;
    ArrayEntry nextEntry;

    ArrayEntry(int column) {
        columnNumber = column;
    }

    ArrayEntry(int columnNumber, int value, ArrayEntry nextEntry) {
        this.columnNumber = columnNumber;
        this.value = value;
        this.nextEntry = nextEntry;
    }
}
