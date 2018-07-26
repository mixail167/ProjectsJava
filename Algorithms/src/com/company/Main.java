package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    private static int FindIndex(int row, int column) {
        return (row * row + row) / 2 + column;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Треугольный массив");
        int n = 0;
        do {
            System.out.print("Введите N:");
            try {
                n = Integer.parseInt(bufferedReader.readLine());
                int[] array = new int[(n * n + n) / 2];
                Random r = new Random();
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n && i >= j; j++)
                        array[FindIndex(i, j)] = r.nextInt(100);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n && i >= j; j++)
                        System.out.printf("%-3d",array[FindIndex(i, j)]);
                    System.out.println();
                }
            } catch (Exception ignored) {

            }
        } while (n <= 0);

        /*ArrayRow arrayRow = new ArrayRow(0,2,5);
        //arrayRow.SetValue(0,2,5);
        arrayRow.SetValue(1,4,20);
        arrayRow.SetValue(0,5,6);
        arrayRow.SetValue(0,1,8);
        int temp = arrayRow.GetValue(0,2);
        System.out.println(temp);
        temp = arrayRow.GetValue(1,4);
        System.out.println(temp);
        temp = arrayRow.GetValue(0,5);
        System.out.println(temp);*/
    }
}
