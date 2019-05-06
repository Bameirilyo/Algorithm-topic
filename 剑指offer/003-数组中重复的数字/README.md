# 003-数组中重复的数字

//不修改数组找出重复的数字

## 题目
在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2或3。

```Java
    //不修改数组找出重复的数
    public class Test {
        public int getDuplication(int[] arr)
        {
            for(int i = 0;i < arr.length;i++)
            {
                if(arr[i] < 0 || arr[i] >= arr.length)
                    throw new IllegalArgumentException("输入参数不合法");
            }
            int start = 0;
            int end = arr.length-1;
            int middle = 0;
            while(end >= start) {
                middle = (end + start)/2;
                int count = countRange(arr,start,middle);
                if(end == start) {
                    if(count > 1)
                        return start;
                    else
                        break;
                }
                if(count > (middle-start+1))//说明(start,middle)这个区间有重复的数
                    end = middle;
                else
                    start = middle + 1;
            }
            return -1;
        }
    
        private int countRange(int[] arr, int start, int end)
        {
            int count = 0;
            for(int i = 0;i < arr.length;i++)
            {
                if(arr[i] >= start && arr[i] <= end)
                    ++count;
            }
            return count;
        }
    
        public static void main(String[] args) {
            Test test = new Test();
            int[] arr = {0,3,5,4,1,2,6,7,0};
            int value = test.getDuplication(arr);
            System.out.print(value);
        }
    }
```

