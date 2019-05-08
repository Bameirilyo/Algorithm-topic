# 若干次操作使三个数变成一样大

## 题目：

输入三个数x,y,z，经过若干次操作使三个数变成一样大

操作一：选择其中两个数加1；

操作二：选择其中一个数加2；

输出最少的操作次数

## 思路：

贪心，首先对三个数进行排序。从小到大为xyz，

①如果xy之间差距为偶数，通过对x＋2就使得xy相等，然后，对xy分别+1，使得xyz相等。

②如果 xy之间为奇数，那么就通过对xy分别+1，使得y=z。此时如果x和Z之间差距为偶数，那么就对x加2，使得XYZ相等；如果x和Z之间差距为奇数，那么就x加2，使得X比zy都大1，然后对yz分别加1，使xyz相等 。

假设为2 5 8，那么由②可以变为 5 8 8，然后根据③，变化为 9 8 8，然后变化为 9 9 9。

````Java
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
````
