import java.util.Scanner;

public class NotAdjacentLine {
    static int solution(int[] array, int n) {
        if (n < 1) return 0;
        if (n == 1) return array[0];
        return Math.max(solution(array, n - 1),
                solution(array, n - 2) + array[n - 1]);
    }

    static int solution2(int[] array, int n) {
        int[] s = new int[n + 1];
        s[0] = 0;
        s[1] = array[0];
        for (int i = 2; i < n + 1; i++) {
            int takei = s[i - 2] + array[i - 1];
            int skipi = s[i - 1];
            s[i] = Math.max(takei, skipi);
        }
        return s[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(solution2(array, n));
    }
}
