public class Sort {

    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length - 1; i++){//外层循环控制排序趟数
            for(int j = 0;j < arr.length - 1 - i; j++){//内层循环控制每一趟排序多少次
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectsort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0;i < arr.length;i++){
            int index = i;//初始下标为i
            for(int j = i+1;j < arr.length;j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            if(index != i){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertSort(int[] a) {
        for(int i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            int temp = a[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            int j = i - 1;
            while (j >= 0 && temp < a[j]) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            a[j + 1] = temp;// 直到要插入的元素不小于第j个元素,将temp插入到数组中
        }
    }


    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr,int low,int high){
        if(low > high){
            return ;
        }
        int i = low, j = high,temp = arr[low];
        while(i < j){
            while( arr[j] >= temp && i < j){
                j--;
            }
            arr[i] = arr[j];
            while(arr[i] <= temp && i < j){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[j] = temp;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);
    }


    public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }

    /**
     * 归并排序
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i <= mid && j <= high){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i <= mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j <= high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x = 0;x < temp.length; x++){
            a[x+low] = temp[x];
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr) {
        MeakHeap(arr, arr.length);
        for (int i = arr.length - 1; i >= 0; i--){
            swap(arr, 0 , i);
            Adjust(arr, 0 , i);
        }
    }
    public static void MeakHeap(int[] arr , int n){
        for (int i = n / 2 - 1; i >= 0; i--){
            Adjust(arr , i , n);
        }
    }

    public static void Adjust(int[] arr , int i ,int n){
        int j = 2 * i + 1;
        while ( j < n){
            if (j + 1 < n && arr[j] > arr[j + 1]){
                j++;
            }
            if ( arr[i] < arr[j]){
                break;
            }
            i = j;
            j = 2 * i + 1;
        }
    }

    //交换
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 基数排序
     */
    public class RadixSort {
        // 各位装通法
        public int[] radixSort(int[] A, int n) {
            int length = n;
            int divisor = 1;// 定义每一轮的除数，1,10,100...
            //定义了10个桶，以防每一位都一样全部放入一个桶中
            int[][] bucket = new int[10][length];
            int[] count = new int[10];// 统计每个桶中实际存放的元素个数
            int digit;// 获取元素中对应位上的数字，即装入那个桶
            for (int i = 1; i <= 3; i++) {// 经过4次装通操作，排序完成
                for (int temp : A) {// 计算入桶
                    digit = (temp / divisor) % 10;
                    bucket[digit][count[digit]++] = temp;
                }
                int k = 0;// 被排序数组的下标
                for (int b = 0; b < 10; b++) {// 从0到9号桶按照顺序取出
                    if (count[b] == 0)// 如果这个桶中没有元素放入，那么跳过
                        continue;
                    for (int w = 0; w < count[b]; w++) {
                        A[k++] = bucket[b][w];
                    }
                    count[b] = 0;// 桶中的元素已经全部取出，计数器归零
                }
                divisor *= 10;
            }
            return A;
        }
    }
}
