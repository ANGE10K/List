import java.util.Random;

public class hjbnv {
    public static void main(String[] args) {
        int[] a = new int[100];
        Random r = new Random();



        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1000);
        }
        int max = Max(a);
        System.out.println(max);
    }

    public static int Max(int[] b) {
        int max = b[0];
        for (int i = 0; i < b.length; i++) {
            if (max < b[i]) {
                max = b[i];
            }

        }

        return max;
    }
}

