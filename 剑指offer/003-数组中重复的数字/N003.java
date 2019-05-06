//不修改数组找出重复的数
public class N003 {
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
        N003 test = new N003();
        int[] arr = {0,3,5,4,1,2,6,7,0};
        int value = test.getDuplication(arr);
        System.out.print(value);
    }
}
