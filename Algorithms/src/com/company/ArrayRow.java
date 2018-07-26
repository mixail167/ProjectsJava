package com.company;

class ArrayRow {
    private int rowNumber;
    private ArrayRow nextRow;
    private ArrayEntry rowSentinel;

    public ArrayRow(int row, int column, int value) {
        rowNumber = row;
        rowSentinel = new ArrayEntry(column, value);
    }

    private ArrayRow FindRowBefore(int row) {
        ArrayRow arrayRow = this;
        while (arrayRow.nextRow != null && arrayRow.nextRow.rowNumber < row) {
            arrayRow = arrayRow.nextRow;
        }
        return arrayRow;
    }

    public ArrayRow() {
    }

    public ArrayRow(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    void SetValue(int row, int column, int value) {
        if (value == 0) {
            DeleteEntry(row, column);
            return;
        }
        ArrayRow arrayRow = FindRowBefore(row);
        if (arrayRow.nextRow == null || arrayRow.nextRow.rowNumber < row) {
            ArrayRow new_row = new ArrayRow(row);
            new_row.nextRow = arrayRow.nextRow;
            arrayRow.nextRow = new_row;

            ArrayEntry sentinel_entry = new ArrayEntry(column);
            new_row.rowSentinel = sentinel_entry;
            sentinel_entry.nextEntry = null;
            sentinel_entry.value = value;
            arrayRow = arrayRow.nextRow;
        }
        ArrayEntry arrayEntry = FindColumnBefore(column, arrayRow.rowSentinel);
        if (arrayEntry.nextEntry == null || arrayEntry.nextEntry.columnNumber < column)
        {
            ArrayEntry new_entry = new ArrayEntry(column);
            new_entry.nextEntry = arrayEntry.nextEntry;
            arrayEntry.nextEntry = new_entry;
            arrayEntry = arrayEntry.nextEntry;
            arrayEntry.value = value;
        }
        else if (arrayEntry.nextEntry != null || arrayEntry.nextEntry.columnNumber > column)
        {
            ArrayEntry new_entry = new ArrayEntry(column);
            new_entry.nextEntry = arrayEntry.nextEntry;
            arrayEntry.nextEntry = new_entry;
            arrayEntry = arrayEntry.nextEntry;
            arrayEntry.value = value;
        }
    }

    int GetValue(int row, int column) {
        ArrayRow arrayRow = FindRowBefore(row);
        arrayRow = arrayRow.nextRow;
        if (arrayRow == null || arrayRow.rowNumber > row) return 0;
        ArrayEntry arrayEntry = FindColumnBefore(column, arrayRow.rowSentinel);
        if (arrayEntry == null || arrayEntry.columnNumber > column) return 0;
        return arrayEntry.value;
    }

    private static ArrayEntry FindColumnBefore(int column, ArrayEntry array_row_sentinel) {
        ArrayEntry arrayEntry = array_row_sentinel;
        while (arrayEntry.nextEntry != null && arrayEntry.nextEntry.columnNumber < column)
            arrayEntry = arrayEntry.nextEntry;
        return arrayEntry;
    }

    private void DeleteEntry(int row, int column) {
        ArrayRow arrayRow = FindRowBefore(row);
        if (arrayRow.nextRow == null || arrayRow.nextRow.rowNumber > row)
            return;
        ArrayRow target_row = arrayRow.nextRow;
        ArrayEntry arrayEntry = FindColumnBefore(column, target_row.rowSentinel);
        if (arrayEntry.nextEntry == null || arrayEntry.nextEntry.columnNumber > column)
            return;
        arrayEntry.nextEntry = arrayEntry.nextEntry.nextEntry;
        if (target_row.rowSentinel.nextEntry != null)
            return;
        arrayRow.nextRow = arrayRow.nextRow.nextRow;

    }
}
