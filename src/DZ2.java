import java.util.Random;

public class DZ2 {
    public static void main(String[] args) {
        Random r = new Random();
        boolean a;
        boolean b;
        int c = 2;
        int h1 = 4;
        int j1 = 3;
        int j2 = 10;
        boolean d1;
        int[] g = new int[10];
        int[] g1 = new int[10];
        int[] f1 = new int[10];
        int[] f = new int[10];
        int[] u = new int[10];
        int[] h = new int[10];
        int[] j = new int[10];
        int[] y = new int[10];
        for (int i = 0; i < y.length; i++) {
            y[i] = r.nextInt(100);
        }
        for (int i = 0; i < j.length; i++) {
            j[i] = r.nextInt(100);
        }
        for (int i = 0; i < h.length; i++) {
            h[i] = r.nextInt(100);
        }
        for (int i = 0; i < g.length; i++) {
            g[i] = r.nextInt(100);
        }
        for (int i = 0; i < f.length; i++) {
            f[i] = r.nextInt(100);
        }
        for (int i = 0; i < u.length; i++) {
            u[i] = r.nextInt(100);
        }
        for (int d = 0; d < y.length; d++) {
            System.out.print(y[d] + " ");
        }
        a = even(u);
        b = simple(j1);
        h = change(h, c, h1);
        j = subArray(j, j1, j2);
        y = gh(y);
        g1 = del(g, c);
        f1 = left(f);
        if (a)
            System.out.println("Сумма четных элементов в массиве больше,чем нечетных");
        else System.out.println("Сумма нечетных элементов в массиве больше,чем четных");
        if (b)
            System.out.println("Число " + j1 + " является простым");
        else System.out.println("Число " + j1 + " не является простым");
        System.out.print("Простые числа в диапазоне 1 до 100: ");
        for (int d = 1; d <= 100; d++) {
            d1 = simple(d);
            if (d1) {
                System.out.print(d + " ");
            }
        }
        System.out.println();
        System.out.print("Массив с заменой элемента под индексом " + h1 + " на число " + c + ": ");
        for (int d = 0; d < h.length; d++) {
            System.out.print(h[d] + " ");
        }
        System.out.println();
        System.out.print("Часть массива, которая заключена между индексами " + j1 + " и " + j2 + ": ");
        for (int d = 0; d < j.length; d++) {
            System.out.print(j[d] + " ");
        }
        System.out.println();
        System.out.print("Массив, в котором сначала идут четные элементы, а потом нечетные: ");
        for (int d = 0; d < y.length; d++) {
            System.out.print(y[d] + " ");
        }
        System.out.println();
        for (int d = 0; d < g.length; d++) {
            System.out.print(g[d] + " ");
        }
        System.out.println();
        System.out.print("Массив с удаленным элементом под индексом " + c + ": ");
        for (int d = 0; d < g1.length; d++) {
            System.out.print(g1[d] + " ");
        }
        System.out.println();
        System.out.print("Массив с сдвигом всех элеменов на одно значение влево: ");
        for (int d = 0; d < f1.length; d++) {
            System.out.print(f1[d] + " ");
        }
    }

    public static boolean even(int[] a) {
        int sum1 = 0;
        int sum2 = 0;
        for (int b = 0; b < a.length; b = b + 2) {
            sum1 = sum1 + a[b];
        }
        for (int b = 1; b < a.length; b = b + 2) {
            sum2 = sum2 + a[b];
        }
        if (sum1 > sum2) {
            return true;
        } else return false;
    }

    public static boolean simple(int a) {
        for (int b = 2; b < 100; b++) {
            if (a == 1)
                return false;

            if (a % b == 0 & a != b) {
                return false;
            }
        }
        return true;
    }

    public static int[] del(int[] a, int b) {
        int[] c = new int[a.length - 1];
        int h = 0;
        for (int f = 0; f < c.length; f++) {
            if (f != b) {
                c[f] = a[h];
                h++;
            } else {
                c[f] = a[h + 1];
                h = h + 2;
            }
        }
        return c;
    }

    public static int[] left(int[] a) {
        int[] c = new int[a.length];
        int g = 0;
        c[a.length - 1] = a[0];
        for (int b = 1; b < a.length; b++) {
            c[g] = a[b];
            g++;
        }
        return c;
    }

    public static int[] change(int[] a, int b, int c) {
        int[] a1 = new int[a.length + 1];
        int f1 = 0;
        for(int f = 0; f < a1.length - 1; f++){
            if (f == c){
                a1[c] = b;
                f1++;
            }
                a1[f1] = a[f];
                f1++;
        }
        return a1;
    }

    public static int[] subArray(int[] a, int b, int c) {
        int[] a1 = new int[c - b - 1];
        for (int f = 0; f < a1.length; f++) {
            a1[f] = a[b + f + 1];
        }
        return a1;
    }

    public static int[] gh(int[] a) {
        int[] c = new int[a.length];
        int g = 0;
        int g1 = 0;
        for (int b = 0; g < a.length / 2; b = b + 2) {
            c[g] = a[b];
            g++;
        }
        for (int b = 1; g1 < a.length / 2; b = b + 2) {
            c[a.length / 2 + g1] = a[b];
            g1++;
        }
        return c;
    }
}
