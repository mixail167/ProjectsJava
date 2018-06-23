package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int ab = (a + b) / 2;
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

    private static void CalculateRootFromNaturalNumber(int max) {
        try {
            System.out.print(String.format("Введите число от 0 до %d: ", max));
            int x = Integer.parseInt(bufferedReader.readLine());
            System.out.print("Введите степень > 0: ");
            int m = Integer.parseInt(bufferedReader.readLine());
            if (x >= 0 && x <= max && m > 0) {
                int root = RootFromNaturalNumber(x, m);
                System.out.println(String.format("Корень степеи %d из числа %d: %d", m, x, root));
                System.out.println(String.format("Остаток: %d", Rest(root, x, m)));
            } else throw new Exception();
        } catch (Exception e) {
            CalculateRootFromNaturalNumber(max);
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


    public static void main(String[] args) throws IOException {
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
                    CalculateRootFromNaturalNumber(Integer.MAX_VALUE - 2);
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
                default:
                    break;
            }
            bufferedReader.readLine();
        }
    }
}
