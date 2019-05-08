import java.util.Arrays;
import java.util.Scanner;

public class ThreeInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int x = arr[0], y = arr[1], z = arr[2];
        if ((y - x) % 2 == 0) {
            System.out.println((y - x) / 2 + z - y);
        } else {
            int sum1 = z - y;
            int sum2 = z - x - sum1;
            if (sum2 % 2 == 0) {
                System.out.println(sum1 + sum2 / 2);
            } else {
                System.out.println(sum1 + sum2 / 2 + 2);
            }
        }
    }
}
