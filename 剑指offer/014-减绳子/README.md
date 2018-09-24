# 014-减绳子
## 题目：
给你一根长度为n的绳子，把它剪成m段，求m段绳子长度的乘积最大是多少。

## 思路：
1. n = 2时，只能剪成 1 * 1 的两段；
2. n = 3时，剪成 1 * 2 的两段大于 1 * 1 * 1三段；
3. n >= 5时，多剪长度为3的可以得到乘积更大；
4. 剩下长度为4时，多剪长度为2的可以得到乘积更大。

```Java
public class N014 {
    public int max(int length){
        if (length < 2){
            return 0;
        }
        if (length == 2){
            return 1;
        }
        if (length == 3){
            return 2;
        }
        //尽可能多减长度为3的绳子段
        int timesOf3 = length / 3;
        //如果剪完长度为3的绳子段后留下了1米，则少减1段，留下4米
        //剪成2段2米的，因为2*2 > 3*1
        if (length - timesOf3 * 3 == 1){
            timesOf3 -= 1;
        }

        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)(Math.pow(3, timesOf3) * (int)(Math.pow(2, timesOf2)));
    }
}
```
