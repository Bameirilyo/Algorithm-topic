# 021-调整数组顺序使奇数位于偶数前面

```Java
public class N021 {
    /**
     * 法一，类似于快排，实现可扩展
     * @param arr
     */
    private static void Reorder(int[] arr){
        if (arr == null){
            return ;
        }
        int left = 0;
        int right = arr.length - 1;
        while ( left < right){
            //向右移动指针，直到指向偶数
            while (left < right && !isEven(arr[left])){
                left++;
            }
            //向左移动指针，直到指向奇数
            while (left < right && !isEven(arr[right])){
                 right--;
            }
            if (left < right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
            if (left >= right){
                break;
            }
        }
    }
    //判断是否偶数，实现代码解耦
    private static boolean isEven(int n){
        return (n & 0x1) == 0;
    }


    /**
     * 法二，类似于冒泡
     * @param arr
     */
    public void reOrderArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] % 2 == 0 && arr[j + 1] % 2 == 1){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```