# 元素互不相邻的最大和子数组
## 题目
对于一个给定的数组，在其中选取其子数组，要求相邻的元素不能选取，且要保证选出的子数组元素和最大。输入数组长度及其元素，输出所选子数组的和。

测试输入

7

4 2 6 1 3 5 8

测试输出

21 (4 + 6 + 3 + 8 = 21)

## 分析
为了让子数组和最大，应该尽可能让它包含更多的元素，并且相邻元素不能选取，所以选取的任意两个数字之间最多间隔两个数，因为假设如果间隔了三个而子数组和最大，那么最中间的那个数一定可以选中，此时子数组和也一定比之前更大，产生矛盾。由此可见，本题只需要分析连续的三个元素的关系即可。

按照第i个元素是否被选取，前i个元素的和要么与前i−1个元素的和相同(不选取)，要么是前i−2个元素的和加上此第i个元素(选取)，这两种情况取最大。这很容易通过递归实现出来，也可以使用动态规划实现。要用动态规划，子问题的选取需要具有无后效性，即前i个元素的选取只能和之前的选取有关，和未来的情况无关。对于数组array[i]，i=0∼n−1，定义s[i]表示前i个元素的最大和，则递归式为

 i = 0, s[i] = 0;
 
 i = 1, s[i] = array[0];
 
 2 ≤ i ≤ n, s[i] = max(s[i−1],s[i−2]+array[i])
 
 ````Java
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
 ````
 
 
## 将上述的数组变成一个环，其他条件保持不变。
 测试输入
 
 7
 
 4 2 6 1 3 5 8
 
 测试输出
 
 17 (8 + 3 + 6 =17)
 
 ## 分析2
 对于环的情况，仍然可以利用上述直线的方法完成，只是有一些变化。首先要保证首尾元素不能同时选取，它们也属于相邻元素，这可以通过构造最优解来判断：如果首尾元素同时选取，则删除尾元素而保留首元素；其次为了找到所有可取的情况，需要对数组不断进行循环移位，从每一个元素开始，找出能够取得的最大和。这里对数组的循环移位实际上只需要做两次即可，因为我们求解s[i]时，只与s[i−1]和s[i−2]有关，环上的每一个元素位置等价，即都要能够成为这三项中的任意一项，这里位置不等价的只有四个元素：首位元素不能成为s[i−1]和s[i]，第二元素不能成为s[i]，而倒数第二元素不能成为s[i−2]，末尾元素不能成为s[i−2]和s[i−1]。所以为了满足环上元素位置等价的条件，只需要再循环移动数组两次即可，最后比较这三种情况取最大值。
 
````Java
import java.util.Scanner;

public class NotAdjacentCircle {
    static int solution(int[] array, int n) {
        int[] s = new int[n + 1];
        boolean[] isUsed = new boolean[n];// 元素是否使用，用于构造最优解
        s[0] = 0;
        s[1] = array[0];
        isUsed[0] = true;
        for (int i = 2; i < n + 1; i++) {
            int takei = s[i - 2] + array[i - 1];
            int skipi = s[i - 1];
            if (takei > skipi) {
                s[i] = takei;
                isUsed[i - 1] = true;
            } else {
                s[i] = skipi;
                isUsed[i - 1] = false;
            }
        }
        return makeCircle(s, isUsed, n);
    }

    static int makeCircle(int[] s, boolean[] isUsed, int n) {
        if (!isUsed[n - 1]) return s[n];// 最后一个元素没用，首尾不会相邻
        int i = n - 1;
        boolean isFirstUsed = false;// 第一个元素是否使用
        while (i >= 0) {// 构造最优解的过程
            if (isUsed[i]) {
                if (i == 0) isFirstUsed = true;
                i -= 2;
            } else {
                i -= 1;
            }
        }
        return isFirstUsed ? s[n - 1] : s[n];// 如果首尾相邻，则删除尾元素
    }

    static int[] leftShift(int[] array, int steps) {
        int n = array.length;
        int[] newArray = new int[n];
        System.arraycopy(array, steps, newArray, 0, n - steps);
        System.arraycopy(array, 0, newArray, n - steps, steps);
        return newArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int r1 = circleSolution(array, n);
        array = leftShift(array, 1);
        int r2 = circleSolution(array, n);
        r2 = Math.max(r1, r2);
        array = leftShift(array, 1);
        int r3 = circleSolution(array, n);
        r3 = Math.max(r2, r3);
        System.out.println(r3);
    }
}
````
