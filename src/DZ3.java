import java.util.Random;

public class DZ3 {
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 7, 9, 75, 53, 53, 13, 765, 23, 654, 31, 2321, 1423};
        int a1;
        System.out.print("Массив, в котором нам надо найти второе максимальное число: ");
        for (int b = 0; b < a.length; b++) {
            if (b >= 1) {
                System.out.print(",");
            }
            System.out.print(a[b] + " ");
        }
        a1 = second(a);
        System.out.println();
        System.out.print("Второе максимально число массива: " + a1);
        int[] b = new int[] {-176, 2, 356, -4, 775, 9, -75, 53, -53, 13, -765, 23, 654, -31, 21, 1423};
        System.out.println();
        System.out.print("Массив, в котором нам надо, чтобы отрицательные числа шли в начале массива: ");
        for (int b1 = 0; b1 < b.length; b1++) {
            if (b1 >= 1) {
                System.out.print(",");
            }
            System.out.print(b[b1] + " ");
        }
        b = order(b);
        System.out.println();
        System.out.print("Результат: ");
        for (int b1 = 0; b1 < b.length; b1++) {
            if (b1 >= 1) {
                System.out.print(",");
            }
            System.out.print(b[b1] + " ");
        }
        int[] c = new int[] {-176, 2, 356, -4, 775, 9, -75, 53, -53, 13, -765, 23, 654, -31, 21, 1423};
        System.out.println();
        System.out.print("Массив, в котором нам надо сдвинуть все эелементы вправо: ");
        for (int b1 = 0; b1 < c.length; b1++) {
            if (b1 >= 1) {
                System.out.print(",");
            }
            System.out.print(c[b1] + " ");
        }
        c = right(c);
        System.out.println();
        System.out.print("Результат: ");
        for (int b1 = 0; b1 < c.length; b1++) {
            System.out.print(c[b1] + ", ");
        }
        int[][] d = new int[][] {{1, 3, 43}, {34, 1, 53}, {45, 0, 65}};
        int[][] d1 = new int[][] {{42, 0, 32,}, {1, 5, 31}, {64, 5, 3}};
        int[][] d2 = new int[d.length][d1[0].length];
        d2 = matrix(d, d1);
        System.out.println();
        System.out.println("Произведение двух матриц: ");
        for (int d3 = 0; d3 < d.length; d3++) {
            for (int d4 = 0; d4 < d[0].length; d4++) {
                System.out.print(" " + d[d3][d4] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int d3 = 0; d3 < d1.length; d3++) {
            for (int d4 = 0; d4 < d1[0].length; d4++) {
                System.out.print(" " + d1[d3][d4] + " ");
            }
            System.out.println();
        }
        System.out.println("Результат: ");
        for (int d3 = 0; d3 < d2.length; d3++) {
            for (int d4 = 0; d4 < d2[0].length; d4++) {
                System.out.print(" " + d2[d3][d4] + " ");
            }
            System.out.println();
        }
        System.out.println();
        String g = "abcba";
        boolean g1;
        System.out.println("Строка, которую мы проверяем::" + g);
        g1 = palindrome(g);
        if (g1) {
            System.out.println("Является палиндромом");
        } else System.out.println("Не является палиндромом");
    }

    public static int second(int[] a) {
        int max = a[0];
        int second = 0;
        for (int b = 0; b < a.length; b++) {
            if (a[b] > max) {
                second = max;
                max = a[b];
            }
            if (a[b] > second && a[b] != max) {
                second = a[b];
            }
        }
        return second;
    }

    public static int[] order(int[] a) {
        int b;
        int b1 = 0;
        int b2 = 0;
        for (int c = 0; c < a.length; c++) {
            if (a[c] < 0) {
                b1 = c;
                b = a[c];
                for (int c1 = b2; c1 < c; c1++) {
                    a[b1] = a[b1 - 1];
                    b1--;
                }
                a[b2] = b;
                b2++;
            }
        }
        return a;
    }

    public static int[] right(int[] a) {
        int b = 0;
        int b1;
        b = a[a.length - 1];
        for (int c = 1; c < a.length; c++) {
            a[a.length - c] = a[a.length - c - 1];
        }
        a[0] = b;
        return a;
    }

    public static int[][] matrix(int[][] a, int[][] b) {
        int[][] f = new int[a.length][b[0].length];
        for (int c = 0; c < f[0].length; c++) {
            for (int c1 = 0; c1 < f.length; c1++) {
                for (int c2 = 0; c2 < a[0].length; c2++)
                    f[c][c1] = f[c][c1] + a[c][c2] * b[c2][c1];
            }
        }
        return f;
    }

    public static boolean palindrome(String a) {
        int b = a.length();
        for (int i = 0; i < (b / 2); i++) {
            if (a.charAt(i) != a.charAt(b - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
