package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    private static int[] Erastofen(int n)
    {
        boolean[] arrayBool = new boolean[n];
        for (int i = 2; i < n; i++) {
            arrayBool[i] = true;
        }
        for (int i = 2; i < Math.sqrt(arrayBool.length) + 1; ++i) {
            if (arrayBool[i]) {
                for (int j = i * i; j < n; j += i) {
                    arrayBool[j] = false;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (arrayBool[i])
            {
                list.add(i);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static int FindIndex(int row, int column) {
        return (row * row + row) / 2 + column;
    }

    private static int InterpolationSearch(int[] sortedArray, int toFind) {
        int mid;
        int low = 0;
        int high = sortedArray.length - 1;
        while (sortedArray[low] < toFind && sortedArray[high] > toFind) {
            mid = low + ((toFind - sortedArray[low]) * (high - low)) / (sortedArray[high] - sortedArray[low]);

            if (sortedArray[mid] < toFind)
                low = mid + 1;
            else if (sortedArray[mid] > toFind)
                high = mid - 1;
            else
                return mid;
        }
        if (sortedArray[low] == toFind)
            return low;
        else if (sortedArray[high] == toFind)
            return high;
        else
            return -1;
    }

    private static int BinarySearch(int[] sortedArray, int toFind) {
        int mid;
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high) {
            mid = (int) ((low + high) * 1.0 / 2);
            if (sortedArray[mid] < toFind)
                low = mid + 1;
            else if (sortedArray[mid] > toFind)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    private static void ResetQueen(int i, int j, int[][] board) {
        for (int x = 0; x < board.length; ++x) {
            --board[x][j];
            --board[i][x];
            int k;
            k = j - i + x;
            if (k >= 0 && k < board.length)
                --board[x][k];
            k = j + i - x;
            if (k >= 0 && k < board.length)
                --board[x][k];
        }
        board[i][j] = 0;
    }

    private static boolean TryQueen(int i, int[][] board) {
        boolean result = false;
        for (int j = 0; j < board.length; ++j) {
            if (board[i][j] == 0) {
                SetQueen(i, j, board);
                if (i == board.length - 1)
                    result = true;
                else {
                    if (!(result = TryQueen(i + 1, board)))
                        ResetQueen(i, j, board);
                }
            }
            if (result)
                break;
        }
        return result;
    }

    private static void SetQueen(int i, int j, int[][] board) {
        for (int x = 0; x < board.length; ++x) {
            ++board[x][j];
            ++board[i][x];
            int k;
            k = j - i + x;
            if (k >= 0 && k < board.length)
                ++board[x][k];
            k = j + i - x;
            if (k >= 0 && k < board.length)
                ++board[x][k];
        }
        board[i][j] = -1;
    }


    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Треугольный массив");
        int n = 0;
        int[] array = new int[1];
        do {
            System.out.print("Введите N:");
            try {
                n = Integer.parseInt(bufferedReader.readLine());
                array = new int[(n * n + n) / 2];
                Random r = new Random();
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n && i >= j; j++)
                        array[FindIndex(i, j)] = r.nextInt(100);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n && i >= j; j++)
                        System.out.printf("%-3d", array[FindIndex(i, j)]);
                    System.out.println();
                }
            } catch (Exception ignored) {

            }
        } while (n <= 0);
        System.out.println("Восемь ферзей");
        while (true) {
            System.out.print("Введите N:");
            try {
                n = Integer.parseInt(bufferedReader.readLine());
                int[][] board = new int[n][n];
                TryQueen(0, board);
                for (int[] aBoard : board) {
                    for (int j = 0; j < board.length; j++) {
                        if (aBoard[j] == -1)
                            System.out.print("+");
                        else
                            System.out.print("-");
                    }
                    System.out.println();
                }
                break;
            } catch (Exception ignored) {

            }
        }
        System.out.println("Интерполяционный поиск в треугольном массиве");
        while (true) {
            try {
                System.out.print("Введите целевой элемент:");
                n = Integer.parseInt(bufferedReader.readLine());
                Arrays.sort(array);
                int index = InterpolationSearch(array, n);
                System.out.printf("Результат: %d\n", index);
                break;
            } catch (Exception ignored) {

            }
        }
        System.out.println("Бинарный поиск в треугольном массиве");
        while (true) {
            try {
                System.out.print("Введите целевой элемент:");
                n = Integer.parseInt(bufferedReader.readLine());
                Arrays.sort(array);
                int index = BinarySearch(array, n);
                System.out.printf("Результат: %d\n", index);
                break;
            } catch (Exception ignored) {

            }
        }
        System.out.println("Массив с разрывом");
        ArrayRow arrayRow = new ArrayRow();
        n = 10;
        int bound = 5;
        int[] rows = new int[n];
        int[] columns = new int[n];
        int[][] values = new int[bound][bound];
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                values[i][j] = Integer.MAX_VALUE;
            }
        }
        Random random = new Random();
        for (int i = 0; i < rows.length; i++) {
            rows[i] = random.nextInt(bound);
            columns[i] = random.nextInt(bound);
            values[rows[i]][columns[i]] = random.nextInt(bound);
            arrayRow.SetValue(rows[i], columns[i], values[rows[i]][columns[i]]);
        }
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                if (values[i][j] != Integer.MAX_VALUE) {
                    System.out.printf("%-3d", values[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                int value = arrayRow.GetValue(i, j);
                if (value != Integer.MAX_VALUE) {
                    System.out.printf("%-3d", value);
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 2; i++) {
            int row = rows[random.nextInt(n)];
            int column = columns[random.nextInt(n)];
            values[row][column] = Integer.MAX_VALUE;
            arrayRow.DeleteEntry(row, column);
        }
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                if (values[i][j] != Integer.MAX_VALUE) {
                    System.out.printf("%-3d", values[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                int value = arrayRow.GetValue(i, j);
                if (value != Integer.MAX_VALUE) {
                    System.out.printf("%-3d", value);
                }
            }
            System.out.println();
        }
        System.out.println("Решето Эрастофена");
        while (true) {
            System.out.print("Введите правую границу последовательности чисел: ");
            try {
                n = Integer.parseInt(bufferedReader.readLine());
                if (n >= 2)
                    array = Erastofen(n);
                    for (int item : array)
                    {
                        System.out.printf("%d ", item);
                    }
                    break;
            } catch (Exception ignored) {

            }
        }
    }
}
