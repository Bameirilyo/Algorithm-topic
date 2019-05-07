# 钱币拼凑（动态规划问题）

## 题目：
给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。

````Java
import java.util.Scanner;

public class QianBiPinCou {
    //拼凑面额
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = {1, 5, 10, 20, 50, 100};
        while (in.hasNext()) {
            int n = in.nextInt();
            long res[] = new long[n + 1];
            res[0] = 1L;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j >= arr[i]) {
                        res[j] += res[j - arr[i]];
                    }
                }
            }
            System.out.println(res[n]);
        }
    }
}

````
