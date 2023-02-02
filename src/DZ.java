import java.sql.SQLOutput;
import java.util.Random;

public class DZ {
    public static void main(String[] args) {
        String s;
        String y;
        String p;
        int b = -213;
        int a = 2;
        int v = 5;
        int z = 3;
        int g = 4;
        int h = 3;
        int w = 5;
        int k = 2;
        int[] u = new int[100];
        Random r = new Random();
        for (int i = 0; i < u.length; i++) {
            u[i] = r.nextInt(100);
        }
        int mod = Module(b);
        int max = Max(a, v, z);
        boolean del = Delta(a, v, z);
        boolean Cir = Circle(g, w, k, h, z);
        boolean scan = Scan(u, z);
        if (del) {
            s = "существует";
        } else s = "не существует";
        if (Cir) {
            y = "лежит";
        } else y = "не лежит";
        if (scan) {
            p = "находится";
        } else p = "не находится";
        System.out.print("Модуль числа: " + b + "  равен: " + mod);
        System.out.println();
        System.out.print("Максимальное число из: " + a + ", " + v + ", " + z + "  равняется: " + max);
        System.out.println();
        System.out.println("Треугольник со сторонами: " + a + ", " + v + ", " + z + " " + s);
        System.out.print("Точка с координатами: x = " + g + " y = " + w + " " + y + " на окружности с координатами цетра x = " + h + " y = " + z + " и с радиусом " + k);
        System.out.println();
        System.out.print("Число " + z + " " + p + " в массиве");
    }

    public static int Module(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }

    public static int Max(int a, int c, int b) {
        int max = a;
        if (a < b) {
            max = b;
        } if (a < c) {
            max = c;
        } if (c < b) {
            max = b;
        }
        return max;

    }

    public static boolean Delta(int a, int c, int b) {
        if (a + c <= b) {
            return false;
        } else if (a + b <= c) {
            return false;
        } else if (b + c <= a) {
            return false;
        }
        return true;
    }

    public static boolean Circle(int x, int y, int r, int x2, int y2) {
        if ((x - x2) * (x - x2) + (y - y2) * (y - y2) < r * r) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean Scan(int[] a, int b) {
        for (int f = 0; f < a.length; f++) {
            if (a[f] == b) {
                return true;
            }
        }
        return false;
    }
}
