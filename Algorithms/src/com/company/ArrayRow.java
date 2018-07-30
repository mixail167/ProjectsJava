package com.company;

class ArrayRow {
    private int rowNumber;
    private ArrayRow nextRow;
    private ArrayEntry rowSentinel;

    private ArrayRow FindRowBefore(int row) {
        ArrayRow arrayRow = this;
        while (arrayRow.nextRow != null && arrayRow.nextRow.rowNumber < row) {
            arrayRow = arrayRow.nextRow;
        }
        return arrayRow;
    }

    ArrayRow() {
        this.rowNumber = -1;
    }

    private ArrayRow(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    void SetValue(int row, int column, int value) {
        if (value == Integer.MAX_VALUE) {
            DeleteEntry(row, column);
            return;
        }
        ArrayRow arrayRow = FindRowBefore(row);
        if (arrayRow.nextRow == null || arrayRow.nextRow.rowNumber > row) {
            ArrayRow new_row = new ArrayRow(row);
            new_row.nextRow = arrayRow.nextRow;
            arrayRow.nextRow = new_row;
            ArrayEntry sentinel_entry = new ArrayEntry(column);
            new_row.rowSentinel = sentinel_entry;
            sentinel_entry.value = value;
            return;
        }
        arrayRow = arrayRow.nextRow;
        ArrayEntry arrayEntry = FindColumnBefore(column, arrayRow.rowSentinel);
        if (arrayRow.rowSentinel == arrayEntry && arrayEntry.columnNumber > column) {
            arrayRow.rowSentinel = new ArrayEntry(column, value, arrayEntry);
        } else {
            if (arrayEntry.nextEntry == null || arrayEntry.nextEntry.columnNumber > column) {

                ArrayEntry new_entry = new ArrayEntry(column);
                new_entry.nextEntry = arrayEntry.nextEntry;
                arrayEntry.nextEntry = new_entry;
            }
            arrayEntry = arrayEntry.nextEntry;
            arrayEntry.value = value;
        }
    }

    int GetValue(int row, int column) {
        ArrayRow arrayRow = FindRowBefore(row);
        arrayRow = arrayRow.nextRow;
        if (arrayRow == null || arrayRow.rowNumber > row) return Integer.MAX_VALUE;
        ArrayEntry arrayEntry = FindColumnBefore(column, arrayRow.rowSentinel);
        if (arrayEntry == null || arrayEntry.columnNumber > column) return Integer.MAX_VALUE;
        if (arrayEntry.nextEntry != null && arrayEntry.nextEntry.columnNumber == column)
            arrayEntry = arrayEntry.nextEntry;
        else if (arrayEntry.nextEntry != null && arrayEntry.nextEntry.columnNumber > column && arrayEntry.columnNumber != column)
            return Integer.MAX_VALUE;
        else if (arrayEntry.nextEntry == null && arrayEntry.columnNumber < column)
            return Integer.MAX_VALUE;
        return arrayEntry.value;
    }

    private static ArrayEntry FindColumnBefore(int column, ArrayEntry array_row_sentinel) {
        ArrayEntry arrayEntry = array_row_sentinel;
        while (arrayEntry.nextEntry != null && arrayEntry.nextEntry.columnNumber < column)
            arrayEntry = arrayEntry.nextEntry;
        return arrayEntry;
    }

    void DeleteEntry(int row, int column) {
        ArrayRow arrayRow = FindRowBefore(row);
        if (arrayRow.nextRow == null || arrayRow.nextRow.rowNumber > row)
            return;
        ArrayRow target_row = arrayRow.nextRow;
        ArrayEntry arrayEntry = FindColumnBefore(column, target_row.rowSentinel);
        if (arrayEntry == target_row.rowSentinel) {
            if (arrayEntry.nextEntry == null)
                arrayRow.nextRow = arrayRow.nextRow.nextRow;
            else if (arrayEntry.nextEntry.columnNumber > column && arrayEntry.columnNumber == column) {
                target_row.rowSentinel = arrayEntry.nextEntry;
            } else if (arrayEntry.nextEntry.columnNumber == column) {
                arrayEntry.nextEntry = arrayEntry.nextEntry.nextEntry;
            }
        } else if (arrayEntry.nextEntry == null || arrayEntry.nextEntry.columnNumber > column) {
        } else {
            arrayEntry.nextEntry = arrayEntry.nextEntry.nextEntry;
        }
    }
}
