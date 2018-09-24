# 010-斐波那契数列

```Java
public class N010 {
    public static long fib(int n){
        int[] arr ={1,2};
        if (n < 2){
            return arr[n];
        }
        long fib1 = 0;
        long fib2 = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++){
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }
}
```

# 青蛙跳台阶问题
## 问题：
一直青蛙一次可以跳1级台阶，也可以跳2级台阶。求该青蛙跳上n级台阶一共有几种跳法。

## 思路：
将问题分解，n>2时，可以分解成第一次跳一级，后面的n-1个台阶的跳法f(n-1) 加上 第一次跳两级，后面的n-2个台阶的跳法f(n-2)，
即f(n) = f(n - 1) + f(n - 2)。

```Java
public static long solution(int n){
        int[] arr ={1,2};
        if (n < 2){
            return arr[n];
        }
        long fib1 = 1;
        long fib2 = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++){
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }
   ```
