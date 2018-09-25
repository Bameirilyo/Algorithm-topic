# 数组循环右移k位

## 思路：
1. 反转数组前n-k位元素；
2. 反转数组n-k+1至最后的所有元素；
3. 反转数组所有元素

```Java
public class xunhuanyouyi {
    private static void shift_method(int[] arr,int k) {
        int n = arr.length-1;
        k = k % n; //为了防止k>n ,右移K位和右移k%n的结果是一样的
        shift_method(arr, 0, n-k);
        shift_method(arr, n-k+1, n);
        shift_method(arr, 0, n);
        System.out.println("右移"+ k +"位的结果为：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    private static void shift_method(int array[],int begin,int end) {
        int temp;
        while (begin < end) {
            temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            begin++;
            end--;
        }
    }
}
```