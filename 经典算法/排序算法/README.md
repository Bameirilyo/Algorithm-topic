# 排序算法

**内排序有可以分为以下几类：**

(1)、插入排序：直接插入排序、二分法插入排序、希尔排序。 
(2)、选择排序：简单选择排序、堆排序。 
(3)、交换排序：冒泡排序、快速排序。 
(4)、归并排序 
(5)、基数排序

|   排序方法   |       平均情况       |       最好情况       |       最坏情况       |      空间复杂度      | 稳定性 |
| :----------: | :------------------: | :------------------: | :------------------: | :------------------: | :----: |
|   插入排序   |   O(n<sup>2</sup>)   |         O(n)         |   O(n<sup>2</sup>)   |         O(1)         |  稳定  |
|  shell排序   |  O(n<sup>1.3</sup>)  |         O(n)         |   O(n<sup>2</sup>)   |         O(1)         | 不稳定 |
|   选择排序   |   O(n<sup>2</sup>)   |   O(n<sup>2</sup>)   |   O(n<sup>2</sup>)   |         O(1)         | 不稳定 |
|    堆排序    | O(nlog<sub>2</sub>n) | O(nlog<sub>2</sub>n) | O(nlog<sub>2</sub>n) |         O(1)         | 不稳定 |
|   冒泡排序   |   O(n<sup>2</sup>)   |         O(n)         |   O(n<sup>2</sup>)   |         O(1)         |  稳定  |
|   快速排序   | O(nlog<sub>2</sub>n) | O(nlog<sub>2</sub>n) |   O(n<sup>2</sup>)   | O(nlog<sub>2</sub>n) | 不稳定 |
|   归并排序   | O(nlog<sub>2</sub>n) | O(nlog<sub>2</sub>n) | O(nlog<sub>2</sub>n) |         O(n)         |  稳定  |
|   基数排序   |      O(d(r+n))       |      O(d(r+rd))      |      O(d(r+n))       |       O(rd+n)        |  稳定  |
| 注：基数排序 |  r表示关键字的基数   |      d代表长度       |  n代表关键字的个数   |                      |   -    |





# O（n<sup>2</sup>）排序

## 冒泡排序

**基本思想：**比较数组相邻的两个值，把大的像泡泡一样“冒”到数组后面去，一共要执行N的平方除以2这么多次的比较和交换的操作（N为数组元素），其复杂度为Ο(n²)。

```java
public static void bubbleSort(int[] arr){
    for(int i=0;i<arr.length-1;i++){//外层循环控制排序趟数
        for(int j=0;j<arr.length-1-i;j++){//内层循环控制每一趟排序多少次
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
}
```

## 选择排序

```java
public static void selectsort(int[] arr){
    if(arr == null || arr.length < 2){
        return;
    }
    for(int i=0;i<arr.length;i++){
        int index = i;//初始下标为i
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[index]){
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
```

## 插入排序

**基本思想：**每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。 

```java
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
```

## shell排序

**基本思想：**本质是插入排序，通过将数组数组的方式来将增加排序的速度，分组的方式第一次将数组的长度/2,第二次/4,当结果等于1的时候，那么将这个数组进行插入排序就完成了排序，当然分组时也是需要排序的。

```java
public static void shellSort(int[] a) {  
    // 将数组分组  
    for (int temp = a.length / 2; temp >= 1; temp /= 2) {  
        // 这里的思路和插入排序的思路相同，通过找到前一个的数大于或者小于来进行插入  
        for(int i = temp; i < a.length; i += temp) {  
            int temp = a[i];  
            int j = i - temp;  
            while(j >= 0 && temp < a[j]) {  
                a[j + temp] = a[j];  
                j -= temp;  
            }  
            a[j + temp] = temp; 
        }  
    }  
 }  
```



# O（nlog<sub>2</sub>n）排序

## 快速排序

```java
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
```
## 归并排序

**（1）稳定性：**归并排序是一种稳定的排序。
**（2）存储结构要求：**可用顺序存储结构。也易于在链表上实现。
**（3）时间复杂度：**对长度为n的文件，需进行趟二路归并，每趟归并的时间为O(n)，故其时间复杂度无论是在最好情况下还是在最坏情况下均是O(nlgn)。
**（4）空间复杂度：**需要一个辅助向量来暂存两有序子文件归并的结果，故其辅助空间复杂度为O(n)，显然它不是就地排序。

**注意：**若用单链表做存储结构，很容易给出就地的归并排序

```java
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
     
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组 
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }
```



## 堆排序

```java
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64};
        int arrayLength=a.length;
        //循环建堆
        for(int i=0;i<arrayLength-1;i++){
            //建堆
            buildMaxHeap(a,arrayLength-1-i);
            //交换堆顶和最后一个元素
            swap(a,0,arrayLength-1-i);
            System.out.println(Arrays.toString(a));
        }
    }
    //对data数组从0到lastIndex建大顶堆
    public static void buildMaxHeap(int[] data, int lastIndex){
        //从lastIndex处节点（最后一个节点）的父节点开始
        for(int i=(lastIndex-1)/2;i>=0;i--){
            //k保存正在判断的节点
            int k=i;
            //如果当前k节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点的左子节点的索引
                int biggerIndex=2*k+1;
                //如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if(biggerIndex<lastIndex){
                    //若果右子节点的值较大
                    if(data[biggerIndex]<data[biggerIndex+1]){
                        //biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                //如果k节点的值小于其较大的子节点的值
                if(data[k]<data[biggerIndex]){
                    //交换他们
                    swap(data,k,biggerIndex);
     //将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k=biggerIndex;
                }else{
                    break;
                }
            }
        }
    }
    //交换
    private static void swap(int[] data, int i, int j) {
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;
    }
}
```



# 基数排序

```java
import java.util.*;

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
```



# 总结

**1.若n较小(如n≤50)，可采用直接插入或直接选择排序。**
    　当记录规模较小时，直接插入排序较好；否则因为直接选择移动的记录数少于直接插人，应选直接选择排序为宜。*
**2.若文件初始状态基本有序(指正序)，则应选用直接插人、冒泡或随机的快速排序为宜；**
**3.若n较大，则应采用时间复杂度为O(nlgn)的排序方法：快速排序、堆排序或归并排序。**
**4.快速排序是目前基于比较的内部排序中被认为是最好的方法，当待排序的关键字是随机分布时，快速排序的平均时间最短；**
**5.堆排序所需的辅助空间少于快速排序，并且不会出现快速排序可能出现的最坏情况。这两种排序都是不稳定的。**
**6.若要求排序稳定，则可选用归并排序。**

7.若是身高、年龄，可使用计数排序。