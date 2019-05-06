public class N011 {
    public static int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int p1 = 0;//从前往后走
        int p2 = array.length-1;//从后往前走
        int index = 0;
        //当数组发生旋转了
        while(array[p1] >= array[p2]) {
            //当两个指针走到挨着的位置时，p2就是最小数了
            if(p2 - p1 == 1) {
                index = p2;
                break;
            }
            index = (p1 + p2)/2;
            //如果中间位置的数既等于p1位置的数又等于P2位置的数
            if(array[p1] == array[index] && array[p2] == array[index]) {
                return  minInorder(array,p1,p2);
            }
            //若中间位置的数位于数组1，让p1走到mid的位置
            if(array[p1] <= array[index]) {
                p1 = index;
            } else if(array[p2] >= array[index]) {
                //若中间位置的数位于数组2，让p2走到mid的位置
                p2 = index;
            }
        }
        //如果没发生旋转，直接将array[0]的值返回
        return array[index];
    }

    private static int minInorder(int[]array,int p1,int p2) {
        int result = array[p1];
        for (int i = p1 + 1; i <= p2; i++) {
            if(result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }
}
