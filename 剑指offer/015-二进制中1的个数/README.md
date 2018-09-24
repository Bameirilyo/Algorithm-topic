# 015-二进制中1的个数

## 题目：
输入一个整数，输出该数二进制中1的个数。比如，把9表示成二进制是1001，有2位是1。因此输入9，则输出2。

## 思路：
把一个数减去1，再和原整数做与运算，会把该整数最右边的1变成0。

```Java
public class N015 {
    public static int numberOfOne(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
```
