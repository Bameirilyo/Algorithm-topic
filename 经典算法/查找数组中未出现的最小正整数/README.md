# 查找数组中未出现的最小正整数

## 题目：

给定一个整数数组A和数组的大小n，请返回数组中未出现的最小正整数。保证数组大小小于等于500。

测试样例：[-1,2,3,4],4

返回：1

## 分析：

最小的没有出现的正整数：如果1没有出现,那么最小结果为1；如果1到n都出现，那么最下的结果为n+1；因此结果的范围1～n+1。数据范围最大500数据不是很大，可以考虑以空间换时间的做法。

定义一个数组res[n]，遍历数组A，如果A[i]>n抛弃，不会是结果；如果A[i]<n，令res[A[i]-1]=1; 遍历res 为0的输出下标加1，即为结果

````Java
public class FindArrayMex {
    public int findArrayMex(int[] A, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n){
                res[A[i]-1] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == 0){
                return i+1;
            }
        }
        return n+1;
    }
}
````
