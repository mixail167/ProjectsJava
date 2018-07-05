package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static BufferedReader bufferedReader;

    private static int MaxFactorial() {
        int i = 1;
        int f = 1;
        do {
            i++;
            f *= i;
        } while (f < Integer.MAX_VALUE / (i + 1));
        return i;
    }

    private static int Factorial(int n) {
        if (n == 0) return 1;
        else return n * Factorial(n - 1);

    }

    private static void CalculateFactorial(int maxFactorial) {
        try {
            System.out.print(String.format("Введите число от 0 до %d: ", maxFactorial));
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n >= 0 && n <= maxFactorial) {
                System.out.println(String.format("Факториал числа %d: " + Factorial(n), n));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateFactorial(maxFactorial);
        }
    }

    private static int Fibonachchi(int count) {
        int n1 = 1;
        int n = 0;
        for (int i = 1; i <= count; i++) {
            int n2 = n1;
            n1 = n;
            n = n1 + n2;
        }
        return n;
    }

    private static int MaxFibonachchi() {
        int n1 = 1;
        int n = 0;
        int iterator = 2;
        while (n >= 0) {
            int n2 = n1;
            n1 = n;
            n = n1 + n2;
            iterator++;
        }
        return iterator - 1;
    }

    private static void CalculateFibonachchi(int max) {
        System.out.print(String.format("Введите число от 1 до %d: ", max));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n > 0 && n <= max) {
                System.out.println(String.format("Число Фибоначчи: %d", Fibonachchi(n)));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateFibonachchi(max);
        }
    }

    private static int Cube(int count) {

        int iterator = 1;
        int sum = 0;
        for (int i = 0; i < count - 1; i++) {
            iterator += 2 * (i + 1);
        }
        for (int i = 0; i < count; i++) {
            sum += iterator;
            iterator += 2;
        }
        return sum;
    }

    private static int MaxCube() {
        return (int) (Math.pow((double) Integer.MAX_VALUE, 1.0 / 3));
    }


    private static void CalculateCube(int max) {
        System.out.print(String.format("Введите число от -%d до %d: ", max, max));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n >= -max && n <= max) {
                int cube = Cube(Math.abs(n));
                if (n < 0) {
                    cube = -cube;
                }
                System.out.println(String.format("Число %d в кубе: %d", n, cube));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateCube(max);
        }
    }

    private static double RootFromNumber(double x, int m) {
        if (x == 0)
            return 0;
        double epsilon = Math.pow(10.0, -5.0);
        double y1 = 1.0;
        double y;
        double m1 = (m - 1) * 1.0 / (m * 1.0);
        double z = x / (m * 1.0);
        int i;
        do {
            y = y1;
            i = 1;
            double w = z;
            while (i < m && w >= epsilon) {
                w /= y1;
                i++;
            }
            y1 = y * m1 + w;
        } while (Math.abs(y1 - y) >= epsilon);
        return y1;
    }

    private static void CalculateRootFromNumber() {
        try {
            System.out.print("Введите число >= 0: ");
            double x = Double.parseDouble(bufferedReader.readLine());
            System.out.print("Введите степень > 0: ");
            int m = Integer.parseInt(bufferedReader.readLine());
            if (x >= 0 && m > 0) {
                System.out.println(String.format("Корень степеи %d из числа %f: %f", m, x, RootFromNumber(x, m)));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateRootFromNumber();
        }
    }

    private static int RootFromNaturalNumber(int x, int m) {
        int a = 1;
        int b = x + 1;
        while (b - a > 1) {
            int ab = (int) (a * 1.0 / 2 + b * 1.0 / 2);
            int x1 = x;
            for (int i = 0; i < m - 1; i++) {
                x1 /= ab;
            }
            if (x1 >= ab) {
                a = ab;
            } else b = ab;
        }
        return a;
    }

    private static void CalculateRootFromNaturalNumber() {
        try {
            System.out.print(String.format("Введите число от 0 до %d: ", Integer.MAX_VALUE - 2));
            int x = Integer.parseInt(bufferedReader.readLine());
            System.out.print("Введите степень > 0: ");
            int m = Integer.parseInt(bufferedReader.readLine());
            if (x >= 0 && x <= Integer.MAX_VALUE - 2 && m > 0) {
                int root = RootFromNaturalNumber(x, m);
                System.out.println(String.format("Корень степеи %d из числа %d: %d", m, x, root));
                System.out.println(String.format("Остаток: %d", Rest(root, x, m)));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateRootFromNaturalNumber();
        }
    }

    private static int Rest(int root, int x, int m) {
        return (int) (x - Math.pow((double) root, (double) m));
    }

    private static int[][] TriangleOfPascal(int count) {
        int[][] a = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++)
                a[i][j] = 0;
        }
        for (int i = 0; i < count; i++)
            a[i][0] = 1;
        for (int i = 1; i < count; i++) {
            for (int j = 1; j < i + 1; j++) {
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                if (a[i][j] < 0) {
                    System.out.println(count);
                }
            }
        }
        return a;
    }

    private static void CalculateTriangleOfPascal() {
        try {
            System.out.print("Введите размер треугольника от 1 до 34: ");
            int count = Integer.parseInt(bufferedReader.readLine());
            if (count > 0 && count <= 34) {
                PrintMatrix(TriangleOfPascal(count));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateTriangleOfPascal();
        }
    }

    private static void PrintMatrix(int[][] a) {
        for (int[] row : a) {
            for (int j = 0; j < a.length; j++) {
                if (row[j] != 0)
                    System.out.print(String.format("%d ", row[j]));
            }
            System.out.println();
        }
    }

    private static void PrintMassiv(int[] a) {
        for (int item : a) System.out.print(String.format("%d ", item));
        System.out.println();
    }

    private static void PrintIntegerList(List<Integer> list) {
        for (int item : list) System.out.print(String.format("%d ", item));
        System.out.println();
    }

    private static void TriangleMinMax(int min, int max) {
        for (int a = min; a <= max; a++) {
            for (int b = a; b <= max; b++) {
                for (int c = b; c <= max; c++) {
                    Triangle triangle = new Triangle(a, b, c);
                    if (triangle.Check()) {
                        System.out.println(String.format("a=%d, b=%d, c=%d %s %s",
                                triangle.getA(), triangle.getB(), triangle.getC(),
                                triangle.GetTypeOfSides().toString(), triangle.GetTypeOfAngle().toString()));
                    }
                }
            }
        }
    }

    private static void CalculateTriangle() {
        try {
            System.out.print(String.format("Введите min от 1 до %d: ", Integer.MAX_VALUE / 2));
            int min = Integer.parseInt(bufferedReader.readLine());
            if (min > 0 && min <= Integer.MAX_VALUE / 2) {
                System.out.print(String.format("Введите max от %d до %d: ", min + 1, Integer.MAX_VALUE / 2));
                int max = Integer.parseInt(bufferedReader.readLine());
                if (max > min && max <= Integer.MAX_VALUE / 2) {
                    TriangleMinMax(min, max);
                } else throw new Exception();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateTriangle();
        }
    }

    private static void CalculateCutRectangle() {
        try {
            System.out.print(String.format("Введите a от 1 до %d: ", Integer.MAX_VALUE));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a > 0) {
                System.out.print(String.format("Введите b от 1 до %d: ", Integer.MAX_VALUE));
                int b = Integer.parseInt(bufferedReader.readLine());
                if (b > 0) {
                    CutRectangle(a, b);
                } else throw new Exception();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateCutRectangle();
        }
    }

    private static void CutRectangle(int a, int b) {
        int n = 0;
        do {
            if (a < b) {
                int x = a;
                a = b;
                b = x;
            }
            int k = a / b;
            a = a % b;
            n += k;
            System.out.println(String.format("%d*%d %d", b, b, k));
        } while (a != 0);
        System.out.println(String.format("Всего квадратов: %d", n));
    }

    private static void Equation(int m) {
        int a;
        int b;
        int c = 1;
        int d = 1;
        do {
            a = c;
            b = d;
            int fcd = Integer.MAX_VALUE;
            int fab = f(a, b, m);
            int y;
            for (int x = 1; x <= a; x++) {
                y = b + 1;
                while (fab > f(x, y, m)) {
                    y++;
                }
                if (f(x, y, m) < fcd) {
                    fcd = f(x, y, m);
                    c = x;
                    d = y;
                }
            }
            for (int x = a + 1; x <= b; x++) {
                y = x;
                while (fab > f(x, y, m) && (y < b)) {
                    y++;
                }
                if (f(x, y, m) < fcd) {
                    fcd = f(x, y, m);
                    c = x;
                    d = y;
                }
            }
        } while (f(a, b, m) != f(c, d, m));
        System.out.println(String.format("%d %d %d %d %d", a, b, c, d, f(a, b, m)));
    }

    private static int f(int a, int b, int m) {
        return (int) (Math.pow((double) a, (double) m) + Math.pow((double) b, (double) m));
    }

    private static void CalculateEquation() {
        try {
            System.out.print("Введите степень > 0: ");
            int m = Integer.parseInt(bufferedReader.readLine());
            if (m > 0) Equation(m);
            else throw new Exception();
        } catch (Exception e) {
            CalculateEquation();
        }
    }

//    private static void Schitalka(int n, int m) {
//        ArrayList<Integer> crug = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            crug.add(i);
//        }
//        int iterator = 0;
//        int i = n;
//        do {
//            for (int x = 1; x <= m; x++) {
//                do {
//                    i = i % (n + 1);
//                    if (crug.contains(i)) {
//                        break;
//                    }
//                }
//                while (true);
//            }
//            System.out.println(i - 1);
//            crug.set(i - 1, Integer.MIN_VALUE);
//            iterator++;
//        } while (iterator != n);
//    }

    private static int Schitalka(int n, int m) {
        if (n > 1) {
            return (Schitalka(n - 1, m) + m - 1) % n + 1;
        } else
            return 1;
    }

    private static void CalculateSchitalka() {
        try {
            System.out.print(String.format("Введите число лиц от 2 до %d: ", Integer.MAX_VALUE));
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n >= 2) {
                System.out.print(String.format("Введите число слов от 2 до %d: ", Integer.MAX_VALUE));
                int m = Integer.parseInt(bufferedReader.readLine());
                if (m >= 2) {
                    System.out.println(String.format("Номер проигравшего: %d", Schitalka(n, m)));
                } else throw new Exception();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateSchitalka();
        }
    }

    private static int[] Sharing(int n) {
        int[] a = GenerateMassiv(n, 100);
        for (int i = 0; i < n; i++) {
            int temp = (int) (a[i] * 1.0 / (n - 1));
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    a[j] += temp;
                }
            }
            a[i] %= (n - 1);
            //a[i]=0;
        }
        return a;
    }

    private static int[] GenerateMassiv(int n, int bound) {
        int[] a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(bound);
        }
        return a;
    }

    private static void CalculateSharing() {
        try {
            System.out.print(String.format("Введите число лиц от 1 до %d: ", Integer.MAX_VALUE));
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n > 0) PrintMassiv(Sharing(n));
            else throw new Exception();
        } catch (Exception e) {
            CalculateSharing();
        }
    }

    private static void CalculateNOD() {
        try {
            System.out.print(String.format("Введите размер последовательности от 1 до %d: ", Integer.MAX_VALUE));
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n > 0) System.out.println(String.format("НОД: %d", NODCycle(n)));
            else throw new Exception();
        } catch (Exception e) {
            CalculateNOD();
        }
    }

    private static int NODCycle(int n) {
        int[] a = GenerateMassiv(n, 200);
        PrintMassiv(a);
        int nod = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            nod = NOD(nod, a[i]);
        }
        return nod;
    }

    private static int NOKCycle(int n) {
        int[] a = GenerateMassiv(n, 200);
        PrintMassiv(a);
        int nok = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            nok = NOK(nok, a[i]);
        }
        return nok;
    }

    private static int NOK(int a, int b) {
        return (int) (a * 1.0) / (NOD(a, b) * b);
    }

    private static int NOD(int a, int b) {
        if (a == 0) return b;
        return NOD(b % a, a);
    }

    private static void CalculateMutuallySimpleNumbers() {
        try {
            System.out.print(String.format("Введите число a от 1 до %d: ", Integer.MAX_VALUE));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a > 0) {
                System.out.print(String.format("Введите число b от 1 до %d: ", Integer.MAX_VALUE));
                int b = Integer.parseInt(bufferedReader.readLine());
                if (b > 0) {
                    if (MutuallySimpleNumbers(a, b))
                        System.out.println("Числа взаимно простые");
                    else System.out.println("Числа не взаимно простые");
                } else throw new Exception();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateMutuallySimpleNumbers();
        }
    }

    private static boolean MutuallySimpleNumbers(int a, int b) {
        return NOD(a, b) == 1;
    }

    private static void CalculateNOK() {
        try {
            System.out.print(String.format("Введите размер последовательности от 1 до %d: ", Integer.MAX_VALUE));
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n > 0) System.out.println(String.format("НОК: %d", NOKCycle(n)));
            else throw new Exception();
        } catch (Exception e) {
            CalculateNOK();
        }
    }


    private static void CalculateBilliards() {
        try {
            System.out.print(String.format("Введите  a от 1 до %d: ", Integer.MAX_VALUE));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a > 0) {
                System.out.print(String.format("Введите число b от 1 до %d: ", Integer.MAX_VALUE));
                int b = Integer.parseInt(bufferedReader.readLine());
                if (b > 0) {

                    System.out.println(String.format("Число отрезков: %d", Billiards(a, b)));
                } else throw new Exception();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateBilliards();
        }
    }

    private static int Billiards(int a, int b) {
        int max, min;
        if (a >= b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        int n = 0;
        int d = min;
        while (d != 0) {
            d = max - d;
            n++;
            while (d >= min) {
                d -= min;
                n++;
            }
            if (d != 0) {
                d = min - d;
                n++;
            }
        }
        return n;
    }

    private static void CalculateDividers() {
        try {
            System.out.print(String.format("Введите число от 1 до %d: ", Integer.MAX_VALUE));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a > 0) {
                System.out.print("Делители: ");
                Dividers(a, 1);
                System.out.println();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateDividers();
        }
    }

    private static void Dividers(int n, int d) {
        while (n % d != 0 && d * d < n) {
            d++;
        }
        if (d * d <= n) {
            System.out.print(String.format("%d ", d));
            int dd = (int) (n * 1.0 / d);
            if (d != dd) {
                Dividers(n, d + 1);
                System.out.print(String.format("%d ", dd));
            }
        }
    }

    private static void CalculateMultipliers() {
        try {
            System.out.print(String.format("Введите число от 2 до %d: ", Integer.MAX_VALUE));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a > 1) {
                System.out.print("Множители: ");
                Multipliers(a);
                System.out.println();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateMultipliers();
        }
    }

    private static void Multipliers(int n) {
        while (n % 2 == 0) {
            System.out.print(String.format("%d ", 2));
            n /= 2;
        }
        int i = 3;
        while (i <= n) {
            if (n % i == 0) {
                System.out.print(String.format("%d ", i));
                n /= i;
            } else i += 2;
        }
    }

    private static void CalculateErastofen() {
        try {
            System.out.print(String.format("Введите правую границу диапозона от 2 до %d: ", Integer.MAX_VALUE));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a > 1) {
                System.out.print("Простые числа: ");
                Erastofen(a, true);
                System.out.println();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateErastofen();
        }
    }

    private static boolean[] Erastofen(int n, boolean show) {
        int len = (int) (n * 1.0 / 2);
        boolean[] s = new boolean[n + 1];
        for (int i = 2; i < len; i++) {
            if (!s[i]) {
                int j = i + i;
                while (j <= n) {
                    s[j] = true;
                    j += i;
                }
            }
        }
        if (show) {
            for (int i = 2; i < s.length; i++) {
                if (!s[i])
                    System.out.print(String.format("%d ", i));
            }
        }
        return s;
    }

    private static void CalculateTwins() {
        try {
            System.out.print(String.format("Введите правую границу диапозона от 5 до %d: ", Integer.MAX_VALUE));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a >= 5) {
                System.out.print("Близнецы: ");
                Twins(a);
                System.out.println();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateTwins();
        }
    }

    private static void Twins(int n) {
        boolean[] s = Erastofen(n, false);
        for (int i = 5; i <= n; i += 2) {
            if (!s[i - 2] && !s[i - 4]) {
                System.out.print(String.format("(%d, %d) ", i - 2, i));
            }
        }
    }

    private static void CalculateCloth() {
        try {
            System.out.print(String.format("Введите правую границу диапозона от 2 до %d: ", RootFromNaturalNumber(Integer.MAX_VALUE - 1, 2)));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a >= 2) {
                System.out.println("Скатерть: ");
                Cloth(a);
            } else throw new Exception();
        } catch (Exception e) {
            CalculateCloth();
        }
    }

    private static void Cloth(int m) {
        boolean[] s = Erastofen(m * m, false);
        int x = (int) (m * 1.0 / 2) - 1;
        int y = x;
        boolean[][] cloth = new boolean[m][m];
        cloth[x][y] = true;
        cloth[x + 1][y] = s[2];
        cloth[x + 1][y + 1] = s[3];
        cloth[x][y + 1] = s[4];
        int d = 1;
        int k = 4;
        y++;
        do {
            x--;
            y++;
            d += 2;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < d; j++) {
                    switch (i) {
                        case 0:
                            y--;
                            break;
                        case 1:
                            x++;
                            break;
                        case 2:
                            y++;
                            break;
                        case 3:
                            x--;
                            break;
                    }
                    k++;
                    cloth[x][y] = s[k];
                }
            }
        } while (d != m - 1);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (!cloth[j][i]) {
                    System.out.print("*");
                } else System.out.print("+");
            }
            System.out.println();
        }
    }

    private static void CalculatePerfectNumbers() {
        try {
            System.out.print("Введите верхнюю границу диапозона от 2 до 40000000: ");
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a >= 2 && a <= 40000000) {
                System.out.print("Совершенные числа: ");
                PerfectNumbers(a);
                System.out.println();
            } else throw new Exception();
        } catch (Exception e) {
            CalculatePerfectNumbers();
        }
    }

    private static void PerfectNumbers(int n) {
        int[] a = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            a[i] = 1;
        }
        int len = (int) (n * 1.0 / 2);
        for (int i = 2; i <= len; i++) {
            int p = i + i;
            while (p <= n) {
                a[p] += i;
                p += i;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (a[i] == i) {
                System.out.print(String.format("%d ", i));
            }
        }
    }

    private static void CalculateFriendlyNumbers() {
        try {
            System.out.print("Введите верхнюю границу диапозона от 2 до 40000000: ");
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a >= 2 && a <= 40000000) {
                System.out.print("Дружественые числа: ");
                FriendlyNumbers(a);
                System.out.println();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateFriendlyNumbers();
        }
    }

    private static void FriendlyNumbers(int n) {
        int[] a = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            a[i] = 1 + i;
        }
        int len = (int) (n * 1.0 / 2);
        for (int i = 2; i <= len; i++) {
            int p = i + i;
            while (p <= n) {
                a[p] += i;
                p += i;
            }
        }
        for (int i = 2; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (a[i] == i + j && a[j] == i + j) {
                    System.out.print(String.format("(%d, %d) ", i, j));
                }
            }
        }
    }

    private static void CalculateAutoMorfNumbers() {
        try {
            System.out.print(String.format("Введите степень от 2 до %d: ", Integer.MAX_VALUE));
            int m = Integer.parseInt(bufferedReader.readLine());
            if (m >= 2) {
                int max = (int) (Math.pow(Integer.MAX_VALUE, 1.0 / m));
                System.out.print(String.format("Введите нижнюю границу диапозона от 1 до %d: ", max));
                int a = Integer.parseInt(bufferedReader.readLine());
                if (a >= 1 && a <= max) {
                    System.out.print(String.format("Введите верхнюю границу диапозона от %d до %d: ", a, max));
                    int b = Integer.parseInt(bufferedReader.readLine());
                    if (b >= a && b <= max) {
                        System.out.print("Автоморфные числа: ");
                        AutoMorfNumbers(a, b, m);
                        System.out.println();
                    } else throw new Exception();
                } else throw new Exception();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateAutoMorfNumbers();
        }
    }

    private static int CifraCount(int a) {
        int k = 0;
        do {
            k++;
            a = (int) (a * 1.0 / 10);
        } while (a != 0);
        return k;
    }

    private static int CifraSum(int a) {
        int s = 0;
        do {
            s += a % 10;
            a = (int) (a * 1.0 / 10);
        } while (a != 0);
        return s;
    }


    private static void AutoMorfNumbers(int a, int b, int m) {
        for (int i = a; i <= b; i++) {
            int d = (int) Math.pow((double) 10, (double) CifraCount(i));
            int k = (int) Math.pow((double) i, (double) m);
            if (k % d == i) {
                System.out.print(String.format("(%d, %d) ", i, k));
            }
        }
    }

    private static void CalculateNumberingOfPages() {
        try {
            System.out.print("Введите число страниц от 2 до 250954972: ");
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a >= 2 && a <= 250954972) {
                System.out.println(String.format("Число цифр: %d", NumberingOfPages(a)));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateNumberingOfPages();
        }
    }

    private static int NumberingOfPages(int n) {
        int sum = 0;
        int min = 1;
        int max = 9;
        int count = CifraCount(n);
        for (int i = 1; i <= count - 1; i++) {
            sum += (max - min + 1) * i;
            min *= 10;
            max = min * 10 - 1;
        }
        return sum + (n - min + 1) * count;
    }

    private static void CalculateCubeSum() {
        try {
            System.out.print(String.format("Введите нижнюю границу диапозона от 0 до %d: ", Integer.MAX_VALUE));
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a >= 0) {
                System.out.print(String.format("Введите верхнюю границу диапозона от %d до %d: ", a, Integer.MAX_VALUE));
                int b = Integer.parseInt(bufferedReader.readLine());
                if (b >= a) {
                    System.out.print("Числа: ");
                    PrintIntegerList(CubeSum(a, b));
                } else throw new Exception();
            } else throw new Exception();
        } catch (Exception e) {
            CalculateAutoMorfNumbers();
        }

    }

    private static List<Integer> CubeSum(int a, int b) {
        List<Integer> list = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            if (i == Cube(CifraSum(i))) {
                list.add(i);
            }
        }
        return list;
    }

    private static void CalculateNumbersArmstrong() {
        try {
            System.out.print("Введите число знаков от 2 до 10: ");
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a >= 2 && a <= 10) {
                System.out.print("Числа Армстронга: ");
                PrintIntegerList(NumbersArmstrongAll(a));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateNumbersArmstrong();
        }
    }

    private static List<Integer> NumbersArmstrongAll(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            list.addAll(NumbersArmstrong(i));
        }
        return list;
    }

    private static List<Integer> NumbersArmstrong(int n) {
        List<Integer> list = new ArrayList<>();
        int[] step = new int[10];
        for (int i = 0; i < step.length; i++) {
            step[i] = i;
            for (int j = 2; j <= n; j++) {
                step[i] *= i;
            }
        }
        int min = 1;
        for (int i = 1; i < n; i++) {
            min = min * 10;
        }
        int max;
        if (n == 10) {
            max = Integer.MAX_VALUE;
        } else max = min * 10 - 1;
        for (int i = min; i <= max; i++) {
            int p = i;
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += step[p % 10];
                p = (int) (p * 1.0 / 10);
            }
            if (sum == i)
                list.add(i);
        }
        return list;
    }

    private static void CalculateZ42() {
        try {
            System.out.print("Введите число от 2 до 9: ");
            int a = Integer.parseInt(bufferedReader.readLine());
            if (a >= 2 && a <= 10) {
                System.out.print("Число: ");
                Z42(a);
            } else throw new Exception();
        } catch (Exception e) {
            CalculateZ42();
        }
    }

    private static void Z42(int n) {
        int a = n;
        do {
            int b = (int) (a * 1.0 / n);
            System.out.print(b);
            a = (a % n) * 10 + b;
        } while (a != n);
    }

    private static void CalculateDecimal() {
        try {
            System.out.print("Введите числитель: ");
            int a = Integer.parseInt(bufferedReader.readLine());
            System.out.print("Введите знаменатель > 0: ");
            int b = Integer.parseInt(bufferedReader.readLine());
            if (b > 0) {
                System.out.print(String.format("Число: %s", Decimal(new Decimal(a, b))));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateDecimal();
        }
    }

    private static int[] Period(Decimal decimal, int max) {
        int[] ost = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            ost[i] = 0;
        }
        int[] mas = new int[2];
        mas[0] = max;
        mas[1] = 0;
        do {
            mas[1]++;
            ost[decimal.getNumerator()] = mas[1];
            decimal.setNumerator((decimal.getNumerator() * 10) % decimal.getDenominator());
        } while (ost[decimal.getNumerator()] == 0);
        if (decimal.getNumerator() == 0)
            mas[1]--;
        else mas[0] = ost[decimal.getNumerator()];
        return mas;
    }

    private static String Decimal(Decimal decimal) {
        String s = "";
        if (decimal.getNumerator() < 0) {
            s = "-";
            decimal.setNumerator(Math.abs(decimal.getNumerator()));
        }
        s = s.concat(String.valueOf((int) (decimal.getNumerator() * 1.0 / decimal.getDenominator()))).concat(".");
        decimal.setNumerator(decimal.getNumerator() % decimal.getDenominator());
        int max = 100;
        int[] mas = Period(decimal, max);
        for (int i = 1; i <= mas[1]; i++) {
            if (i == mas[0]) s = s.concat("(");
            s = s.concat(String.valueOf((decimal.getNumerator() * 10) / decimal.getDenominator()));
            decimal.setNumerator((decimal.getNumerator() * 10) % decimal.getDenominator());
        }
        if (mas[0] != max) s = s.concat(")");
        return s;
    }

    private static void CalculateHeightSound() {

        boolean flag;
        HeightSound heightSound = new HeightSound();
        do {
            System.out.print("Введите октаву: ");
            try {
                int a = Integer.parseInt(bufferedReader.readLine());
                switch (a) {
                    case 0:
                        heightSound.setOctave(Octave.SubContrOctave);
                        flag = false;
                        break;
                    case 1:
                        heightSound.setOctave(Octave.ContrOctave);
                        flag = false;
                        break;
                    case 2:
                        heightSound.setOctave(Octave.Large);
                        flag = false;
                        break;
                    case 3:
                        heightSound.setOctave(Octave.Small);
                        flag = false;
                        break;
                    case 4:
                        heightSound.setOctave(Octave.First);
                        flag = false;
                        break;
                    case 5:
                        heightSound.setOctave(Octave.Second);
                        flag = false;
                        break;
                    case 6:
                        heightSound.setOctave(Octave.Third);
                        flag = false;
                        break;
                    case 7:
                        heightSound.setOctave(Octave.Fourth);
                        flag = false;
                        break;
                    case 8:
                        heightSound.setOctave(Octave.Fifth);
                        flag = false;
                        break;
                    default:
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                flag = true;
            }
        } while (flag);
        do {
            System.out.print("Введите звук: ");
            try {
                int a = Integer.parseInt(bufferedReader.readLine());
                switch (a) {
                    case 0:
                        heightSound.setSound(Sound.Do);
                        flag = false;
                        break;
                    case 1:
                        heightSound.setSound(Sound.Re);
                        flag = false;
                        break;
                    case 2:
                        heightSound.setSound(Sound.Mi);
                        flag = false;
                        break;
                    case 3:
                        heightSound.setSound(Sound.Fa);
                        flag = false;
                        break;
                    case 4:
                        heightSound.setSound(Sound.Solt);
                        flag = false;
                        break;
                    case 5:
                        heightSound.setSound(Sound.Lya);
                        flag = false;
                        break;
                    case 6:
                        heightSound.setSound(Sound.Si);
                        flag = false;
                        break;
                    default:
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                flag = true;
            }
        } while (flag);
        do {
            System.out.print("Введите прибавку: ");
            try {
                int a = Integer.parseInt(bufferedReader.readLine());
                switch (a) {
                    case 0:
                        heightSound.setSignsOfAlteration(SignsOfAlteration.Diez);
                        flag = false;
                        break;
                    case 1:
                        heightSound.setSignsOfAlteration(SignsOfAlteration.Bemol);
                        flag = false;
                        break;
                    case 2:
                        heightSound.setSignsOfAlteration(SignsOfAlteration.No);
                        flag = false;
                        break;
                    default:
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                flag = true;
            }
        } while (flag);
        System.out.println(String.format("Частота: %f", Frequency(heightSound)));
    }

    private static double Frequency(HeightSound heightSound) {
        double frequency = 440;
        double semitone = 1.05946;
        for (int i = Octave.First.ordinal() - 1; i >= heightSound.getOctave().ordinal(); i--) {
            frequency /= 2;
        }
        for (int i = Octave.First.ordinal() + 1; i <= heightSound.getOctave().ordinal(); i++) {
            frequency *= 2;
        }
        if (heightSound.getSound().equals(Sound.Si))
            frequency *= semitone * semitone;
        else {
            for (int i = Sound.Lya.ordinal() - 1; i >= heightSound.getSound().ordinal(); i--) {
                if (i == Sound.Mi.ordinal())
                    frequency /= semitone;
                else frequency /= (semitone * semitone);
            }
        }
        if (heightSound.getSignsOfAlteration().equals(SignsOfAlteration.Diez))
            frequency*=semitone;
        else if (heightSound.getSignsOfAlteration().equals(SignsOfAlteration.Bemol))
            frequency/=semitone;
        return frequency;
    }


    private static int Input() {
        try {
            System.out.print("Выберите пункт меню: ");
            int index = Integer.parseInt(bufferedReader.readLine());
            if (index < 0) throw new Exception();
            else return index;
        } catch (Exception e) {
            return Input();
        }
    }

    public static void main(String[] args){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean lock = true;
        while (lock) {
            System.out.println("Меню:");
            System.out.println("1-2. Факториал");
            System.out.println("4. Фибоначчи");
            System.out.println("6. Возведение в куб без операции умножения");
            System.out.println("7. Извлечение корня из действительных чисел");
            System.out.println("8. Корень из натуральных чисел");
            System.out.println("11. Треугольник Паскаля");
            System.out.println("12. Треугольник");
            System.out.println("14. Разрезание прямоугольника на квадраты");
            System.out.println("17. Уравнение");
            System.out.println("19. Считалка");
            System.out.println("20. Дележ");
            System.out.println("21. НОД");
            System.out.println("22. Взаимно простые числа");
            System.out.println("23. НОК");
            System.out.println("24. Бильярд");
            System.out.println("25. Делители");
            System.out.println("28. Разложение на простые множители");
            System.out.println("29. Эрастофеново решето");
            System.out.println("30. Близнецы");
            System.out.println("31. Скатерть Улама");
            System.out.println("32. Совершенные числа");
            System.out.println("33. Дружественные числа");
            System.out.println("35. Автоморфные числа");
            System.out.println("36. Нумерация книжных страниц");
            System.out.println("38. Сумма кубов цифр");
            System.out.println("39. Числа Армстронга");
            System.out.println("42. Перестановка с уменьшением");
            System.out.println("52. Десятичные дроби");
            System.out.println("55. Высота музыкального звука");
            System.out.println("0. Выход");
            switch (Input()) {
                case 0:
                    lock = false;
                    break;
                case 1:
                case 2:
                    CalculateFactorial(MaxFactorial());
                    break;
                case 4:
                    CalculateFibonachchi(MaxFibonachchi());
                    break;
                case 6:
                    CalculateCube(MaxCube());
                    break;
                case 7:
                    CalculateRootFromNumber();
                    break;
                case 8:
                    CalculateRootFromNaturalNumber();
                    break;
                case 11:
                    CalculateTriangleOfPascal();
                    break;
                case 12:
                    CalculateTriangle();
                    break;
                case 14:
                    CalculateCutRectangle();
                    break;
                case 17:
                    CalculateEquation();
                    break;
                case 19:
                    CalculateSchitalka();
                    break;
                case 20:
                    CalculateSharing();
                    break;
                case 21:
                    CalculateNOD();
                    break;
                case 22:
                    CalculateMutuallySimpleNumbers();
                    break;
                case 23:
                    CalculateNOK();
                    break;
                case 24:
                    CalculateBilliards();
                    break;
                case 25:
                    CalculateDividers();
                    break;
                case 28:
                    CalculateMultipliers();
                    break;
                case 29:
                    CalculateErastofen();
                    break;
                case 30:
                    CalculateTwins();
                    break;
                case 31:
                    CalculateCloth();
                    break;
                case 32:
                    CalculatePerfectNumbers();
                    break;
                case 33:
                    CalculateFriendlyNumbers();
                    break;
                case 35:
                    CalculateAutoMorfNumbers();
                    break;
                case 36:
                    CalculateNumberingOfPages();
                    break;
                case 38:
                    CalculateCubeSum();
                    break;
                case 39:
                    CalculateNumbersArmstrong();
                    break;
                case 42:
                    CalculateZ42();
                    break;
                case 52:
                    CalculateDecimal();
                    break;
                case 55:
                    CalculateHeightSound();
                    break;
                default:
                    break;
            }
            try {
                bufferedReader.readLine();
            } catch (IOException e) {
            }
        }
    }
}